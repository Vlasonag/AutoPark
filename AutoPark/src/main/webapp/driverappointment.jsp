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
<a href="${pageContext.request.contextPath}/driver_appointment"><fmt:message key="Appointment" /></a>
	<br>
	<a href="${pageContext.request.contextPath}/logout"><fmt:message key="Logout" /></a>
	<hr/>
		<h3><fmt:message key="Appointment" /></h3>
		|<fmt:message key="Route_name" />: <c:out value="${app.route_name}"/>|
		<fmt:message key="Route_distance" />: <c:out value="${app.route_distance}"/><fmt:message key="km" />|
		<fmt:message key="Car_number" />: <c:out value="${app.car_number}"/>|
		<fmt:message key="Car_model" />: <c:out value="${app.car_model}"/>|
		<fmt:message key="Is_confirmed" />: <c:out value="${app.confirmed}"/>|
		<form method="POST" action="confirm_appointment">
			<input class="button" type="submit" value="<fmt:message key="Confirm_appointment" />">
        </form>
</body>
</html>