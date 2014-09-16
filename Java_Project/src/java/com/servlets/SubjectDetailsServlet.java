
package com.servlets;

import com.beans.DepartmentBean;
import com.beans.InstructorBean;
import com.beans.SubjectDetailsBean;
import com.connection.SubjectDetailsDB;
import java.io.IOException;
import java.util.AbstractList;
import java.util.List;
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
@WebServlet("/SubjectDetailsServlet")
public class SubjectDetailsServlet extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String check = request.getParameter("check");
         
         if("1".equals(check)){
        List<SubjectDetailsBean> subDtBean = SubjectDetailsDB.getSubjectDetails();
         request.setAttribute("subject", subDtBean);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/subjectDetails.jsp");
      if (dispatcher != null)
        { 
            dispatcher.forward(request, response);
        }
         }
         else if("2".equals(check)){
     
      List<DepartmentBean> depBean = SubjectDetailsDB.getDepartment();
      request.setAttribute("department", depBean);
       List<InstructorBean> insBean = SubjectDetailsDB.getInstructor();
      request.setAttribute("instructor", insBean);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/addSubjectDetails.jsp");
      if (dispatcher != null)
        { 
            dispatcher.forward(request, response);
        }
         }
         else if("EDITSUBJ".equals(check)){
              List<SubjectDetailsBean> subBean =SubjectDetailsDB.getSubjectCode();
              request.setAttribute("loadSubject", subBean);
              RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/editSubject.jsp");
                if(dispatcher != null){
                    dispatcher.forward(request, response);
                }
        }
     }
}

