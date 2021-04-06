<%-- 
    Document   : home
    Created on : Mar 29, 2021, 8:33:47 PM
    Author     : geusa
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
    <head>
        <title>University Admin System</title>
    </head>
    <body>
        <h1>Welcome to the University Administrative System of the Computer Science Department of Imaginary University</h1>
	    <p>A warm welcome from the Developers: ${text}</p><br>
            
            <a href="/UniAdminSystem/sampledata" accesskey="1" title="">Add Sample Data to Database?</a><br>
            <br>
            <a href="/UniAdminSystem/studentsteachers" accesskey="1" title="">See all Students and Teachers</a><br>
            <br>
            <a href="/UniAdminSystem/students" accesskey="1" title="">See all Students and their Courses</a><br>
            <a href="/UniAdminSystem/studentcredits" accesskey="1" title="">See all Students and their number of Credits</a><br>
            <a href="/UniAdminSystem/newstudent" accesskey="1" title="">Add a new Student</a><br>
            <a href="/UniAdminSystem/chooseenrollstudent" accesskey="1" title="">Enroll a student in a course</a><br>
            <a href="/UniAdminSystem/choosestudent" accesskey="1" title="">Disenroll a student from a course</a>
            <br><br>
            <a href="/UniAdminSystem/teachers" accesskey="1" title="">See all Teacher their Subjects and number of Students</a><br>
            <a href="/UniAdminSystem/popularteachers" accesskey="1" title="">See top 3 most popular Teacher</a><br>
            <a href="/UniAdminSystem/newteacher" accesskey="1" title="">Add a new Teacher</a><br>
            <br>
            <a href="/UniAdminSystem/popularsubjects" accesskey="1" title="">See top 3 most popular Subjects</a><br>
            <a href="/UniAdminSystem/newsubject" accesskey="1" title="">Add a new Subject</a><br>
            <br>
            
    </body>
</html>