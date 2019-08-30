<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Gene</title>
<style type="text/css">
a {
	text-decoration: none;
}
</style>

</head>

<body>
	<jsp:include page="TopBar.jsp"></jsp:include>
	<h3>Detail user: ${user.firstName} ${user.lastName}</h3>
	<table style="width: 50%">
		<tr>
			<td>ID: </td>
			<td>${user.id}</td>
		</tr>
		<tr>
			<td>First Name: </td>
			<td>${user.firstName}</td>
		</tr>
		<tr>
			<td>Last Name: </td>
			<td>${user.lastName}</td>
		</tr>
		<tr>
			<td>Location: </td>
			<td>${user.location}</td>
		</tr>
		<tr>
			<td>Descritption: </td>
			<td>${user.description}</td>
		</tr>
		<tr>
			<td>Occupation: </td>
			<td>${user.occupation}</td>
		</tr>
	</table>
	<a href="/PhotoAppSprint/users">Back to user list</a> <br><br>
	<a href="/PhotoAppSprint/photos/${user.id}">See all photos of ${user.firstName}</a>	
</body>

</html>