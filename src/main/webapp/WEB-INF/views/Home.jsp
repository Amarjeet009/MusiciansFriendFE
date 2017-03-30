<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>

	<h2>
		<center>Musician'sFriend</center>
	</h2>
	
 <center> ${msg}</center>
 
 <center>${successMessage}</center>
	<center>${errorMessage}</center>
	${loginMessage}
	<hr>

	<c:if test="${empty loginMessage}">
		<a href="login">Login</a>
	</c:if>

	<a href="register"> Register</a>
	<a href="contact"> Contact Us</a>
	<a href="aboutUs"> About Us</a>
	<br>

	<c:if test="${not empty loginMessage}">
		<a href="mycart">My Cart</a>
		<a href="logout">Logout</a>
	</c:if>

	<c:if test="${isUserClickedLogin==true}">
		<jsp:include page="/WEB-INF/views/Login.jsp"></jsp:include>
	</c:if>
	
	<c:if test="${not empty errorMessage}">
	    <jsp:include page="/WEB-INF/views/Login.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedRegister==true}">
		<jsp:include page="/WEB-INF/views/Registration.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedAboutUs==true}">
		<jsp:include page="/WEB-INF/views/aboutUs.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedContactUs==true}">
		<jsp:include page="/WEB-INF/views/contact.jsp"></jsp:include>
	</c:if>


</body>
</html>