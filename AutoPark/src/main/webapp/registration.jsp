<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">Login</a><br>
<a href="${pageContext.request.contextPath}/registration.jsp">Registration</a><br>
<a href="${pageContext.request.contextPath}/admin_login.jsp">Login as Admin</a>
	<br>
	<h1>Регистрация</h1><br>
        <form method="GET" action="/AuthenticationFilter">

            <input type="text" required placeholder="login" name="login"><br>
            <input type="password" required placeholder="password" name="password"><br><br>
            <input class="button" type="submit" value="Войти">

        </form>
</body>
</html>