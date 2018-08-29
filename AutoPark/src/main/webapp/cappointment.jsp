<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/driver_confirmation">Confirmation</a><br>
	<a href="${pageContext.request.contextPath}/routes">Routes</a><br>
	<a href="${pageContext.request.contextPath}/cars">Cars</a><br>
	<a href="${pageContext.request.contextPath}/appointment">Make an Appointment</a><br>
	<a href="${pageContext.request.contextPath}/appointments">Appointments</a>
	<br>
	<a href="${pageContext.request.contextPath}/logout">Logout</a>
	<hr/>
	<c:forEach var="applist" items="${applist}">
		<h3>Appointment</h3>
		|Route name: <c:out value="${applist.route_name}"/>|
		Route distance: <c:out value="${applist.route_distance} km"/>|
		Car number: <c:out value="${applist.car_number}"/>|
		Car model: <c:out value="${applist.car_model}"/>|
		Driver id: <c:out value="${applist.driver_id}"/>|
		Driver login: <c:out value="${applist.driver_login}"/>|
		Is confirmed: <c:out value="${applist.confirmed}"/>|
		
		<form method="POST" action="cancel_appointment">
			
        	<input class="button" type="submit" value="Cancel this appointment">
        	<input type="hidden" name="number" value="${applist.car_number}">
        	<input type="hidden" name="id" value="${applist.driver_id}">
        </form>
		<br>
	</c:forEach>
</body>
</html>