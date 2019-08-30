<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${user.firstName} ${user.lastName}</title>
<link href="<spring:url value="/resources/css/style.css"/>" rel="stylesheet">
</head>

<body>
	<jsp:include page="TopBar.jsp"></jsp:include>
	<c:forEach var="photo" items="${photos}">
		<h3>${user.firstName} ${user.lastName}</h3>
		<div>${photo.dateTime}</div>
		<img alt="photo" src="<spring:url value="/resources/photos/${photo.fileName}.jpg"/>" width="300" > <br>
		<c:forEach var="comment" items="${photo.comments}">
			<a href='<spring:url value="/users/${comment.user.id}"></spring:url>'>${comment.user.firstName}</a>
			<div>${comment.dateTime}</div>
			<div>${comment.comment}</div>
		</c:forEach>
	</c:forEach>
</body>

</html>