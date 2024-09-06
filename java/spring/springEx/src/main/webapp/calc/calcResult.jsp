<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2024-09-04
  Time: 오후 2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>계산결과</title>
</head>
<body>
    <h1> NUMB1 : ${param.num1}</h1>
    <h1> NUMB2 : ${param.num2}</h1>
    <h1> SUM : ${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)}</h1>
</body>
</html>
