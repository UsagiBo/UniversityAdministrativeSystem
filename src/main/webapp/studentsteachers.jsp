<%-- 
    Document   : studentsteachers
    Created on : Apr 5, 2021, 9:24:09 PM
    Author     : geusa
--%>
<%@page import="com.mycompany.uniadminsystem.Teacher"%>
<%@page import="com.mycompany.uniadminsystem.Subject"%>
<%@page import="com.mycompany.uniadminsystem.Student"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<head>
    <title>Students/Teachers</title>
    <style>
    table, th, td {
      border: 1px solid black;
    }
    table {
  border-collapse: collapse;
    }
    td{
        padding: 10px;
}

    </style>
</head>
<body>
    <a href="/UniAdminSystem/" accesskey="1" title="">Back to Home</a><br>
    <div align="center" >
        <section>
            <div>

        <% 
        List<Student> students = (List) request.getAttribute("students"); 
        if(!(students.isEmpty())){
        %> 
                <table style="border: 1px solid black">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Semester</th>
                    </tr>
        </thead>
        <tbody>
            <% 
            for (Student u : students) { 
            %> 
                    <tr> 
                        <td><%=u.getName()%></td> 
                        <td><%=u.getSemester()%></td> 
                    </tr>
                    <%}%>
                </tbody>
                </table>
        <%
    }
        else{
        %>
                <h1>There are no Students in the University Database!</h1>
                <a href="/UniAdminSystem/sampledata" accesskey="1" title="">Add Sample Data to Database?</a>
        <%
        }
        %>
         <% 
        List<Teacher> teachers = (List) request.getAttribute("teachers"); 
        if(!(teachers.isEmpty())){
        %> 
                <table style="border: 1px solid black">
                    <thead>
                    <tr>
                        <th>Full Name</th>
                        <th> Number of Subjects</th>
                    </tr>
                </thead>
        <tbody>
            <% 
            for (Teacher u : teachers) { 
            %> 
                    <tr> 
                        <td><%=u.getName()%></td> 
                        <td><%=u.getSubjects().size()%></td> 
                    </tr>
                <%}%> 
        </tbody>
                </table>
        <%
        }
        else{
        %>
                <h1>There are no Teachers in the University Database!</h1>
                <a href="/UniAdminSystem/sampledata" accesskey="1" title="">Add Sample Data to Database?</a>
        <%
        }
        %>
            </div>
        </section>

</body>
</html>

