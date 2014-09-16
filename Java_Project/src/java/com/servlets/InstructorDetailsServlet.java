
package com.servlets;

import com.beans.InstructorBean;
import com.beans.UserBean;
import com.connection.InstructorDetailsDB;
import com.connection.UserDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raj
 */
 @WebServlet("/InstructorDetailsServlet")
public class InstructorDetailsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String check = request.getParameter("check");
         String marks = request.getParameter("marks");
          if("EDITINST".equals(check)){
              List<InstructorBean> insBean = UserDB.getInstructorUser();
              request.setAttribute("loadInstructor", insBean);
              RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/editInstructor.jsp");
                if(dispatcher != null){
                    dispatcher.forward(request, response);
                }
        }
           else if ("ENTER MARKS".equals(marks))
        {
            try 
            {
                InstructorBean instBean = new InstructorBean();
                UserBean user = new UserBean();
                
                instBean.setInstructorID(request.getParameter("instructorID"));
                List<InstructorBean> instructorBeanSubjects = InstructorDetailsDB.getInstructorSubjects(user,instBean);

                request.setAttribute("instructorSubjects", instructorBeanSubjects);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/instructor/enterMarks.jsp");
                if (dispatcher != null)
                {
                    dispatcher.forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(InstructorDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
               
        }
          else if ("EDITINSTRUCTOR".equals(check))
        {
            try {
                InstructorBean instBean = new InstructorBean();
                UserBean user = new UserBean();
                instBean.setInstructorContact(request.getParameter("contactNumber"));
                instBean.setInstructorEmail(request.getParameter("emailID"));
                instBean.setInstructorID(request.getParameter("instructorID"));
                InstructorDetailsDB.updateInstructorDetails(instBean);
                List<InstructorBean> instructorBean = InstructorDetailsDB.getInstructorDetails(user,instBean);
                List<InstructorBean> instructorBeanDept = InstructorDetailsDB.getInstructorDepartment(user,instBean);
                List<InstructorBean> instructorBeanSubjects = InstructorDetailsDB.getInstructorSubjects(user,instBean);

                request.setAttribute("instructors", instructorBean);
                request.setAttribute("instructorDept", instructorBeanDept);
                request.setAttribute("instructorSubjects", instructorBeanSubjects);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/instructor/instructorHome.jsp");
                if (dispatcher != null)
                {
                    dispatcher.forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(InstructorDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
               
        }
          
         
          
          else if("SEARCHMARKS".equals(check)){
            try {
                InstructorBean insBean = new InstructorBean();
               UserBean user = new UserBean();
                insBean.setInstructorID(request.getParameter("instructorID"));
                insBean.setInstructorSubjectCode(request.getParameter("subjectCode"));
                 List<InstructorBean> list = InstructorDetailsDB.getStudentMarks(insBean);
                 request.setAttribute("marks", list);
                  List<InstructorBean> instructorBeanSubjects = InstructorDetailsDB.getInstructorSubjects(user,insBean);
                  request.setAttribute("instructorSubjects", instructorBeanSubjects);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/instructor/enterMarks.jsp");
                  if(dispatcher != null){
                      dispatcher.forward(request, response);
                  }
            } catch (SQLException ex) {
                Logger.getLogger(InstructorDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           else if("UPDATEMARKS".equals(check)){
            try {
                InstructorBean insBean = new InstructorBean();
                 UserBean user = new UserBean();
                insBean.setInstructorID(request.getParameter("instructorID"));
               insBean.setStudentId(request.getParameter("studentId"));
               insBean.setMarks(request.getParameter("studentMarks"));
                insBean.setInstructorSubjectCode(request.getParameter("subjectcode"));
                InstructorDetailsDB.updateStudentMarks(insBean);
                 List<InstructorBean> list = InstructorDetailsDB.getStudentMarks(insBean);
                 request.setAttribute("marks", list);
                  List<InstructorBean> instructorBeanSubjects = InstructorDetailsDB.getInstructorSubjects(user,insBean);
                  request.setAttribute("instructorSubjects", instructorBeanSubjects);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/instructor/enterMarks.jsp");
                  if(dispatcher != null){
                      dispatcher.forward(request, response);
                  }
            } catch (SQLException ex) {
                Logger.getLogger(InstructorDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if("get".equals(check)){
            try {
                UserBean user = new UserBean();
                List<InstructorBean> insBean = InstructorDetailsDB.getInstructorDetails(user);
                request.setAttribute("loadInstructor", insBean);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/getInstructorDetails.jsp");
                  if(dispatcher != null){
                      dispatcher.forward(request, response);
                  }
            } catch (SQLException ex) {
                Logger.getLogger(InstructorDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          else{
         try {
             InstructorBean instBean = new InstructorBean();
             instBean.setInstructorFirstName(request.getParameter("firstName"));
             instBean.setInstructorMiddleName(request.getParameter("middleName"));
             instBean.setInstructorLastName(request.getParameter("lastName"));
             instBean.setInstructorContact(request.getParameter("contactNumber"));
             instBean.setInstructorEmail(request.getParameter("emailId"));
             instBean.setInstructorGender(request.getParameter("gender"));
             instBean.setInstructorDOB(request.getParameter("date") + "-" + request.getParameter("month") + "-" +request.getParameter("year") );
             InstructorDetailsDB.insertInstructorDetails(instBean);
             response.sendRedirect(request.getContextPath()+"/admin/insertSuccess.jsp");
         } catch (SQLException ex) {
             Logger.getLogger(InstructorDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
           
    }
    }
}
