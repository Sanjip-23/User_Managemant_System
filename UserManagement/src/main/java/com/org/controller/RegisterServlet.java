package com.org.controller;
import com.org.dao.*;
import com.org.dto.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doPost(req, resp);
	 String name = req.getParameter("name");
	 String age=req.getParameter("age");
	 String mobile = req.getParameter("mobile");
	 String email = req.getParameter("email");
	 String password = req.getParameter("password");
	 
	 int age1=Integer.parseInt(age);
	 long mob=Long.parseLong(mobile);
	 
	 User u=new User();
	 u.setName(name);
	 u.setAge(age1);
	 u.setMobile(mob);
	 u.setEmail(email);
	 u.setPassword(password);
	 
	 userDao user=new userDao();
	 user.saveUser(u);
	 
	 HttpSession session = req.getSession();
	 session.setAttribute("success", "Registration Successful");
	 
	 resp.sendRedirect("register.jsp");
	 
}
}
