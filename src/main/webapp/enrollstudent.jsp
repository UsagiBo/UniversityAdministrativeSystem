<%-- 
    Document   : enrollstudent
    Created on : Apr 5, 2021, 11:47:40 AM
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
        <title>Enroll Student</title>
    </head>
    <body>
        <a href="/UniAdminSystem/" accesskey="1" title="">Back to Home</a><br>
        <%Student student = (Student)request.getAttribute("student");  %>
        <%
                boolean noSubjects = (Boolean) request.getAttribute("noSubjects");
                if(noSubjects){%>
        <h1>There are no more course available for student <%=student.getName()%> !</h1>
        <%} else{%>
        <p>Choose a subject to enroll <%=student.getName()%> in:</p>
        <form action="<%= request.getContextPath() %>/enrollstudent" method="post">
            <input type="hidden" " name="studentID" value="<%=student.getId()%>">
            <% List<Subject> subjects = (List) request.getAttribute("allsubjects");
            if(!(subjects.isEmpty())){%>
            Subject:
            <select name="subject">
                <%
                for(Subject su: subjects){
                %>
                <option value="<%=su.getId()%>"> <%=su.getName()%> </option>
                <%}%>
            </select>
            <input type="submit" value="Enroll Student" />
        </form>
        <% }else{
        %><h1>There are no Subjects in the University Database!</h1>
        <a href="/UniAdminSystem/sampledata" accesskey="1" title="">Add Sample Data to Database?</a>
        <%}
}%>


    </body>
</html>
