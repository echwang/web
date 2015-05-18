package com.neo.user;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	public static User TEST_USER = new User("neo", "intera", "echwang", "echwang@neo.com");
	
	private UserDao userDao;
	private User user = TEST_USER;	
	
	@Before
	public void setup() throws SQLException{
		userDao = new UserDao();
		userDao.removeUser(TEST_USER.getUserId());
	}

	@Test
	public void matchPassword() {
		assertTrue(TEST_USER.matchPassword("intera"));
	}

	@Test
	public void notMatchPassword() {		
		assertFalse(TEST_USER.matchPassword("intera2"));
	}

	@Test
	public void login() throws Exception {
		userDao.addUser(user);
		
		assertTrue(User.login(TEST_USER.getUserId(), TEST_USER.getPassword()));
	}
	
	@Test(expected=UserNotFoundException.class)
	public void loginWhenNotExistedUser() throws Exception {
		User.login("neo2", TEST_USER.getPassword());
	}
	
	@Test(expected=PasswordMismatchException.class)
	public void loginWhenPasswordMismatch() throws Exception {
		userDao.addUser(user);
		User.login(TEST_USER.getUserId(), "interaaa");
	}
	
		
}
