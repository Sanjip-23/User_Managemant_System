<%@page import="com.org.dao.userDao"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
     body {
    font-family: Arial, sans-serif;
    background-color: #f8f9fa;
    margin: 0;
    padding: 0;
}

.container {
    max-width: 400px;
    margin: 50px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

h2 {
    text-align: center;
    margin-bottom: 20px;
}

.form-group {
    margin-bottom: 20px;
}

label {
    font-weight: bold;
}

.btn-primary {
    width: 100%;
}
</style>
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
        
<div class="container">
    <h2>Change Password</h2>
    <form action="changePassword" method="post">
        <div class="form-group">
            <label for="currentPassword">Enter Current Password</label>
            <input type="password" name="currentPwd" class="form-control" id="currentPassword" required>
        </div>
        <div class="form-group">
            <label for="newPassword">Enter New Password</label>
            <input type="password" name="newPwd" class="form-control" id="newPassword" required>
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirm New Password</label>
            <input type="password" name="confirmPwd" class="form-control" id="confirmPassword" required>
        </div>
        <button type="submit" class="btn btn-primary">Change Password</button>
    </form>
</div>
<%} %>
</body>
</html>