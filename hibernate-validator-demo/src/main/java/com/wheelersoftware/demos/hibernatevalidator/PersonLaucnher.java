package com.wheelersoftware.demos.hibernatevalidator;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.company.Person;

public class PersonLaucnher {
	public static void main(String[] args) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		factory.usingContext();
		Person personn = new Person("titIIIIIII");
		
		personn.setDesignation("023");
		personn.setFirstName("Antoine");
		personn.setTelnumber(1234);
		personn.setEmail("antoine.gamil.com");

		Set<ConstraintViolation<Person>> constraintViolations =validator.validate(personn);
		Iterator<ConstraintViolation<Person>> itr = constraintViolations.iterator();

		//System.out.println("DEBUT"+itr.toString());
		System.out.println(" Size : "+constraintViolations.size()+"\n\n");
		int i =0;
		while(itr.hasNext()){
			ConstraintViolation<Person> violation = itr.next();
			System.out.println("=> compteur "+i+"\n");
			System.out.println("Message :"+violation.getMessage());
			System.out.println("Valeur : "+violation.getInvalidValue());
			
			System.out.println("Nom Classe:" + violation.getRootBeanClass()+" " );
			System.out.println("Base sur implementation :"+violation.getMessageTemplate());
			System.out.println("details "+violation.getRootBean());

			i++;
		}
	}
}
