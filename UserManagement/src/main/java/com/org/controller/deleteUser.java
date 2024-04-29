package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.userDao;
@WebServlet("/delete")
public class deleteUser extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(req, resp);
	int id =Integer.parseInt(req.getParameter("id"));
	
	userDao dao=new userDao();
	 dao.deleteUserById(id);
	 
	// HttpSession session = req.getSession();
	// session.setAttribute("deleteSuccess", "User deleted successful");
	 
	 resp.sendRedirect("home.jsp");
}
}
