<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resources" />
<%@ page isELIgnored="false" %>
<html>
<body>
<br>
<form>
            <select id="language" name="language" onchange="submit()">
            	<option value="ru" ${language == 'ru' ? 'selected' : ''}>Русский</option>
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                
            </select>
        </form>
<a href="${pageContext.request.contextPath}/login_page"><fmt:message key="Login" /></a><br>
<a href="${pageContext.request.contextPath}/registration_page"><fmt:message key="Registration" /></a><br>
<a href="${pageContext.request.contextPath}/admin_login_page"><fmt:message key="Login_as_Admin" /></a>
 	<br>
 	
	<h1><fmt:message key="Login_as_Admin" /></h1><br>
        <form method="POST" action="driverconfirmation">

            <fmt:message key="LOGIN" /> <input type="text" required placeholder="login" name="login"><br>
            <fmt:message key="PASSWORD" /> <input type="password" required placeholder="password" name="password"><br><br>
            <input class="button" type="submit" value="<fmt:message key="Login" />">

        </form>
</body>
</html>