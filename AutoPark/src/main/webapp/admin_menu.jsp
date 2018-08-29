<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello, admin</h1>
	<a href="${pageContext.request.contextPath}/driverconfirmation">Confirmation</a>
	<a href="${pageContext.request.contextPath}/routes">Routes</a>
	<a href="${pageContext.request.contextPath}/cars">Cars</a>
	<a href="${pageContext.request.contextPath}/appointment">Make an Appointment</a>
	<a href="${pageContext.request.contextPath}/appointments">Appointments</a>
	<br>
	<a href="${pageContext.request.contextPath}/logout">Logout</a>
</body>
</html>