<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>

<style>
body {
	text-align: center;
}

a {
	text-decoration: none;
}
</style>
</head>

<body>
	<jsp:include page="TopBar.jsp"></jsp:include>
	<h2>User List</h2>
		<c:forEach var="user" items="${userList}">
		<div>
			<a href="users/${user.id}">
				<span>${user.firstName}</span>
				<span>${user.lastName}</span>
			</a>
		</div>
		</c:forEach>
</body>

</html>