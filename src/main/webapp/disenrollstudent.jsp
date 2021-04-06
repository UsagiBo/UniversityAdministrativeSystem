<%-- 
    Document   : enrollstudent
    Created on : Apr 5, 2021, 11:47:40 AM
    Author     : geusa
--%>
<a href="enrollstudent.jsp"></a>
<%@page import="com.mycompany.uniadminsystem.Subject"%>
<%@page import="com.mycompany.uniadminsystem.Student"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disenroll Student</title>
    </head>
    <body>
        <a href="/UniAdminSystem/" accesskey="1" title="">Back to Home</a><br>

        <%Student student = (Student)request.getAttribute("student");  %>

        <p>Choose a subject to disenroll <%=student.getName()%> from:</p>
        <form action="<%= request.getContextPath() %>/disenrollstudent" method="post">
            <input type="hidden" " name="studentID" value="<%=student.getId()%>">
            <% List<Subject> subjects = student.getSubjects();
            if(!(subjects.isEmpty())){%>
            Subject:
            <select name="subject">
                <%
                for(Subject su: subjects){
                %>
                <option value="<%=su.getId()%>"> <%=su.getName()%> </option>
                <%}%>
            </select>
            <input type="submit" value="Disenroll Student" />
        </form>
        <% }else{
        %><h1>There are no Subjects in the University Database!</h1>
        <a href="/UniAdminSystem/sampledata" accesskey="1" title="">Add Sample Data to Database?</a>
        <%}%>


    </body>
</html>
