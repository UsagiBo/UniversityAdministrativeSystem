<%-- 
    Document   : teachers
    Created on : Apr 2, 2021, 9:51:01 PM
    Author     : geusa
--%>
<%@page import="com.mycompany.uniadminsystem.Teacher"%>
<%@page import="com.mycompany.uniadminsystem.Subject"%>
<%@page import="com.mycompany.uniadminsystem.Student"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="styles.css">
    <title>Teachers</title>
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
                List<Object[]> teacherSubStud = (List) request.getAttribute("teacherSubStud"); 
                if(!(teacherSubStud.isEmpty())){
                %> 
                <table id="teachers" style="border: 1px solid black">
                    <thead>
                        <tr>
                            <th>Teacher Name</th>
                            <th>Subject Name</th>
                            <th>Num. of Students</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                        for (Object[] u : teacherSubStud) {
                            String tname = u[0].toString();
                            String sname = u[1].toString();
                            int scount = new Integer(u[2].toString());
                        %> 
                        <tr> 
                            <td><%=tname%></td> 
                            <td><%=sname%></td> 
                            <td><%=scount%></td> 
                        </tr>
                        <%}
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
