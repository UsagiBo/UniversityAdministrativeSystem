/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uniadminsystem.Servlet;

import com.mycompany.uniadminsystem.DAO.StudentDAO;
import com.mycompany.uniadminsystem.DAO.SubjectDAO;
import com.mycompany.uniadminsystem.Student;
import com.mycompany.uniadminsystem.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author geusa
 */
@WebServlet(name = "EnrollStudent", urlPatterns = {"/enrollstudent"})
public class EnrollStudent extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*StudentDAO sdao = new StudentDAO();
        
        List<Student> students = sdao.getAll();
        request.setAttribute("students", students);*/

        //request.getRequestDispatcher("/enrollstudent.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentID = Integer.parseInt(request.getParameter("student"));

        StudentDAO sdao = new StudentDAO();
        Optional<Student> object = sdao.get(studentID);
        Student student = object.orElseThrow(RuntimeException::new);

        SubjectDAO sudao = new SubjectDAO();
        List<Subject> allsubjectstemp = sudao.getAll();
        List<Long> idList = new ArrayList();
        List<Subject> allsubjects = new ArrayList();
        boolean studentNoSubjects = false;
        if (allsubjectstemp.size() == student.getSubjects().size()) {
            studentNoSubjects = true;
        } else {
            for (Subject s : student.getSubjects()) {
                idList.add(s.getId());
            }
            for (Subject s : allsubjectstemp) {
                if (!idList.contains(s.getId())) {
                    allsubjects.add(s);
                }
            }
        }
        request.setAttribute("noSubjects", studentNoSubjects);
        request.setAttribute("student", student);
        request.setAttribute("allsubjects", allsubjects);

        request.getRequestDispatcher("/enrollstudent.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        long studentID = Long.parseLong(request.getParameter("studentID"));
        long subjectID = Long.parseLong(request.getParameter("subject"));
        StudentDAO sdao = new StudentDAO();

        Optional<Student> object = sdao.get(studentID);
        Student student = object.orElseThrow(RuntimeException::new);
        SubjectDAO sudao = new SubjectDAO();

        Optional<Subject> object1 = sudao.get(subjectID);
        Subject subject = object1.orElseThrow(RuntimeException::new);

        if (student.getSubjects().contains(subject)) {

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Enrollment</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<a href=\"/UniAdminSystem/\" accesskey=\"1\" title=\"\">Back to Home</a>");
                out.println("<h1>" + student.getName() + " is already enrolled in " + subject.getName() + ". Choose another subject and try again.</h1>");
                out.println("<a href=\"/UniAdminSystem/enrollstudent\" accesskey=\"1\" title=\"\">Enroll Student in a Subject.</a>");
                out.println("</body>");
                out.println("</html>");

            }
        } else {
            student.getSubjects().add(subject);
            subject.getStudents().add(student);
            sdao.updateStudent(student);
            sudao.updateSubject(subject);
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Enrollment</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<a href=\"/UniAdminSystem/\" accesskey=\"1\" title=\"\">Back to Home</a>");
                out.println("<h1>" + student.getName() + " was enrolled in " + subject.getName() + "</h1>");
                out.println("</body>");
                out.println("</html>");

            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
