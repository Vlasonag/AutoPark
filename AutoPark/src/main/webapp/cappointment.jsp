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
	<%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
        <td><a href="appointments?page=${currentPage - 1}"><fmt:message key="Previous" /></a></td>
    </c:if>
 
    <%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="appointments?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
     
    <%--For displaying Next link --%>
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="appointments?page=${currentPage + 1}"><fmt:message key="Next" /></a></td>
    </c:if>
</body>
</html>