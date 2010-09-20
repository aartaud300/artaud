/**
 * 
 */
package org.springframework.samples.mvc.basic;

import static org.junit.Assert.assertEquals;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import com.myshop.controller.account.AccountController;


/**
 * @author artaud
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={ "classpath*:/spring/app-config.xml","classpath*:/spring/mvc-config.xml"})
public class AccountControllerTest {

    protected final Log logger = LogFactory.getLog(getClass());

    
    private AccountController mAccountController;
	/**
	 * Test method for {@link com.myshop.controller.account.AccountController#getCreateForm(org.springframework.ui.Model)}.
	 */
	@Test
	public void testGetCreateForm() {
		
	}

	/**
	 * Test method for {@link com.myshop.controller.account.AccountController#create(com.myshop.controller.account.Account, org.springframework.validation.BindingResult)}.
	 */
	@Test
	public void testCreate() {
	
	}

	/**
	 * Test method for {@link com.myshop.controller.account.AccountController#getView(java.lang.Long, org.springframework.ui.Model)}.
	 */
	@Test
	public void testGetView() {
		
	}

}
