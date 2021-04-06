<%-- 
    Document   : newstudent
    Created on : Apr 1, 2021, 12:57:26 PM
    Author     : geusa
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.mycompany.uniadminsystem.Student" %>
<!DOCTYPE HTML >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Student</title>
    </head>

    <body>
        <a href="/UniAdminSystem/" accesskey="1" title="">Back to Home</a><br>
        <h2>Enter information on the new Student:</h2>
        <form action="<%= request.getContextPath() %>/newstudent" method="post">
            Student Name:  <input type="text" name="name" >
            Semester: <input type="text" name="semester" value="1">
            <input type="submit" value="Add Student" />
        </form>
    <body>
</html>
