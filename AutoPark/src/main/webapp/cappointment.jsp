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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	<c:forEach var="applist" items="${applist}">
		<h3><fmt:message key="Appointment" /></h3>
		| <fmt:message key="Route_name" />: <c:out value="${applist.route_name}"/>|
		<fmt:message key="Route_distance" />: <c:out value="${applist.route_distance}"/><fmt:message key="km" />|
		<fmt:message key="Car_number" />: <c:out value="${applist.car_number}"/>|
		<fmt:message key="Car_model" />: <c:out value="${applist.car_model}"/>|
		<fmt:message key="Driver_id" />: <c:out value="${applist.driver_id}"/>|
		<fmt:message key="Driver_login" />: <c:out value="${applist.driver_login}"/>|
		<fmt:message key="Is_confirmed" />: <c:out value="${applist.confirmed}"/>|
		
		<form method="POST" action="cancel_appointment">
			
        	<input class="button" type="submit" value=<fmt:message key="Cancel_this_appointment" />>
        	<input type="hidden" name="number" value="${applist.car_number}">
        	<input type="hidden" name="id" value="${applist.driver_id}">
        </form>
		<br>
	</c:forEach>
</body>
</html>