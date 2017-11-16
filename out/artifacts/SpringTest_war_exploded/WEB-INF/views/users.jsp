<%@ page import="java.util.List" %>
<%@ page import="com.spring.dao.User" %>
<%--
  Created by IntelliJ IDEA.
  User: arman
  Date: 04.11.17
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<User> users = (List<User>)request.getAttribute("users");%>
<html>
<head>
    <title>Users</title>
</head>
<body>
<%for(User u : users){%>
    <h3><%out.print(u.toString());%></h3>
<%}%>
</body>
</html>
