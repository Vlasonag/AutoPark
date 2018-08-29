<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/driver_appointment">Appointment</a>
	<br>
	<a href="${pageContext.request.contextPath}/logout">Logout</a>
	<hr/>
		<h3>Appointment</h3>
		|Route name: <c:out value="${app.route_name}"/>|
		Route distance: <c:out value="${app.route_distance} km"/>|
		Car number: <c:out value="${app.car_number}"/>|
		Car model: <c:out value="${app.car_model}"/>|
		Is confirmed: <c:out value="${app.confirmed}"/>|
		<form method="POST" action="confirm_appointment">
			<input class="button" type="submit" value="Confirm appointment">
        </form>
</body>
</html>