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
	<form method="GET" action="create_route">

            <fmt:message key="Distance" />: <input type="text" required placeholder="distance" name="distance">
             <fmt:message key="Name" />: <input type="text" required placeholder="name" name="name">
             
             <input class="button" type="submit" value="<fmt:message key="Create_route" />">

        </form>
        <form method="POST" action="delete_route">

            ID: <input type="text" required placeholder="id" name="id"> 
             <input class="button" type="submit" value="<fmt:message key="Delete" />">

        </form>
	<h1><fmt:message key="Routes" /></h1>
	<c:forEach var="routelist" items="${routelist}">
		<ul>
		
			<li>ID: <c:out value="${routelist.id}"/></li>
			<li><fmt:message key="Distance" />: <c:out value="${routelist.distance}"/><fmt:message key="km" /></li>
			<li><fmt:message key="Name" />: <c:out value="${routelist.name}"/></li>
			
		</ul>
	</c:forEach>
	
	
</body>
</html>