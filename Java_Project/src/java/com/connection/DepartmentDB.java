/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connection;

import com.beans.DepartmentBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raj
 */
public class DepartmentDB {
     static Connection connection = DBConnection.getConnection();
      static CallableStatement callstmt;
      static Statement stmt;
    public static void insertDepartmentDetails( DepartmentBean depBean) throws SQLException{
        String departmentCode = depBean.getDepartmentCode();
        String departmentName = depBean.getDepartmentName();
        callstmt = connection.prepareCall("{call pr_department(?,?)}");
        callstmt.setString(1, departmentCode);
        callstmt.setString(2, departmentName);
        callstmt.execute();
    }
    public static List getDepartmentCode(){
        List<DepartmentBean> list =null;
        try {
            
            String query = "select department_code from department";
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs!=null){
                list = new ArrayList<DepartmentBean>();
                while(rs.next()){
                 DepartmentBean depBean = new DepartmentBean();
                 depBean.setDepartmentCode(rs.getString(1));
                 list.add(depBean);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
     public static List getOneDepartmentDetails(DepartmentBean bean){
        List<DepartmentBean> dept =null;
        try {
            String departmentCode = bean.getDepartmentCode();
            String query = "select department_code,department_name,department_id from department where department_code = '" + departmentCode +"'";
            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs!=null){
                dept = new ArrayList<DepartmentBean> ();
                while(rs.next()){
                 DepartmentBean depBean = new DepartmentBean();
                 depBean.setDepartmentCode(rs.getString(1));
                 depBean.setDepartmentName(rs.getString(2));
                 depBean.setDepartmentId(rs.getString(3));
                 dept.add(depBean);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dept;
    }
    public static void updateDepartment(DepartmentBean depBean){
        try {
            String deptCode = depBean.getDepartmentCode();
            String deptName = depBean.getDepartmentName();
            String deptId = depBean.getDepartmentId();
            String query = "update department set department_code = '" + deptCode + "', "
                    + "department_name = '" + deptName + "' where department_id = '" + deptId + "'";
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
    
     public static void deleteDepartment(DepartmentBean depBean){
        try {
            String deptId = depBean.getDepartmentId();
            String query = "delete from department where department_id = '" + deptId + "'";
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
}
