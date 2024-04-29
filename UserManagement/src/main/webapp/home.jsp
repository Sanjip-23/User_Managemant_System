
<%@page import="java.util.List"%>
<%@page import="com.org.dao.userDao"%>
<%@page import="com.org.dto.User"%>
<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="components/bootstrapcss.jsp" %>
</head>
<body>


<% User user=(User)session.getAttribute("alldata"); 
if(user == null){
	response.sendRedirect("login.jsp");
}
else{
%>
<%@ include file="components/homeNavbar.jsp" %>
<h1 style="text-align:center">
Hey <%=user.getName() %>, Welcome to Student management System</h1>
	<%} %>
	
</body>
</html>