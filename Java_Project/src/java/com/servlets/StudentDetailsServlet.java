/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;


import com.beans.StudentAddressBean;
import com.beans.StudentBean;
import com.beans.UserBean;
import com.connection.StudentDetailsDB;
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
@WebServlet("/StudentDetailsServlet")
public class StudentDetailsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check = request.getParameter("check");
        if("3".equals(check)){
            try {
                List<StudentBean> studBean = StudentDetailsDB.getAllStudentDetails();
                request.setAttribute("studentDetails", studBean);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/studentDetails.jsp");
                if(dispatcher != null){
                    dispatcher.forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if("EDITSTUD".equals(check)){
              List<StudentBean> studBean = UserDB.getStudentUser();
              request.setAttribute("loadStudent", studBean);
              RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/editStudent.jsp");
                if(dispatcher != null){
                    dispatcher.forward(request, response);
                }
        }
        
         else if("SEARCH".equals(check)){
            try {
                UserBean user = new UserBean();
                StudentBean bean = new StudentBean();
               
                bean.setStudentID(request.getParameter("studentId"));
                List<StudentBean> studentBean = StudentDetailsDB.getStudentDetails(user, bean);
                  List<StudentAddressBean> addressBean = StudentDetailsDB.getStudentAddress(user,bean);
                    request.setAttribute("students", studentBean);
                    request.setAttribute("address", addressBean);
                 RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/editStudent.jsp");
         if (dispatcher != null)
           { 
               dispatcher.forward(request, response);
           }} catch (SQLException ex) {
                Logger.getLogger(StudentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         else if("Update".equals(check)){
            
                StudentBean studBean = new StudentBean();
               StudentAddressBean studAddrBean = new StudentAddressBean();
               studBean.setStudentID(request.getParameter("studentId").trim());
               studBean.setStudentFirstName(request.getParameter("firstName"));
               studBean.setStudentMiddleName(request.getParameter("middleName"));
               studBean.setStudentLastName(request.getParameter("lastName"));
               studBean.setStudentGender(request.getParameter("gender"));
               studBean.setStudentDOB(request.getParameter("DOB"));
               studBean.setStudentContact(request.getParameter("contactNumber"));
               studBean.setStudentEmail(request.getParameter("emailID"));
              
               studAddrBean.setAddress(request.getParameter("address"));
               studAddrBean.setCity(request.getParameter("city"));
               studAddrBean.setState(request.getParameter("state"));
               studAddrBean.setPincode(request.getParameter("pincode"));
               StudentDetailsDB.updateStudent(studBean, studAddrBean);
               response.sendRedirect(request.getContextPath()+"/admin/insertSuccess.jsp");
            
         }
         
          else if("studUpdate".equals(check)){
            try {                     
                StudentBean studBean = new StudentBean();
               StudentAddressBean studAddrBean = new StudentAddressBean();
                UserBean user = new UserBean();

               studBean.setStudentID(request.getParameter("studentId"));
               System.out.println(request.getParameter("studentId"));
               studBean.setStudentContact(request.getParameter("contactNumber"));
               studBean.setStudentEmail(request.getParameter("emailID"));
              
               studAddrBean.setAddress(request.getParameter("address"));
               studAddrBean.setCity(request.getParameter("city"));
               studAddrBean.setState(request.getParameter("state"));
               studAddrBean.setPincode(request.getParameter("pincode"));
               StudentDetailsDB.updateStudentByStudent(studBean, studAddrBean);
                   List<StudentBean> studentBean = StudentDetailsDB.getStudentDetails(user,studBean);
                    List<StudentBean> marksBean = StudentDetailsDB.getStudentMarks(user,studBean);
                    List<StudentAddressBean> addressBean = StudentDetailsDB.getStudentAddress(user,studBean);
                    request.setAttribute("students", studentBean);
                    request.setAttribute("marks", marksBean);
                     request.setAttribute("address", addressBean);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/student/studentHome.jsp");  
                    if (dispatcher != null)
                    {  
                        dispatcher.forward(request, response);
                    }
            
            } catch (SQLException ex) {
                Logger.getLogger(StudentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
         }
         
        else{
             
        try {
            StudentBean studBean = new StudentBean();
            StudentAddressBean studAddrBean = new StudentAddressBean();
            studBean.setStudentFirstName(request.getParameter("firstName"));
            studBean.setStudentMiddleName(request.getParameter("middleName"));
            studBean.setStudentLastName(request.getParameter("lastName"));
            studBean.setStudentGender(request.getParameter("gender"));
            studBean.setStudentDOB(request.getParameter("date") + "-" + request.getParameter("month") + "-" +request.getParameter("year") );
            studBean.setStudentContact(request.getParameter("contactNumber"));
            studBean.setStudentEmail(request.getParameter("emailId"));
            studBean.setDepartmentId(request.getParameter("department"));
            studAddrBean.setAddress(request.getParameter("address"));
            studAddrBean.setCity(request.getParameter("city"));
            studAddrBean.setState(request.getParameter("state"));
            studAddrBean.setPincode(request.getParameter("pincode"));
            StudentDetailsDB.insertStudentDetails(studBean, studAddrBean);
            response.sendRedirect(request.getContextPath()+"/admin/insertSuccess.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
}
