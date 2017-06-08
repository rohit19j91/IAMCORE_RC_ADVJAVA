<!--
Author: Rohit Chauhan
Description: This JSP file serves as the welcome page for the user.
  -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
		<div class="jumbotron">
			<div class="container">
				<form action="logout" method="post">
					<h6 style="color: green"><%=session.getAttribute("flag")%></h6>
					<h1 class="text-info">
						Welcome
						<%=session.getAttribute("name")%>
						to the IAM System
					</h1>
					<a href="<%=request.getContextPath()%>/logout">Log out</a>
				</form>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-xs-6">
					<form action="register.jsp">
						<h4>Identity Creation</h4>

						<p>Thanks to this action, you can create a brand new Identity,
							you can click on the button below to begin</p>
						<button>Create!</button>
					</form>
				</div>
				<div class="col-xs-6">
					<form action="<%=request.getContextPath()%>/users">
						<h4>Identity Search</h4>
						<p>Thanks to this action, you can search an identity and then
							access to its information. Through this action, you can also
							modify or delete the wished identity</p>
						<%request.setAttribute("welcome","welcome");%>
						<button name="search">Search!</button>
					</form>
				</div>
			</div>
		</div>


	</div>
</body>
</html>


