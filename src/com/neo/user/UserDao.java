package com.neo.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	public Connection getConnection() {
		// TODO Auto-generated method stub
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/neo"; 
		String db_user="root";
		String db_pwd="root"; 	
			

		Connection conn = null; // 커넥션 객체 생성

		try{
			Class.forName(driver).newInstance();	
	
			conn = DriverManager.getConnection(url, db_user, db_pwd);			
		} catch(Exception e){
			System.out.println(e);
		}		
		
		return conn;
	}

	public void addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO users VALUES (?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
	
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
		      
			pstmt.executeUpdate();		
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			if(pstmt != null){
				pstmt.close();				
			}
			
			if(conn != null){
				conn.close();				
			}
		}
	}

	public User findByUserId(String userId) throws SQLException  {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM users WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
				
			//Extract data from result set
			while(rs.next()){
				User user = new User(
						rs.getString("userID"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("email"));
				
				return user;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			if(rs != null){
				rs.close();				
			}
			
			if(pstmt != null){
				pstmt.close();				
			}
			
			if(conn != null){
				conn.close();	
			}			
		}     
		 
		
		return null;
	}

	public void removeUser(String userId) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM users WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
	
			pstmt.setString(1, userId);
		      
			pstmt.executeUpdate();		
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			if(pstmt != null){
				pstmt.close();				
			}
			
			if(conn != null){
				conn.close();				
			}
		}	
		
		return;		
	}

	public void updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		String userId = user.getUserId();
		String sql = "UPDATE users SET password=?, name=?, email=? WHERE userId=?";		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
	
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getUserId());
		      
			pstmt.executeUpdate();		
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			if(pstmt != null){
				pstmt.close();				
			}
			
			if(conn != null){
				conn.close();				
			}
		}		
	}

}
