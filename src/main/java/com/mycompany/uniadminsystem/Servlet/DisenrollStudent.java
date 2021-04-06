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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author geusa
 */
@WebServlet(name = "DisenrollStudent", urlPatterns = {"/disenrollstudent"})
public class DisenrollStudent extends HttpServlet {

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
        //show chosen Student

        SubjectDAO sudao = new SubjectDAO();
        List<Subject> subjects = sudao.getAll();
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("/enrollstudent.jsp").forward(request, response);
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
        //get studentID from /choosestudent
        int studentID = Integer.parseInt(request.getParameter("student"));

        StudentDAO sdao = new StudentDAO();
        Optional<Student> object = sdao.get(studentID);
        Student student = object.orElseThrow(RuntimeException::new);
        request.setAttribute("student", student);
        request.getRequestDispatcher("/disenrollstudent.jsp").forward(request, response);
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
        int studentID = Integer.parseInt(request.getParameter("studentID"));
        int subjectID = Integer.parseInt(request.getParameter("subject"));
        StudentDAO sdao = new StudentDAO();
        Optional<Student> object = sdao.get(studentID);
        Student student = object.orElseThrow(RuntimeException::new);

        SubjectDAO sudao = new SubjectDAO();
        Optional<Subject> object1 = sudao.get(subjectID);
        Subject subject = object1.orElseThrow(RuntimeException::new);

        List<Subject> allNewSubjects = new ArrayList();
        for (Subject j : student.getSubjects()) {
            if (j.getId() == subject.getId()) {
            } else {
                allNewSubjects.add(j);
            }
        }
        student.setSubjects(allNewSubjects);
        List<Student> allNewStudents = new ArrayList();
        for (Student j : subject.getStudents()) {
            if (j.getId() == student.getId()) {
            } else {
                allNewStudents.add(j);
            }
        }
        subject.setStudents(allNewStudents);
        sdao.delete(student);
        sdao.save(student);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Enrollment</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"/UniAdminSystem/\" accesskey=\"1\" title=\"\">Back to Home</a>");
            out.println("<h1>" + student.getName() + " was disenrolled from " + subject.getName() + "</h1>");
            out.println("</body>");
            out.println("</html>");

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
