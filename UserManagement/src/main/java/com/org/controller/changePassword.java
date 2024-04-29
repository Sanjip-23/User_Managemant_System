package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.userDao;
import com.org.dto.User;

@WebServlet("/changePassword")
public class changePassword extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doPost(req, resp);
	User u=new User();
	int id = u.getId();
	String password = u.getPassword();
	String currentPassword = req.getParameter("currentPwd");
	String newPassword = req.getParameter("newPwd");
	String conformPassword = req.getParameter("confirmPwd");
	//int id=Integer.parseInt(req.getParameter("id"));
	
	if(password.equals(currentPassword)  && newPassword.equals(conformPassword)) {
		userDao user=new userDao();
		user.changePassword(id,newPassword);
		resp.sendRedirect("home.jsp");
	}
	else {
		resp.sendRedirect("changePassword.jsp");
	}
}
}
