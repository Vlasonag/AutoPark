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
	<hr/>
	<form method="GET" action="createroute">

            Distance: <input type="text" required placeholder="distance" name="distance">
             Name: <input type="text" required placeholder="name" name="name">
             
             <input class="button" type="submit" value="Create Route">

        </form>
        <form method="GET" action="deleteroute">

            ID: <input type="text" required placeholder="id" name="id"> 
             <input class="button" type="submit" value="Delete Route by ID">

        </form>
	<h1>Routes</h1>
	<c:forEach var="routelist" items="${routelist}">
		<ul>
		
			<li>ID: <c:out value="${routelist.id}"/></li>
			<li>Distance: <c:out value="${routelist.distance} km"/></li>
			<li>Name: <c:out value="${routelist.name}"/></li>
			
		</ul>
	</c:forEach>
	
	
</body>
</html>