/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.beans.DepartmentBean;
import com.connection.DepartmentDB;
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
@WebServlet("/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String check = request.getParameter("check");
         if("EDITDEP".equals(check)){
             List<DepartmentBean> depBean = DepartmentDB.getDepartmentCode();
             request.setAttribute("department", depBean);
              RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/editDepartment.jsp");
      if (dispatcher != null)
        { 
            dispatcher.forward(request, response);
        }
         }
         else if("SEARCH".equals(check)){
             DepartmentBean depBean = new DepartmentBean();
             depBean.setDepartmentCode(request.getParameter("departmentCode"));
             List<DepartmentBean> list = DepartmentDB.getOneDepartmentDetails(depBean);
             request.setAttribute("oneDepartment", list);
              RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/editDepartment.jsp");
      if (dispatcher != null)
        { 
            dispatcher.forward(request, response);
        }
         } 
          else if("Delete".equals(check)){
             DepartmentBean depBean = new DepartmentBean();
             
             depBean.setDepartmentId(request.getParameter("departmentId"));
             DepartmentDB.deleteDepartment(depBean);
             response.sendRedirect(request.getContextPath() + "/admin/delete.jsp");
            
         } 
          else if("Update".equals(check)){
             DepartmentBean depBean = new DepartmentBean();
             depBean.setDepartmentCode(request.getParameter("departmentCode"));
             depBean.setDepartmentName(request.getParameter("departmentName"));
             depBean.setDepartmentId(request.getParameter("departmentId"));
             DepartmentDB.updateDepartment(depBean);
             response.sendRedirect(request.getContextPath() + "/admin/insertSuccess.jsp");
            
         } 
         else{
        try {
            DepartmentBean depBean = new DepartmentBean();
            depBean.setDepartmentCode(request.getParameter("departmentCode"));
            depBean.setDepartmentName(request.getParameter("departmentName"));
            DepartmentDB.insertDepartmentDetails(depBean);
            response.sendRedirect(request.getContextPath()+"/admin/insertSuccess.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
}
