<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>

<html>

<head>

<meta charset="utf-8">
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta http-equiv="refresh" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="An Film Production based project">
<meta name="author" content="Rojo">

<title>Culture NSTU ${title}</title>


<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.2/semantic.min.css">

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>

<link href="${css}/myapp.css" rel="stylesheet">
<script src="${js}/myapp.js"></script>


<style>
.dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #dddddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;}
</style>


<link rel="icon" href="${images}/favicon.gif" />
</head>

<body>

	<div class="ui container">

		<%@ include file="./shared/nav.jsp"%>

		<div class="page-login">
			<div class="ui centered grid container">
				<div class="nine wide column">
					<div class="ui icon warning message">
						<i class="lock icon"></i>
						<div class="content">
							<div class="header">Login Here!</div>
							<c:if test="${not empty message }">
								<p>${message}!</p>
							</c:if>
							<c:if test="${not empty logout }">
								<p>${logout}!</p>
							</c:if>
						</div>
					</div>
					<div class="ui fluid card">
						<div class="content">
							<form class="ui form" method="post" action="${contextRoot}/login">
								<div class="field">
									<label>User</label> <input type="text" id="username"
										name="username" class="form-control" placeholder="Username"
										required autofocus>
								</div>
								<div class="field">
									<label>Password</label> <input type="password" id="password"
										name="password" class="form-control" placeholder="Password"
										required>
								</div>
								<input name="${_csrf.parameterName }" type="hidden"
									value="${_csrf.token }" />
								<button class="ui primary labeled icon button" type="submit">
									<i class="unlock alternate icon"></i> Login
								</button>
							</form>
							<br>
							<div class="ui warning bottom attached message">
								<i aria-hidden="true" class="help icon"></i> Not signed up? <a
									href="${contextRoot}/registration">Sign up here</a> instead.
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<%@ include file="./shared/footer.jsp"%>
	</div>

	<script type="text/javascript">
		window.menu = '${title}';
	</script>

</body>

</html>