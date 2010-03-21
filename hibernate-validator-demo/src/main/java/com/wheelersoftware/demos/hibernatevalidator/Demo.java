package com.wheelersoftware.demos.hibernatevalidator;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


public final class Demo {
	//private static ClassValidator<User> userValidator = new ClassValidator<User>(User.class);
	private static Address addr;
	public static void main(String[] args) {
		validateUser(createUser());
	}
	
	private static User createUser() {
		User user = new User();
		user.setFirstName("123456789012345678901");
		user.setEmail("aol.com");
		
		
		
		return user;
	}
	
	private static void validateUser(User user) {
		
		addr = new Address();
		addr.setStreet1("");
		addr.setCity("Moreno Valley");
		addr.setState("C1");
		addr.setZip("aa");
		user.setAddress(addr);
		
		//InvalidValue[] invalidValues = userValidator.getInvalidValues(user);
		//createUser();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Address>> constraintsViolations = validator.validate(addr);
		Set<ConstraintViolation<Address>> constraintsViolations2 = validator.validateProperty(addr, "zip");
		int i =0;
		System.out.println("DEBUT");
		
		System.out.println(constraintsViolations.size());
		
		//ConstraintViolation<Address> constraintAdresse = constraintsViolations.iterator().next();
		while(i!=constraintsViolations.size()){
			
			i++;
			System.out.println(constraintsViolations.iterator().next().getMessage()+"  ");
			System.out.println("2 >"+constraintsViolations2.iterator().next().getMessage());
		}
		
		
		
//		while(true){
//			//System.out.println(constraintsViolations.iterator().next().getMessage());	
//		}
		
		
		
	}
}

