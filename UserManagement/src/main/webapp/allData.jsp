<%@page import="java.util.List"%>
<%@page import="com.org.dao.userDao"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="components/bootstrapcss.jsp"%>
</head>
<body>
<% User user=(User)session.getAttribute("alldata"); 
if(user == null){
	response.sendRedirect("login.jsp");
}
else{
%>
<%@ include file="components/homeNavbar.jsp" %>

<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center ">All User Details</p>
						<a href="addUser.jsp" class="text-decoration-none btn btn-primary">Add
							User</a>
						<table class="table">
							<thead>
								<tr>
									<th>Name</th>
									<th>Age</th>
									<th>Email</th>
									<th>Mobile</th>
									<th>Action</th>
								</tr>
								<%
								userDao dao=new userDao();
								List<User> list=dao.fetchAllUsers();
								for(User u : list){
									if(user.getId() == u.getId())
										continue;
								%>
								<tr>
								    <td><%= u.getName() %></td>
								    <td><%= u.getAge()%></td>
								    <td><%= u.getEmail()%></td>
								    <td><%= u.getMobile()%></td>
								    <td>
								      <a href="update.jsp?id=<%= u.getId()%>" class="btn btn-success text-decoration-none">UPDATE</a>
								      <a href="delete.jsp?id=<%= u.getId()%>" class="btn btn-danger text-decoration-none">DELETE</a>
								    </td>
								</tr>
                             <% } %>
							</thead>
							<tbody>
						</table>

					</div>
				</div>


			</div>

		</div>


	</div>
	<%} %>
</body>
</html>