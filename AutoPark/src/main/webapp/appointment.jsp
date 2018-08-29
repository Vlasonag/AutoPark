<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<form method="POST" action="makeanappointment">
	<table border="1" width="100%">
	<tbody>  
		<tr>
    		<td>    
    			<c:forEach var="routelist" items="${routelist}">    	
	                <p><input name="route" type="radio" value="${routelist.name} ${routelist.distance}" />Name: <c:out value="${routelist.name}"/>
		            	<br>
		                Distance: <c:out value="${routelist.distance} km"/>
	                </p>
    			</c:forEach>     
    		</td>
  	
    		<td>
                <c:forEach var="carlist" items="${carlist}">
                	<p>
	                	<input name="car" type="radio" value="${carlist.number}" />Number: <c:out value="${carlist.number}"/>
	                	<br>
	                   	Model: <c:out value="${carlist.model}"/>
                	</p>
    			</c:forEach> 
    		</td>
  
  			<td>
                <c:forEach var="driverlist" items="${driverlist}">
                	<p>
	                	<input name="driver" type="radio" value="${driverlist.id}" />ID: <c:out value="${driverlist.id}"/>
	               		<br>
	                   	Login: <c:out value="${driverlist.login}"/>
                	</p>    
    			</c:forEach> 
  			</td> 
  			 
		</tr>
	</tbody>
	</table>
	<br>
	<input class="button" type="submit" value="Make an appointment">
 </form>
</body>
</html>