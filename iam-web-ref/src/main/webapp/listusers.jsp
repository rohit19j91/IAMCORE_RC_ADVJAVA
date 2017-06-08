<!--
Author: Rohit Chauhan
Description: This JSP file provides the list of all the users and also provides the search feature.
  -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="fr.epita.iam.datamodel.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Identity</title>
</head>
<body>
	<!-- <div xmlns="http://www.w3.org/1999/xhtml" class="bs-example"> -->
	<div class="container">
	<a href="<%=request.getContextPath()%>/logout">Log out</a>
		<h2 class="text-info">Identity Search</h2>
		<a href="welcome.jsp">&lt;&lt; back</a>


		<h3 class="text-info">Search Criteria</h3>
	</div>


	<form class="form-horizontal" name="SearchName"
		action="<%=request.getContextPath()%>/users" method="post">
		<div class="form-group">
			<label for="displayName" class="col-sm-2 control-label">Name</label>

			<div class="col-sm-10">
				<input type="text" class="form-control" id="NameSearch" name="name"	required autofocus></input>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10 text-right">
				<button type="submit" class="btn btn-primary"
					onClick="return checksearch(this)">Search</button>
			</div>
		</div>
	</form>
	<div class="container">
		<h3 class="text-info">Search Results</h3>

		<form class="form-horizontal"
			action="<%=request.getContextPath()%>/update" method="post">
			<div class="table-responsive">
				<table class="table">

					<%List<Identity> allusers = (List<Identity>)session.getAttribute("users");%>
					<thead>
						<tr>
							<th>
							<th>
							<th>Selection</th>
							<th>UID</th>
							<th>Name</th>
							<th>Email</th>
						</tr>
					</thead>
					<tbody>
						<%
			if(allusers!=null)
			{
				for (Identity alluse: allusers) {
					String uid= alluse.getUid();
                    String name = alluse.getDisplayName();
                    String email = alluse.getEmail();
                    long id=alluse.getId();
			%>
						<tr>
							<td></td>
							<td>
							<td><input type="radio" value="<%=id%>" name="mId"><input
								type="hidden" value="<%=id%>" name="checkId"></td>
							<td><%=uid%></td>
							<td><%=name%></td>
							<td><%=email%></td>
						</tr>
						<%
				}
			}
			else
			{	
			System.out.println("Error instance is null !");
			 } %>


					</tbody>
				</table>
			</div>

			<% if(session.getAttribute("delmsg")!=null){%>
			<h4><%=session.getAttribute("delmsg")%></h4>
			<%}
			else{%>
			<h4></h4>
			<%} %>
			<% if(session.getAttribute("srcmsg")!=null){%>
			<h4><%=session.getAttribute("srcmsg")%></h4>
			<%}
			else{%>
			<h4></h4>
			<%} %>
			<input type="hidden" name="dispatchAction"/>
			<button type="submit" class="btn btn-primary" formAction="update">Modify</button>
			<button type="submit" class="btn btn-primary" formAction="delete">Delete</button>
			<button type="submit" id="cancel" name="cancel" class="btn btn-primary" formAction="users">Cancel</button>			
		</form>

	</div>
</body>

</html>
