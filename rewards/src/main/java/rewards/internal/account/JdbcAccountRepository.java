package rewards.internal.account;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import common.money.MonetaryAmount;
import common.money.Percentage;

/**
 * Loads accounts from a data source using the JDBC API.
 */
public class JdbcAccountRepository extends SimpleJdbcDaoSupport implements AccountRepository {

	/**
	 * Extracts an Account object from rows returned from a join of T_ACCOUNT and T_ACCOUNT_BENEFICIARY.
	 */
	private ResultSetExtractor<Account> accountExtractor = new AccountExtractor();

	public Account findByCreditCard(String creditCardNumber) {
		String sql = "select a.ID as ID, a.NUMBER as ACCOUNT_NUMBER, a.NAME as ACCOUNT_NAME, c.NUMBER as CREDIT_CARD_NUMBER, b.NAME as BENEFICIARY_NAME, b.ALLOCATION_PERCENTAGE as BENEFICIARY_ALLOCATION_PERCENTAGE, b.SAVINGS as BENEFICIARY_SAVINGS " + 
			"from T_ACCOUNT a, T_ACCOUNT_BENEFICIARY b, T_ACCOUNT_CREDIT_CARD c where a.ID = b.ACCOUNT_ID and a.ID = c.ACCOUNT_ID and c.NUMBER = ?";
		return (Account) getJdbcTemplate().query(sql, new Object[] { creditCardNumber }, accountExtractor);
	}

	public void updateBeneficiaries(Account account) {
		String sql = "update T_ACCOUNT_BENEFICIARY SET SAVINGS = ? where ACCOUNT_ID = ? and NAME = ?";
		for (Beneficiary b : account.getBeneficiaries()) {
			getSimpleJdbcTemplate().update(sql, b.getSavings().asBigDecimal(), account.getEntityId(), b.getName());
		}
	}

	/**
	 * Map the rows returned from the join of T_ACCOUNT and T_ACCOUNT_BENEFICIARY to an fully-reconstituted Account
	 * aggregate.
	 * 
	 * @param rs the set of rows returned from the query
	 * @return the mapped Account aggregate
	 * @throws SQLException an exception occurred extracting data from the result set
	 */
	private Account mapAccount(ResultSet rs) throws SQLException {
		if (!rs.next()) {
			throw new EmptyResultDataAccessException(1);
		}

		Account account = null;
		// build out the account object graph from the returned rows
		do {
			if (account == null) {
				String number = rs.getString("ACCOUNT_NUMBER");
				String name = rs.getString("ACCOUNT_NAME");
				account = new Account(number, name);
				// set internal entity identifier (primary key)
				account.setEntityId(rs.getLong("ID"));
			}
			account.restoreBeneficiary(mapBeneficiary(rs));
		} while (rs.next());
		return account;
	}

	/**
	 * Maps the beneficiary columns in a single row to an AllocatedBeneficiary object.
	 * 
	 * @param rs the result set with its cursor positioned at the current row
	 * @return an allocated beneficiary
	 * @throws SQLException an exception occurred extracting data from the result set
	 */
	private Beneficiary mapBeneficiary(ResultSet rs) throws SQLException {
		String name = rs.getString("BENEFICIARY_NAME");
		MonetaryAmount savings = MonetaryAmount.valueOf(rs.getString("BENEFICIARY_SAVINGS"));
		Percentage allocationPercentage = Percentage.valueOf(rs.getString("BENEFICIARY_ALLOCATION_PERCENTAGE"));
		return new Beneficiary(name, allocationPercentage, savings);
	}

	private class AccountExtractor implements ResultSetExtractor<Account> {

		public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
			return mapAccount(rs);
		}

	}
}