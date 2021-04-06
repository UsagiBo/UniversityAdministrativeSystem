<%-- 
    Document   : students.jsp
    Created on : Mar 28, 2021, 2:28:59 PM
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
        <section id="students" class="section">
            <div class="container">

        <% 
        List<Student> students = (List) request.getAttribute("students"); 
        if(!(students.isEmpty())){
        %> 
                <table id="students" style="border: 1px solid black">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Semester</th>
                        <th>Subjects</th>
                    </tr>

        </thead>
        <tbody>
            <% 
            for (Student u : students) { 
            List<Subject> subjects = u.getSubjects(); 
            int d = subjects.size();
            boolean nostud = false;
            if(d==0){
                d=1;
                nostud =true;
            }
            
            %> 
                    <tr> 
                        <td rowspan="<%=d%>"><%=u.getId()%></td> 
                        <td rowspan="<%=d%>"><%=u.getName()%></td> 
                        <td rowspan="<%=d%>"><%=u.getSemester()%></td> 
                       
                       
                <% if(nostud){
                    %>
                    <td></td></tr>
                <%
                }
                else{
                    int i = 0;
                for (Subject s : subjects) { 
                    if(i==0){%>
                    <td><%=s.getName()%></td>
                    </tr>
                <%
                    }else{%>
                     </tr>
                     <tr> <td><%=s.getName()%></td></tr>
                <%}
               i++; } 
            } }
            %> 
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
            </div>
        </section>

</body>
</html>
