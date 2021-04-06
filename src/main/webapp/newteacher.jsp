<%-- 
    Document   : newteacher
    Created on : Apr 5, 2021, 4:53:30 PM
    Author     : geusa
--%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.mycompany.uniadminsystem.Teacher" %>
<!DOCTYPE HTML >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Teacher</title>
    </head>

    <body>
        <a href="/UniAdminSystem/" accesskey="1" title="">Back to Home</a><br>
        <h2>Enter information on the new Teacher:</h2>
        <form action="<%= request.getContextPath() %>/newteacher" method="post">
            Teacher Name:  <input type="text" name="name" >
            <select name="title">
                <option value="Associate Professor"> Associate Professor </option>
                <option value="Professor"> Professor </option>
                <option value="Assistant Professor"> Assistant Professor </option>
                 <option value="Instructor"> Instructor </option>

    </select>
            <input type="submit" value="Add Teacher" />
        </form>
    <body>
</html>
