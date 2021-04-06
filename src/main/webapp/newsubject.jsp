<%-- 
    Document   : newsubject
    Created on : Apr 5, 2021, 5:51:06 PM
    Author     : geusa
--%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.mycompany.uniadminsystem.Teacher" %>
<%@page import="com.mycompany.uniadminsystem.Subject" %>
<!DOCTYPE HTML >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Subject</title>
    </head>

    <body>
        <a href="/UniAdminSystem/" accesskey="1" title="">Back to Home</a><br>
        <h2>Enter information on the new Subject:</h2>
        <form action="<%= request.getContextPath() %>/newsubject" method="post">
            Name: <input type="text" name="name" >
            Credits: <input type="text" name="credit" >

            <%List<Teacher> teachers = (List)request.getAttribute("teachers");%>
            Teacher:
            <select name="teacherID">
                <option value="none"> None </option>
                <%for(Teacher s: teachers){%>
                <option value="<%=s.getId()%>"> <%=s.getName()%> </option>
                <%}%>
            </select>

            <input type="submit" value="Add Subject" />
        </form>
    <body>
</html>
