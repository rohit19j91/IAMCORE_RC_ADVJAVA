<!--
Author: Rohit Chauhan
Description: This JSP file helps in registering a new user.
  -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Register</title>

<script src="js/bootstrap.min.js"></script>
<script src="js/signin.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<link href="css/register.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<a href="<%=request.getContextPath()%>/login.jsp">&lt;&lt; back</a>
		<form class="form-signin" name="loginForm" method="post"
			action="<%=request.getContextPath()%>/register">
			<h2 class="form-signin-heading">Please sign up</h2>
			<label for="inputUID" class="sr-only">Your UID</label> 
			<input id="uid" class="form-control" placeholder="Your UID" name="UID" required autofocus>
			<label for="inputName" class="sr-only">Your name</label> 
			<input id="name" class="form-control" placeholder="Your name" name="name" required>
			<label for="inputEmail" class="sr-only">Email address</label> 
			<input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" required>
			<label for="inputPassword" class="sr-only">Password</label> 
			<input type="password" id="inputPassword" class="form-control" placeholder="Password" name="pwd" required> 
			<label for="rinputPassword" class="sr-only">Password Again</label> 
			<input type="password" id="rinputPassword" class="form-control"	placeholder="Password Again" name="rpwd" required>
			<label for="lbstreet" class="sr-only">Street</label> 
			<input id="Street" class="form-control" placeholder="Street" name="street" required>
			<label for="lbcity" class="sr-only">City</label>
			<input id="City" class="form-control" placeholder="City" name="city" required>
			<label for="lbcountry" class="sr-only">Country</label> 
			<input id="Country" class="form-control" placeholder="Country" name="country" required>
			<label for="Zipcode" class="sr-only">Zipcode</label> 
			<input id="Zipcode" class="form-control" placeholder="Zipcode" name="zipcode" required>
			<p></p>
			<%if(request.getAttribute("error")==null){%>
			<h2></h2>
			<%}
        else
        {%>
			<h4><%=request.getAttribute("error")%></h4>
			<%} %>
			<%if(request.getAttribute("regmsg")==null){%>
			<h2></h2>
			<%}
        else
        {%>
			<h3><%=request.getAttribute("regmsg")%></h3>
			<%request.getRequestDispatcher("authenticate").forward(request, response);%>
			<%} %>
			<input class="btn btn-lg btn-primary" type="submit"
				onclick="return checkr(this)" value="Register and Login">
		</form>
	</div>
</body>
</html>
