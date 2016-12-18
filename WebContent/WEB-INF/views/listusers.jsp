<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="container">
<jsp:include page="common.jsp"></jsp:include>
<div class="jumbotron" align="center">
List Of Users
<span class="pull-right" >
			<a href="${pageContext.request.contextPath}/appLogout">Logout</a>
		</span>
</div>
<div class="list-group">
<table class="table table-bordered">
    <thead>
      <tr class="success">
        <th>Id</th>
        <th>Name</th>
        <th>Type</th>
        <th></th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    
<c:forEach var="item" items="${listusers}">
<tr>
<td>${item.id}</td>
<td>${item.name}</td>
<td>${item.type}</td>
<td><button class="btn-warning"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>edit</button></td>
<td><button class="btn-danger"><i class="fa fa-times" aria-hidden="true"></i>remove</button></td>
</tr>
</c:forEach>

</tbody>
</table>
<button class="btn-primary pull-right">addNewUser</button>
</div>
</body>
</html>