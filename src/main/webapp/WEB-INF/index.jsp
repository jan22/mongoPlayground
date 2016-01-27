<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.mongodb.MongoClient" %>
<%@ page import="com.mongodb.DB" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>


<h1>MongoDb Test Stuff</h1>

<%
    MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

    DB db = mongoClient.getDB("test");

    List<String> dbNames = mongoClient.getDatabaseNames();

    for(String dbName : dbNames){
                System.out.println(dbName);
    }


%>


<div>
    <h2> Mongo DB's: </h2>

    <%  for(String element: dbNames) { %>
        <p><%=element%></p>
    <% } %>

</div>

</body>
</html>
