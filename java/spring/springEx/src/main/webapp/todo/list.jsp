<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2024-09-05
  Time: 오전 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%-- JSTL 사용 태그 추가--%>
<html>
<head>
    <title>Todo List Page</title>
</head>
<body>
  <h1>Todo List Page</h1>
<%--    ${dtoList}--%>
<%--    ${dtoList[0].tno} --- ${dtoList[0].title} --- ${dtoList[0].dueDate}--%>
<%--    <h3>${1+2+3}</h3> &lt;%&ndash;  expression 사용&ndash;%&gt;--%>
<%--    <h3>${"AAA" += "BBB"}</h3>--%>
<%--    <h3>${"rrr".equals("rrrr")}</h3>--%>

<%--    반복문, 제어문을 사용하려면 JSTL 사용 (statement)--%>
    <ul>
        <c:forEach var="dto" items="${dtoList}">
            <li>${dto}</li>
        </c:forEach>
    </ul>
</body>
</html>
