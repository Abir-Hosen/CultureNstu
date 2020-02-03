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

<meta name="${_csrf}" content="${_csrf.token}">
<meta name="${_csrf_header}" content="${_csrf.headerName}">


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
	background-color: #09478f;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}

/*
slide image
*/
* {
	box-sizing: border-box;
}

body {
	font-family: Verdana, sans-serif;
}

.mySlides {
	display: none;
}

img {
	vertical-align: middle;
}

/* Slideshow container */
.slideshow-container {
	position: relative;
	margin: auto;
}

/* Caption text */
.text {
	color: #f2f2f2;
	font-size: 15px;
	padding: 8px 12px;
	position: absolute;
	bottom: 8px;
	width: 100%;
	text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
	color: #f2f2f2;
	font-size: 12px;
	padding: 8px 12px;
	position: absolute;
	top: 0;
}

/* The dots/bullets/indicators */
.dot {
	height: 15px;
	width: 15px;
	margin: 0 2px;
	background-color: #bbb;
	border-radius: 50%;
	display: inline-block;
	transition: background-color 0.6s ease;
}

.active {
	background-color: #717171;
}

/* Fading animation */
.fade {
	-webkit-animation-name: fade;
	-webkit-animation-duration: 1.5s;
	animation-name: fade;
	animation-duration: 1.5s;
}

@
-webkit-keyframes fade {
	from {opacity: .4
}

to {
	opacity: 1
}

}
@
keyframes fade {
	from {opacity: .4
}

to {
	opacity: 1
}

}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
	.text {
		font-size: 11px
	}
}
</style>

<link rel="icon" href="${images}/favicon.gif" />
</head>

<body>

	<div class="ui container">

		<%@ include file="./shared/nav.jsp"%>

		<c:if test="${userClickHome==true }">
			<%@ include file="./pages/home.jsp"%>
		</c:if>

		<c:if test="${userClickProfile==true }">
			<%@ include file="./pages/profile.jsp"%>
		</c:if>

		<c:if test="${userClickEditAboutProfile==true }">
			<%@ include file="./pages/editabout.jsp"%>
		</c:if>

		<c:if test="${userClickVisitProfile==true }">
			<%@ include file="./pages/viewprofile.jsp"%>
		</c:if>

		<c:if test="${userClickViewPost==true }">
			<%@ include file="./pages/viewpost.jsp"%>
		</c:if>

		<c:if test="${userClickEditPost==true }">
			<%@ include file="./pages/editpost.jsp"%>
		</c:if>

		<c:if test="${userClickAdminPanel==true }">
			<%@ include file="./admin/admin.jsp"%>
		</c:if>

		<c:if test="${userClickEditRegistered==true }">
			<%@ include file="./admin/registered.jsp"%>
		</c:if>

		<c:if test="${userClickregistration==true }">
			<%@ include file="./registration/registration.jsp"%>
		</c:if>

		<c:if test="${userClickAdminPanelCategory==true }">
			<%@ include file="./admin/category.jsp"%>
		</c:if>

		<%@ include file="./shared/footer.jsp"%>

	</div>

	<script type="text/javascript">
		var slideIndex = 0;
		showSlides();

		function showSlides() {
			var i;
			var slides = document.getElementsByClassName("mySlides");
			var dots = document.getElementsByClassName("dot");
			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			slideIndex++;
			if (slideIndex > slides.length) {
				slideIndex = 1
			}
			for (i = 0; i < dots.length; i++) {
				dots[i].className = dots[i].className.replace(" active", "");
			}
			slides[slideIndex - 1].style.display = "block";
			dots[slideIndex - 1].className += " active";
			setTimeout(showSlides, 2000); // Change image every 2 seconds
		}
		window.menu = '${title}';
	</script>

</body>

</html>