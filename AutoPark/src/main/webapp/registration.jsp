<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<a href="${pageContext.request.contextPath}/login_page">Login</a><br>
<a href="${pageContext.request.contextPath}/registration_page">Registration</a><br>
<a href="${pageContext.request.contextPath}/admin_login_page">Login as Admin</a>
	<br>
	<h1>Registration</h1><br>
        <form method="POST" action="registration">

            <input type="text" required placeholder="login" name="login"><br>
            <input type="password" required placeholder="password" name="password"><br><br>
            <input class="button" type="submit" value="Register">

        </form>
</body>
</html>