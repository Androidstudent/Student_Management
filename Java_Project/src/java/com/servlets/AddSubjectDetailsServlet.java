
package com.servlets;


import com.beans.SubjectDetailsBean;
import com.connection.SubjectDetailsDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raj
 */
@WebServlet("/AddSubjectDetailsServlet")
public class AddSubjectDetailsServlet extends HttpServlet {
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          SubjectDetailsBean subBean = new SubjectDetailsBean();
         // System.out.println(request.getParameter("semester")+request.getParameter("instructorId")+request.getParameter("departmentId"));
          subBean.setSubjectName(request.getParameter("subjectName"));
          subBean.setSemister(request.getParameter("semester"));
          subBean.setInstructorId(request.getParameter("instructorId"));
          subBean.setDepartmentId(request.getParameter("departmentId"));
          SubjectDetailsDB.insertSubjectDetails(subBean);
          response.sendRedirect(request.getContextPath()+"/admin/insertSuccess.jsp");
      }
}
