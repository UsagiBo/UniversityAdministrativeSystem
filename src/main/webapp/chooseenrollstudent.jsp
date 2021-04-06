<%-- 
    Document   : chooseenrollstudent
    Created on : Apr 6, 2021, 3:15:16 PM
    Author     : geusa
--%>

<%@page import="com.mycompany.uniadminsystem.Subject"%>
<%@page import="com.mycompany.uniadminsystem.Student"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choose Student</title>
    </head>
    <body>
        <a href="/UniAdminSystem/" accesskey="1" title="">Back to Home</a><br>

        <form action="<%= request.getContextPath() %>/enrollstudent" method="get">

            <%List<Student> students = (List)request.getAttribute("students"); 
        if(!(students.isEmpty())){%>
            Student:
            <select name="student">
                <%
                for(Student s: students){
                %>
                <option value="<%=s.getId()%>"> <%=s.getName()%> </option>
                <%}%>
            </select>
            <input type="submit" value="Choose Student" />
        </form>
        <% }else{
        %><h1>There are no Students in the University Database!</h1>
        <a href="/UniAdminSystem/sampledata" accesskey="1" title="">Add Sample Data to Database?</a>
        <%}%>
    </body>
</html>
