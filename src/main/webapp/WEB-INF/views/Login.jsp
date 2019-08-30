<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Gene</title>
</head>

<body>
<h1>Please Login</h1>
<form action='<spring:url value="/signin"></spring:url>' method="post">
	<div>
		Username : 
		<input type="text" name="username">
		Password : 
		<input type="password" name="password">
		<input type="submit">
	</div>
</form>
</body>

</html>