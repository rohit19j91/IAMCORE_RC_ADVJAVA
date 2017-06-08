<!--
Author: Rohit Chauhan
Description: This JSP file helps people to login.
  -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>login</title>
<script src="js/bootstrap.min.js"></script>
<script src="js/signin.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<form class="form-signin" name="loginForm" method="post"
			action="<%=request.getContextPath()%>/authenticate">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label> <input
				type="email" id="inputEmail" class="form-control"
				placeholder="Email address" name="email" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" name="pwd" required>
			<p></p>
			<%if(session.getAttribute("msg")!=null) {%>
			<h3><%=session.getAttribute("msg")%></h3>
			<%}
            else
            {%>
			<h3></h3>
			<%} %>
			<p></p>
			<input class="btn btn-lg btn-primary btn-block" type="submit"
				onclick="return check(this)" value="Sign in"> <a
				class="btn btn-lg btn-primary btn-block" href="register.jsp">Register</a>
		</form>

	</div>
</body>
</html>
