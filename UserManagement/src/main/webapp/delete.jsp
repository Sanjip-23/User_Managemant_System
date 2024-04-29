<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #f4f4f4;
    }
    .container {
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    h2 {
        margin-top: 0;
    }
    button {
        padding: 10px 20px;
        margin: 10px;
        border: none;
        cursor: pointer;
    }
    .btn-yes {
        background-color: #f44336;
        color: white;
    }
    .btn-no {
        background-color: #4CAF50;
        color: white;
    }
</style>
<%@ include file="components/bootstrapcss.jsp" %>
</head>
<body>
<% int id=Integer.parseInt(request.getParameter("id")); %>
<% User user=(User)session.getAttribute("alldata"); 
if(user == null){
	response.sendRedirect("login.jsp");
}
else{%> 
    <div class="container">
    <h2>Are you sure you want to delete?</h2>
    <a href="delete?id=<%= id %>">
    <button class="btn-yes">Yes</button>
    </a>
    <a href="allData.jsp">
    <button class="btn-no">No</button>
    </a>
    <% } %>
</div>
</body>
</html>