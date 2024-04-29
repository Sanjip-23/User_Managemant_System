<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.userDao"%>
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
<%@ include file="components/homeNavbar.jsp" %>
    
     <% int id=Integer.parseInt(request.getParameter("id"));
         userDao dao=new userDao();
         User user=dao.fetchUserById(id);
     %>
     <div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Update <%= user.getName() %> profile</p>
						
					    
						<form action="update" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" value="<%=user.getName() %>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="tel" value="<%=user.getAge() %>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input name="mobile"
									type="tel" value="<%=user.getMobile() %>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" value="<%=user.getEmail() %>" type="email" class="form-control" required>
							</div>
							<div>
							     <input type="hidden" name="id" value="<%= user.getId() %>">
							</div>
							
							<button type="submit" class="btn bg-primary text-white col-md-12">Update</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>