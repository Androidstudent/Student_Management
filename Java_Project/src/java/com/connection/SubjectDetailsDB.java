/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connection;


import com.beans.DepartmentBean;
import com.beans.InstructorBean;
import com.beans.SubjectDetailsBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raj
 */
public class SubjectDetailsDB {
     static Connection connection = DBConnection.getConnection();
      static Statement stmt;
      static CallableStatement callstmt;
      public static List getSubjectDetails(){
           List<SubjectDetailsBean> list = null;
        try {
            String query = "select s.subject_code,s.subject_name,s.semister,i.instructor_id,"
                    + "i.first_name,i.last_name,d.department_id,d.department_code from "
                    + "subject_details s join instructor_details i on(i.instructor_id = s.instructor_id)"
                    + " join department d on(d.department_id = s.department_id)";
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs!=null){
                list = new ArrayList<SubjectDetailsBean>();
                while(rs.next()){
                    SubjectDetailsBean subDtBean = new SubjectDetailsBean();
                    subDtBean.setSubjectCode(rs.getString(1));
                    subDtBean.setSubjectName(rs.getString(2));
                    subDtBean.setSemister(rs.getString(3));
                    subDtBean.setInstructorId(rs.getString(4));
                    subDtBean.setInstructorName(rs.getString(5));
                    subDtBean.setInstructorLastName(rs.getString(6));
                    subDtBean.setDepartmentId(rs.getString(7));
                    subDtBean.setDepartmentCode(rs.getString(8));
                   
                    list.add(subDtBean);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDetailsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
       
          
      }
      public static List getInstructor(){
       List<InstructorBean> list =null;
          try {
            
            String query = "select instructor_id,first_name,last_name from instructor_details";
              stmt = connection.createStatement();
              ResultSet rs = stmt.executeQuery(query);
           if(rs!=null){
               list = new ArrayList<InstructorBean>();
               while(rs.next()){
                   InstructorBean insBean = new InstructorBean();
                   insBean.setInstructorID(rs.getString(1));
                   insBean.setInstructorFirstName(rs.getString(2));
                   insBean.setInstructorLastName(rs.getString(3));
                   list.add(insBean);
               }
           }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDetailsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
      }
      public static List getSubjectCode(){
          List<SubjectDetailsBean> list = null;
        try {
            
            String query = "select subject_code from subject_details";
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs!=null){
                list = new ArrayList<SubjectDetailsBean>();
                while(rs.next()){
                    SubjectDetailsBean subBean = new SubjectDetailsBean();
                    subBean.setSubjectCode(rs.getString(1));
                    list.add(subBean);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDetailsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
      }
      public static List getDepartment(){
       List<DepartmentBean> list =null;
          try {
            
            String query = "select department_id,department_code,department_name from department";
              stmt = connection.createStatement();
              ResultSet rs = stmt.executeQuery(query);
           if(rs!=null){
               list = new ArrayList<DepartmentBean>();
               while(rs.next()){
                   DepartmentBean depBean = new DepartmentBean();
                   depBean.setDepartmentId(rs.getString(1));
                   depBean.setDepartmentCode(rs.getString(2));
                   depBean.setDepartmentName(rs.getString(3));
                   
                   list.add(depBean);
               }
           }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDetailsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
      }
      
      public static void insertSubjectDetails(SubjectDetailsBean subBean){
        try {
            String subjectName = subBean.getSubjectName();
            String semester = subBean.getSemister();
            String instructor = subBean.getInstructorId();
            String departmentId = subBean.getDepartmentId();
           
            callstmt = connection.prepareCall("{call pr_subject_details(?,?,?,?)}");
            callstmt.setString(1,subjectName);
            callstmt.setString(2,semester);
            callstmt.setString(3,instructor);
            callstmt.setString(4,departmentId);
            callstmt.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDetailsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      }
}
