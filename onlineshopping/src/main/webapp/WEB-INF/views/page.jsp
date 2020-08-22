<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">

<!-- Bootstrap-Readable-Theme CSS -->
<link href="${css}/bootstrap-read-theme.min.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- NAVBAR SECTION -->
		<%@include file="./shared/navbar.jsp"%>
		<!------------------------------------------------->

		<div class="content">
			
			<!-- HOME SECTION -->
			<c:if test="${userClicksHome == true}">
				<%@include file="./home.jsp"%>
			</c:if>
			<!-------------------------------------------------->

			<!-- ABOUT US SECTION -->
			<c:if test="${userClicksAboutUs == true}">
				<%@include file="./about.jsp"%>
			</c:if>
			<!--------------------------------------------------->


			<!-- CONTACT US SECTION -->
			<c:if test="${userClicksContactUs == true}">
				<%@include file="./contact.jsp"%>
			</c:if>
			<!---------------------------------------------------->

		</div>

		<!-- FOOTER SECTION -->
		<%@include file="./shared/footer.jsp"%>
		<!----------------------------------------------------->



		<!-- JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.js"></script>

		<!-- Readable-Theme-Bootstrap JS -->
		<script src="${js}/usebootstrap.js"></script>
	</div>
</body>

</html>
