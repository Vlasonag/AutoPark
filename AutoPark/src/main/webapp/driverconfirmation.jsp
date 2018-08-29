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
	<a href="${pageContext.request.contextPath}/driverconfirmation">Confirmation</a>
	<a href="${pageContext.request.contextPath}/routes">Routes</a>
	<a href="${pageContext.request.contextPath}/cars">Cars</a>
	<a href="${pageContext.request.contextPath}/appointment">Make an Appointment</a>
	<a href="${pageContext.request.contextPath}/appointments">Appointments</a>
        <br>
	<a href="${pageContext.request.contextPath}/logout">Logout</a>
	<h1>Driver Confirmation</h1>
	<hr/>
	<form method="GET" action="confirmdriverbyid">

            ID: <input type="text" required placeholder="ID" name="id"> 
             <input class="button" type="submit" value="Confirm driver by ID">

        </form>
	<c:forEach var="driverlist" items="${driverlist}">
		<ul>
		
			<li>ID: <c:out value="${driverlist.id}"/></li>
			<li>Login: <c:out value="${driverlist.login}"/></li>
			<li>Password: <c:out value="${driverlist.password}"/></li>
			
		</ul>
	</c:forEach>
	
        
</body>
</html>