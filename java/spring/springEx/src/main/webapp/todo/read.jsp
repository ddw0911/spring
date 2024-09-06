<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2024-09-05
  Time: 오후 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Read Page</title>
</head>
<body>
    <form action=/todo/modify method="get">
    <div>${dto.tno}</div>
    <div>${dto.title}</div>
    <div>${dto.dueDate}</div>
    <div>${dto.finished}</div>
        <div><a href="modify.jsp"><></div>
    </form>
</body>
</html>
