<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="container">
	<jsp:include page="common.jsp"></jsp:include>
	<div class="jumbotron">
		
		<span >Hi  ${user}  Welcome to Home Page</span>
		<span class="pull-right" >
			<a href="${pageContext.request.contextPath}/appLogout">Logout</a>
		</span>
	</div>
	<div align="center">
	<a href="${pageContext.request.contextPath}/personaldetails">see my
		profile</a>
	<a href="${pageContext.request.contextPath}/list">View User List</a>
	</div>
</body>
</html>