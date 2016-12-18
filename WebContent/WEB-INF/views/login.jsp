<html>
    <head>
        <title>login</title>
    </head>
    <body class="container">
    <jsp:include page="common.jsp"></jsp:include>
       <div class="jumbotron"><h3>Login</h3></div>
		<form class="form-signin"  action="<%=request.getContextPath()%>/login" method="POST">
		<div class="container">
			<label>Enter UserName:</label>	
			<input type="text" name="username"/><br/><br/>
			<label>Enter Password: </label>
			<input type="password" name="password"/> <br/><br/>			
			<input type="submit" value="Login" class="btn-primary"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>			
		</div>
		</form>
    <body>
</html>  