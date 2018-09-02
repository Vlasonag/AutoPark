<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resources" />
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<br>
		<form>
            <select id="language" name="language" onchange="submit()">
            	<option value="ru" ${language == 'ru' ? 'selected' : ''}>Русский</option>
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                
            </select>
        </form>
	<a href="${pageContext.request.contextPath}/driver_confirmation"><fmt:message key="Confirmation" /></a><br>
	<a href="${pageContext.request.contextPath}/routes"><fmt:message key="Routes" /></a><br>
	<a href="${pageContext.request.contextPath}/cars"><fmt:message key="Cars" /></a><br>
	<a href="${pageContext.request.contextPath}/appointment"><fmt:message key="Make_an_Appointment" /></a><br>
	<a href="${pageContext.request.contextPath}/appointments"><fmt:message key="Appointments" /></a>
	<br>
	<a href="${pageContext.request.contextPath}/logout"><fmt:message key="Logout" /></a>
	<hr/>
<form method="POST" action="make_an_appointment">
	<table border="1" width="100%">
	<tbody>  
		<tr>
    		<td>    
    			<c:forEach var="routelist" items="${routelist}">    	
	                <p><input name="route" type="radio" value="${routelist.name} ${routelist.distance} ${routelist.id}" /><fmt:message key="Name" />: <c:out value="${routelist.name}"/>
		            	<br>
		                <fmt:message key="Distance" />: <c:out value="${routelist.distance} "/><fmt:message key="km" />
		                <br>
		                ID: <c:out value="${routelist.id} "/>
	                </p>
    			</c:forEach>     
    		</td>
  	
    		<td>
                <c:forEach var="carlist" items="${carlist}">
                	<p>
	                	<input name="car" type="radio" value="${carlist.number}" /><fmt:message key="Number" />: <c:out value="${carlist.number}"/>
	                	<br>
	                   	<fmt:message key="Model" />: <c:out value="${carlist.model}"/>
                	</p>
    			</c:forEach> 
    		</td>
  
  			<td>
                <c:forEach var="driverlist" items="${driverlist}">
                	<p>
	                	<input name="driver" type="radio" value="${driverlist.id}" />ID: <c:out value="${driverlist.id}"/>
	               		<br>
	                   	<fmt:message key="Driver_login" />: <c:out value="${driverlist.login}"/>
                	</p>    
    			</c:forEach> 
  			</td> 
  			 
		</tr>
	</tbody>
	</table>
	<br>
	<input class="button" type="submit" value="<fmt:message key="Make_an_Appointment" />">
 </form>
</body>
</html>