<!--
Author: Rohit Chauhan
Description: This JSP file helps in updating the UID, Name and Address.
  -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="fr.epita.iam.datamodel.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/bootstrap.min.js"></script>
<script src="js/signin.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updating Identity</title>
</head>
<body>
		<div class="container">
			<h2 class="text-info">Identity Modification</h2>
			<a href="listusers.jsp">&lt;&lt; back</a>
		</div>
		<form class="form-horizontal"
			action="<%=request.getContextPath()%>/update" method="get"
			role="form">
			<%List<Identity> allusers = (List<Identity>)session.getAttribute("userupdate");
			String uid=null,name=null,email=null,street=null,city=null,country=null,zipcode=null;
			long id=0;
			if(allusers!=null)
			{	for (Identity alluse: allusers) {
				uid= alluse.getUid();
				name = alluse.getDisplayName();
				email = alluse.getEmail();
				street=alluse.getAddress().getStreet();
				city= alluse.getAddress().getCity();
				country=alluse.getAddress().getCountry();
				zipcode=alluse.getAddress().getZipcode();
			}	 %>
			<div class="form-group">
				<label for="labuid" class="col-sm-2 control-label">UID</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="uid" id="uid"
						value="<%=uid%>" />
				</div>
			</div>
			<div class="form-group">
				<label for="labName" class="col-sm-2 control-label">Name</label>

				<div class="col-sm-10">
					<input type="text" class="form-control" name="name" id="dispname"
						value="<%=name%>" />
				</div>
			</div>
			<div class="form-group">
				<label for="emailModif" class="col-sm-2 control-label">Email</label>

				<div class="col-sm-10">
					<input type="email" id="inputEmail" class="form-control" name="ema"
						value=<%=email%> readonly>
				</div>
			</div>
			<div class="form-group">
				<label for="labuid" class="col-sm-2 control-label">Street</label>

				<div class="col-sm-10">
					<input type="text" class="form-control" name="street" id="street"
						value="<%=street%>" />
				</div>
			</div>
			<div class="form-group">
				<label for="labuid" class="col-sm-2 control-label">City</label>

				<div class="col-sm-10">
					<input type="text" class="form-control" name="city" id="city"
						value="<%=city%>" />
				</div>
			</div>
			<div class="form-group">
				<label for="labuid" class="col-sm-2 control-label">Country</label>

				<div class="col-sm-10">
					<input type="text" class="form-control" name="country" id="country"
						value="<%=country%>" />
				</div>
			</div>
			<div class="form-group">
				<label for="labuid" class="col-sm-2 control-label">Zipcode</label>

				<div class="col-sm-10">
					<input type="text" class="form-control" name="zipcode" id="zipcode"
						value="<%=zipcode%>" />
				</div>
			</div>
			<%}
        else{
        	System.out.println("Its not working properly");
        }%>
			<%if(session.getAttribute("updmsg")!=null) {%>
			<div class="center-block" style="max-width: 900px">
				<h3><%=session.getAttribute("updmsg")%></h3>
			</div>
			<%}
        else{%>
			<h3></h3>
			<% }%>
			<div class="center-block" style="max-width: 400px">
				<input class="btn btn-lg btn-primary" type="submit" value="Submit">
				<input class="btn btn-lg btn-primary" type="submit"
					formAction="users" value="Go Back to the Search Page">
			</div>
		</form>
	</div>
</body>
</html>
