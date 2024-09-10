<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2024-09-10
  Time: 오전 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <c:if test="${param.result == 'error'}">
        <h1>로그인 에러</h1> </c:if>
    <form action="/login" method="post">
        <div><input type="text" name="mid"></div>
        <div><input type="text" name="mpw"></div>
        <button type="submit">Login</button>
    </form>
</body>
</html>
