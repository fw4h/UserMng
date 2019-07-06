<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">User Entry</div>
		<div class="panel-body">
			<form:form action="doupdate.html" method="post"
				modelAttribute="userDTO">
				<form:hidden path="id" id="id" cssClass="form-control" />
				<div class="form-group">
					<label for="name">Name: </label>
					<form:input path="name" cssClass="form-control" id="name" />
				</div>
				<div class="form-group">
					<label for="phone_no">Phone Number: </label>
					<form:input path="phone_no" cssClass="form-control" id="phone_no" />
				</div>
				<div class="form-group">
					<label for="dob">Date of Birth: </label>
					<form:input path="dob" cssClass="form-control" id="dob" />
				</div>
				<div class="form-group">
					<label for="username">Username: </label>
					<form:input path="username" cssClass="form-control" id="username" />
				</div>
				<div class="form-group">
					<label for="password">Password: </label>
					<form:input path="password" cssClass="form-control" id="password" />
				</div>
				<button class="btn btn-default" type="submit">Submit</button>
			</form:form>
		</div>
	</div>

	<div class="panel panel-primary">
		<div class="panel-heading">User List</div>
		<div class="panel-body">
			<table class="table">
				<thead>
					<tr>
						<th>ID
						<th>NAME
						<th>PHONE_NO
						<th>DOB
						<th>USERNAME
						<th>PASSWORD
						<th>ACTION
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList}" var="row">
						<tr>
							<td>${row.id}</td>
							<td>${row.name}</td>
							<td>${row.phone_no}</td>
							<td><fmt:formatDate value="${row.dob}" pattern="MM/dd/yyyy" />
							</td>
							<td><c:out value="${row.username}"></c:out></td>
							<td><c:out value="${row.password}"></c:out></td>
							<td><a href="dodisplay.html?id=${row.id}">Edit</a> / <a
								href="dodelete.html?id=${row.id}">Delete</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div>
		<a href="logout.html">Logout</a>
	</div>


</body>
</html>