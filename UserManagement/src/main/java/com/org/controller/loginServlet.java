package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.userDao;
import com.org.dto.User;

@WebServlet("/login")
public class loginServlet extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doPost(req, resp);
	String email = req.getParameter("email");
	String password = req.getParameter("password");
	
	userDao dao=new userDao();
	User user=dao.fetchUserByEmailAndPassword(email, password) ;
	
	if(user != null) {
	   
	    HttpSession session = req.getSession();
		 session.setAttribute("alldata",user );
	    
		resp.sendRedirect("home.jsp");
	}
	else {
		
		 HttpSession session = req.getSession();
		 session.setAttribute("fail", "login failed");
		resp.sendRedirect("login.jsp");	
	}
}
}
