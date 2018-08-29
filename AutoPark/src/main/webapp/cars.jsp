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
	<h1>Cars</h1>
	<hr/>
	<form method="POST" action="createcar">

            Number: <input type="text" required placeholder="number" name="number">
             Model: <input type="text" required placeholder=model name="model">
             
             <input class="button" type="submit" value="Create Car">

        </form>
        <form method="GET" action="deletecar">

            Number: <input type="text" required placeholder="number" name="number"> 
             <input class="button" type="submit" value="Delete Car by Number">

        </form>
	<c:forEach var="carlist" items="${carlist}">
		<ul>
		
			<li>Number: <c:out value="${carlist.number}"/></li>
			<li>Model: <c:out value="${carlist.model}"/></li>
			<li>Free: <c:out value="${carlist.free}"/></li>
			
		</ul>
	</c:forEach>
	
</body>
</html>