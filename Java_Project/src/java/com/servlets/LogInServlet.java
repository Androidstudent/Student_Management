
package com.servlets;

import com.beans.InstructorBean;
import com.beans.StudentAddressBean;
import com.beans.StudentBean;
import com.beans.UserBean;
import com.connection.InstructorDetailsDB;
import com.connection.StudentDetailsDB;
import com.connection.UserDB;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String check = request.getParameter("check");
      if("S".equals(check)){
          UserBean usBean = new UserBean();
          usBean.setUserName(request.getParameter("userName"));
          usBean.setPassword(request.getParameter("password"));
          usBean.setRole(3);
          UserDB.createUser(usBean);
          response.sendRedirect(request.getContextPath() + "/admin/insertSuccess.jsp");
      }
      else if("I".equals(check)){
          UserBean usBean = new UserBean();
          usBean.setUserName(request.getParameter("userName"));
          usBean.setPassword(request.getParameter("password"));
          usBean.setRole(2);
          UserDB.createUser(usBean);
          response.sendRedirect(request.getContextPath() + "/admin/insertSuccess.jsp");
      }
       else if("A".equals(check)){
          UserBean usBean = new UserBean();
          usBean.setUserName(request.getParameter("userName"));
          usBean.setPassword(request.getParameter("password"));
          usBean.setRole(1);
          UserDB.createUser(usBean);
          response.sendRedirect(request.getContextPath() + "/admin/insertSuccess.jsp");
      }
       else if("SU1".equals(check)){
           List<StudentBean> list = UserDB.getStudentUser();
           request.setAttribute("userStudent", list);
           RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/addStudentUser.jsp");
           if(dispatcher != null){
               dispatcher.forward(request, response);
           }
       }
       else if("IN1".equals(check)){
           List<InstructorBean> list = UserDB.getInstructorUser();
           request.setAttribute("userInstructor", list);
           RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/addInstructorUser.jsp");
           if(dispatcher != null){
               dispatcher.forward(request, response);
           }
       }
       else if("AD1".equals(check)){
           response.sendRedirect(request.getContextPath() + "/admin/addAdminUser.jsp");
       }
      else{
        try
        {
            UserBean user = new UserBean();
            user.setUserName(request.getParameter("userName"));
            user.setPassword(request.getParameter("password"));
            user = UserDB.check(user);
            if(user.isValid())
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentuser", user);
                int role = user.getRole();
                if(role == 1)
                {
                    response.sendRedirect(request.getContextPath() + "/admin/adminHome.jsp");
                }
                else if(role == 2)
                {
                   List<InstructorBean> instructorBean = InstructorDetailsDB.getInstructorDetails(user,null);
                    List<InstructorBean> instructorBeanDept = InstructorDetailsDB.getInstructorDepartment(user,null);
                    List<InstructorBean> instructorBeanSubjects = InstructorDetailsDB.getInstructorSubjects(user,null);
                    request.setAttribute("instructors", instructorBean);
                    request.setAttribute("instructorDept", instructorBeanDept);
                    request.setAttribute("instructorSubjects", instructorBeanSubjects);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/instructor/instructorHome.jsp");
                    if (dispatcher != null)
                    { 
                        dispatcher.forward(request, response);
                    }
                }
                else
                {
                    StudentBean bean = new StudentBean();
                    List<StudentBean> studentBean = StudentDetailsDB.getStudentDetails(user,bean);
                    List<StudentBean> marksBean = StudentDetailsDB.getStudentMarks(user,null);
                    List<StudentAddressBean> addressBean = StudentDetailsDB.getStudentAddress(user,bean);
                    request.setAttribute("students", studentBean);
                    request.setAttribute("marks", marksBean);
                     request.setAttribute("address", addressBean);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/student/studentHome.jsp");  
                    if (dispatcher != null)
                    {  
                        dispatcher.forward(request, response);
                    }
                }
            }
            else
            {
                System.out.println("sorry not inserted");
                response.sendRedirect(request.getContextPath() + "/invalid.jsp");
            }
        }
        catch (Exception e)      
        {
            System.out.println(e); 
        }

    }

    }
}
