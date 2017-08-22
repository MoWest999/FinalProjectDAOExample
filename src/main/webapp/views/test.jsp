<%--
  Created by IntelliJ IDEA.
  User: kamel
  Date: 7/13/2016
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
Hellloooo
<ul>
<c:forEach var="item"  items="${rList}">

    <li>${item}</li>

</c:forEach>
</ul>
</body>
</html>
