package com.neo.user;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserValidatorTest {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void userIdIsNull() {
		User user = new User(null, "intera", "echwang", "echwang@neo.com");

		Set<ConstraintViolation<User>> constraintViolations = validator
				.validate(user);

		assertEquals(1, constraintViolations.size());
		System.out.println(constraintViolations.iterator().next().getMessage());

		/*
		 * assertEquals("may not be null",
		 * constraintViolations.iterator().next() .getMessage());
		 */}

	@Test
	public void userIdLength() {
		User user = new User("aa", "intera", "echwang", "echwang@neo.com");

		Set<ConstraintViolation<User>> constraintViolations = validator
				.validate(user);

		assertEquals(1, constraintViolations.size());
		System.out.println(constraintViolations.iterator().next().getMessage());

		user = new User("1223456789012aa", "intera", "echwang",
				"echwang@neo.com");

		constraintViolations = validator.validate(user);

		assertEquals(1, constraintViolations.size());
		System.out.println(constraintViolations.iterator().next().getMessage());

	}

	@Test
	public void emailCheck() {
		User user = new User("4a42", "intera", "echwang", "echwang.neo.com");

		Set<ConstraintViolation<User>> constraintViolations = validator
				.validate(user);

		assertEquals(2, constraintViolations.size());
		System.out.println(constraintViolations.iterator().next().getMessage());

	}

	@Test
	public void invalidUser() {
		User user = new User("123", "intera", "echwang", "echwang.neo.com");

		Set<ConstraintViolation<User>> constraintViolations = validator
				.validate(user);

		assertEquals(2, constraintViolations.size());
		Iterator<ConstraintViolation<User>> violations = constraintViolations
				.iterator();

		while (violations.hasNext()) {
			ConstraintViolation<User> each = violations.next();
			System.out.println(each.getMessage());
		}

	}

}
