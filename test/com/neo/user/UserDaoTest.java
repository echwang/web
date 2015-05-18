package com.neo.user;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {
	private UserDao userDao;
	
	@Before
	public void setup() {
		userDao = new UserDao();		
	}

	@Test
	public void connection() {
		Connection conn = userDao.getConnection();
		assertNotNull(conn);
	}
	
	@Test
	public void addUser() throws Exception {
		userDao.removeUser(UserTest.TEST_USER.getUserId());
		userDao.addUser(UserTest.TEST_USER);		
	}
	
	
	@Test
	public void findByUserId() throws Exception {
		userDao.removeUser(UserTest.TEST_USER.getUserId());
		userDao.addUser(UserTest.TEST_USER);
		User user = userDao.findByUserId("neo");		
		assertEquals(UserTest.TEST_USER, user);
	}
	
	@Test
	public void FindByUserNotExist() throws SQLException{
		userDao.removeUser(UserTest.TEST_USER.getUserId());
		User dbUser = userDao.findByUserId("neo1");	
		assertNull(dbUser);
		
	}
	
	@Test
	public void updateUser() throws Exception {
		userDao.removeUser(UserTest.TEST_USER.getUserId());
		userDao.addUser(UserTest.TEST_USER);
		User user = new User(UserTest.TEST_USER.getUserId(), UserTest.TEST_USER.getPassword(), UserTest.TEST_USER.getName(), "neo@neo.com")	;
		userDao.updateUser(user);		
	}
	

}
