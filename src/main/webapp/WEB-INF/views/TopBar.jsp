<%@page import="org.springframework.security.core.userdetails.UserDetails"%>
<%@page import="java.security.Principal"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${user.firstName} ${user.lastName}</title>
<link href="<spring:url value="/resources/css/style.css"/>" rel="stylesheet">
</head>
<body>
<h1 style="text-align: center; color: blue;">Have a nice day !</h1>
<div style="text-align: center;">
	<a href='<spring:url value="/login"></spring:url>'>
		Login
	</a> 
	<a href='<spring:url value="/logout"></spring:url>'>
		Logout
	</a>
</div>
<% Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String userName;
	if(principal instanceof UserDetails) {
		userName = ((UserDetails)principal).getUsername();
	} else 
	{
		userName = "NoUser";
	}
%>

<div>User: <%=userName%></div>

</body>
</html>