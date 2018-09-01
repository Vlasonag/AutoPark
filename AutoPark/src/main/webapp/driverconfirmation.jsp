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
	<form method="GET" action="confirm_driver_by_id">

            ID: <input type="text" required placeholder="ID" name="id"> 
             <input class="button" type="submit" value=<fmt:message key="Confirm_driver_by_ID" />>

        </form>
	<h1><fmt:message key="Confirmation" /></h1>
	
	
	<c:forEach var="driverlist" items="${driverlist}">
		<ul>
		
			<li>ID: <c:out value="${driverlist.id}"/></li>
			<li><fmt:message key="Driver_login" />: <c:out value="${driverlist.login}"/></li>
			<li><fmt:message key="Driver_password" />: <c:out value="${driverlist.password}"/></li>
			
		</ul>
	</c:forEach>
	
        
</body>
</html>