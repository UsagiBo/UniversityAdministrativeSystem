/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uniadminsystem.Servlet;

import com.mycompany.uniadminsystem.DAO.SubjectDAO;
import com.mycompany.uniadminsystem.DAO.TeacherDAO;
import com.mycompany.uniadminsystem.Subject;
import com.mycompany.uniadminsystem.Teacher;
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
@WebServlet(name = "NewSubjectServlet", urlPatterns = {"/newsubject"})
public class NewSubjectServlet extends HttpServlet {

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
        TeacherDAO tdao = new TeacherDAO();
        List<Teacher> teachers = tdao.getAll();
        request.setAttribute("teachers", teachers);
        request.getRequestDispatcher("/newsubject.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        TeacherDAO tdao = new TeacherDAO();
        List<Teacher> teachers = tdao.getAll();
        request.setAttribute("teachers", teachers);
        request.getRequestDispatcher("/newsubject.jsp").forward(request, response);

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
        String teacherIDorNot = request.getParameter("teacherID");

        SubjectDAO sudao = new SubjectDAO();
        Subject subject = new Subject();
        subject.setName(request.getParameter("name"));
        double credit = new Double(request.getParameter("credit"));
        if (credit <=30) {
            subject.setCredit(credit);
            subject.setStudents(new ArrayList());
            sudao.save(subject);
            if (!(teacherIDorNot.contains("none"))) {
                TeacherDAO tdao = new TeacherDAO();
                Optional<Teacher> object = tdao.get(Long.parseLong(teacherIDorNot));
                Teacher teacher = object.orElseThrow(RuntimeException::new);

                teacher.getSubjects().add(subject);
                tdao.update(teacher);
            }

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>New Student</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<a href=\"/UniAdminSystem/\" accesskey=\"1\" title=\"\">Back to Home</a>");
                out.println("<h1> The Subject " + subject.getName() + " was added to the Univerisy! </h1>");
                out.println("</body>");
                out.println("</html>");

            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>New Student</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<a href=\"/UniAdminSystem/\" accesskey=\"1\" title=\"\">Back to Home</a>");
                out.println("<h1> The maximum number of credits per subject are 30! Adjust number of credits and try again.</h1>");
                out.println("<a href=\"/UniAdminSystem/newsubject\" accesskey=\"1\" title=\"\">Add new Subject</a>");
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
