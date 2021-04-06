<%-- 
    Document   : teachers
    Created on : Apr 2, 2021, 9:51:01 PM
    Author     : geusa
--%>
<%@page import="com.mycompany.uniadminsystem.Teacher"%>
<%@page import="com.mycompany.uniadminsystem.Subject"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<head>
    <title>Top 3 Teachers</title>
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
        <section id="teachers" class="section">
            <div class="container">

                <% 
               List<Object[]> teachers = (List) request.getAttribute("teachers"); 
                if(!(teachers.isEmpty())){
                %> 
                <table id="teachers" style="border: 1px solid black">
                    <thead>
                        <tr>
                            <th>Teacher Name</th>
                            <th>Num of Students</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                        for (Object[] u : teachers) {
                            String name = u[0].toString();
                            long students = new Long(u[1].toString());
                        %> 
                        <tr> 
                            <td><%=name%></td> 
                            <td><%=students%></td> 
                        </tr>
                        <%
                    } 
                        %> 
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
