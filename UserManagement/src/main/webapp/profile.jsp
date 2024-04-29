<%@page import="com.org.dto.User"%>
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
<%
  User details=(User) session.getAttribute("alldata");
%>
<% User user=(User)session.getAttribute("alldata"); 
if(user == null){
	response.sendRedirect("login.jsp");
}
else{
%>
<%@ include file="components/homeNavbar.jsp" %>
<h1 style=" color : blue">
<%= "your profile :-" %>
</h1>
<h4>
   Your Name:<%= details.getName() %><br>
   Your Age:<%= details.getAge() %><br>
   Your Mobile:<%= details.getMobile() %><br>
   Your Email:<%= details.getEmail() %><br>
  </h4>
<%} %>




</body>
</html>