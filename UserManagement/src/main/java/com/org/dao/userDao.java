package com.org.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.*;

public class userDao
{
  public void saveUser(User user) 
  {
	  try 
	  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_mgmt","root","root");
		PreparedStatement pst = con.prepareStatement
				("insert into user(name,age,email,password,mobile) values(?,?,?,?,?)");
		
		  pst.setString(1, user.getName());
		  pst.setInt(2, user.getAge());
		  pst.setString(3, user.getEmail());
		  pst.setString(4, user.getPassword());
		  pst.setLong(5, user.getMobile());
		  
		  pst.executeUpdate();
		  
		  pst.close();
		  con.close();
		  System.out.println("registration successful");
	  }
	  catch (ClassNotFoundException | SQLException e) 
	  {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  } 

public User fetchUserByEmailAndPassword(String email,String password) 
{
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_mgmt","root","root");
	PreparedStatement pst = con.prepareStatement("select * from user where email=? and password=? ");
	pst.setString(1,email );
	pst.setString(2, password);
	
	ResultSet rst = pst.executeQuery();
	if(rst.next()) {
		User user=new User();
		user.setId(rst.getInt("id"));
		user.setName(rst.getString("name"));
		user.setAge(rst.getInt("age"));
		user.setMobile(rst.getLong("mobile"));
		user.setEmail(rst.getString("email"));
		user.setPassword(rst.getString("password"));
		
		return user;
	}
	con.close();
	}
	catch(Exception e) {
		
	}
	return null;
}

public User fetchUserById(int id) 
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_mgmt","root","root");
		PreparedStatement pst = con.prepareStatement("select * from user where id=?");
		pst.setInt(1,id );
		
		
		ResultSet rst = pst.executeQuery();
		if(rst.next()) {
			User user=new User();
			user.setId(rst.getInt("id"));
			user.setName(rst.getString("name"));
			user.setAge(rst.getInt("age"));
			user.setMobile(rst.getLong("mobile"));
			user.setEmail(rst.getString("email"));
			user.setPassword(rst.getString("password"));
			
			return user;
		
		}
		con.close();
		}
		catch(Exception e) {
			
		}
		return null;
}
public List<User> fetchAllUsers()


{
	List<User> data= new ArrayList<>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_mgmt","root","root");
		PreparedStatement pst = con.prepareStatement("select * from user");
		
		ResultSet rst = pst.executeQuery();
		while(rst.next()) {
			User user=new User();
			user.setId(rst.getInt("id"));
			user.setName(rst.getString("name"));
			user.setAge(rst.getInt("age"));
			user.setMobile(rst.getLong("mobile"));
			user.setEmail(rst.getString("email"));
			user.setPassword(rst.getString("password"));
			
			data.add(user);
		}
		con.close();
		}
		catch(Exception e) {
			
		}
	return data;
}
public void updateuser(User user)
{

	  try 
	  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_mgmt","root","root");
		PreparedStatement pst = con.prepareStatement
				("update user set name=? , age=? ,mobile=? ,email=? where id=?");
		
		  pst.setString(1, user.getName());
		  pst.setInt(2, user.getAge());
		  pst.setLong(3, user.getMobile());
		  pst.setString(4, user.getEmail());
		  pst.setInt(5, user.getId());
		  
		  pst.executeUpdate();
		  
		  pst.close();
		  con.close();
		  System.out.println("Updation successful");
	  }
	  catch (ClassNotFoundException | SQLException e) 
	  {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void deleteUserById(int id) 
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_mgmt","root","root");
		PreparedStatement pst = con.prepareStatement
				("delete from user where id=?");
		pst.setInt(1, id);
		pst.executeUpdate();
		
		pst.close();
		con.close();
			
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void changePassword(int id,String newPassword )
{
	// TODO Auto-generated method stub
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_mgmt","root","root");
		PreparedStatement pst = con.prepareStatement
				("update user set password=? where id=?");
		pst.setString(1, newPassword);
		pst.setInt(2, id);
		pst.executeUpdate();
		
		pst.close();
		con.close();
		System.out.println("password changed successfully");
			
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
