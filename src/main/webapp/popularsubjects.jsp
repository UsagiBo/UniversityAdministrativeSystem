<%-- 
    Document   : popularsubjects
    Created on : Apr 6, 2021, 11:54:48 AM
    Author     : geusa
--%>

<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Top 3 Subjects</title>
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
                List<Object[]> popSubjects = (List) request.getAttribute("popSubjects"); 
                if(!(popSubjects.isEmpty())){
                %> 
                <table id="students" style="border: 1px solid black">
                    <thead>
                        <tr>
                            <th>Place </th>
                            <th>Subject Name</th>
                            <th>Number of Students</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            int place = 1;
                        for (Object[] u : popSubjects) { 
                            String name = u[0].toString();
                            int students = new Integer(u[1].toString());
                        %> 
                        <tr>
                            <td><%=place%></td>
                            <td><%=name%></td> 
                            <td><%=students%></td> 
                        </tr>
                        <% place++;} %> 
                    </tbody>
                </table>
                <% 
                    } else{
                %>
                <h1>There are no Subjects in the University Database!</h1>
                <a href="/UniAdminSystem/sampledata" accesskey="1" title="">Add Sample Data to Database?</a>
                <%
                }
                %>
            </div>
        </section>
</body>
</html>
