<%-- 
    Document   : studentcredits
    Created on : Apr 5, 2021, 9:55:52 PM
    Author     : geusa
--%>

<%@page import="com.mycompany.uniadminsystem.Subject"%>
<%@page import="com.mycompany.uniadminsystem.Student"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="styles.css">
    <title>Students/Courses</title>
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
                List<Object[]> studentCredits = (List) request.getAttribute("studentCredits"); 
                if(!(studentCredits.isEmpty())){
                %> 
                <table id="students" style="border: 1px solid black">
                    <thead>
                        <tr>
                            <th>Student Name</th>
                            <th>Number of Credits</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                        for (Object[] u : studentCredits) { 
                            String name = u[0].toString();
                            double credits = new Double(u[1].toString());
                        %> 
                        <tr> 
                            <td><%=name%></td> 
                            <td><%=credits%></td> 
                        </tr>
                        <% } %> 
                    </tbody>
                </table>
                <% } else{
                %>
                <h1>There are no Students in the University Database!</h1>
                <a href="/UniAdminSystem/sampledata" accesskey="1" title="">Add Sample Data to Database?</a>
                <%
                }
                %>
            </div>
        </section>
</body>
</html>

