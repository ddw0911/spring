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
  <h2>${appName}</h2>
  <h2>${loginInfo}</h2>
  <h3>${loginInfo.mname}</h3>

  <ul>
      <c:forEach items="${dtoList}" var="dto">
          <li>
<%--              ${dto}--%>
              <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
              <span>${dto.title}</span>
              <span>${dto.dueDate}</span>
              <span>${dto.finished? "DONE": "NOT YET"}</span>
          </li>
      </c:forEach>
  </ul>

  <form action="/logout" method="post">
      <button>LOGOUT</button>
  </form>
</body>
</html>
