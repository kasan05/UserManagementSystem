<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<jsp:include page="common.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>

$(document).ready(function(){
    $("#edit").click(function(){
        $("#editModal").modal();
       var x = $("#dName").val();
       $("#name").val(x);
    });
});
</script>
</head>
<body>
	
	<div class="jumbotron">
	
	Personal Details
	<span class="pull-right" >
			<a href="${pageContext.request.contextPath}/appLogout">Logout</a>
		</span>
	</div>
		
			<table class="table table-striped">
				
					<tr><td>ID<td>${dbUser.id}</td></tr>
		
				
					<tr><td>Name</td><td id="dName">${dbUser.name}</td></tr>
				
					<tr><td>Type</td><td>${dbUser.type}</td></tr>
				<tr><td><button class="btn-warning" id="edit"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>edit</button></td></tr>
				
		</table>
		
		<div class="modal fade" id="editModal" role="dialog">
		<div class="modal-dialog">
		<!-- Modal content-->
      <div class="modal-content">
       <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> PersonalDetails</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
        <form role="form">
            <div class="form-group">
              <label for="name"><span class="glyphicon glyphicon-user"></span> name</label>
              <input type="text" class="form-control" id="name" placeholder="Enter the name">
            </div>
            <div class="form-group">
              <label for="type"><span class="glyphicon glyphicon-user"></span> type</label>
              <input type="text" class="form-control" id="type" placeholder="Enter the name">
            </div>
            </form>
        </div>
      </div>
		</div>
		</div>
</body>
</html>