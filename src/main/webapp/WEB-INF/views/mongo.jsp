<%@ page import="com.mongodb.MongoClient" %>
<%@ page import="com.mongodb.DB" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: niebuhr
  Date: 22.01.16
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>MongoDb Test Stuff</h1>

    <div>
        <h2>Mongo DB's: </h2>

        <c:forEach items="${dbs}" var="item" varStatus="status">
            <p>${item}</p>
        </c:forEach >
    </div>

    <div>
        <h2>Restaurant's: </h2>

        <c:forEach items="${restaurants}" var="item" varStatus="status">
            <p>${item}</p>
        </c:forEach >
    </div>

</body>
</html>
