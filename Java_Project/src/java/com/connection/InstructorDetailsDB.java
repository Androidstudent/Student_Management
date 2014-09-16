
package com.connection;

import com.beans.InstructorBean;
import com.beans.UserBean;
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
public class InstructorDetailsDB {
 
     static Connection connection = DBConnection.getConnection();
      static CallableStatement callstmt;
      static Statement statement;
    public static void insertInstructorDetails( InstructorBean instBean) throws SQLException{
        
            String firstName = instBean.getInstructorFirstName();
            String middleName = instBean.getInstructorMiddleName();
            String lastName = instBean.getInstructorLastName();
            String contact =instBean.getInstructorContact();
            String emailId = instBean.getInstructorEmail();
            String gender = instBean.getInstructorGender();
            String DOB = instBean.getInstructorDOB();
            
                    
            callstmt = connection.prepareCall("{call pr_instructor_details(?,?,?,?,?,?,?)}");
            callstmt.setString(1,firstName);
            callstmt.setString(2,middleName);
            callstmt.setString(3,lastName);
            callstmt.setString(4,contact);
            callstmt.setString(5,emailId);
            callstmt.setString(6,gender);
            callstmt.setString(7,DOB);
            
            callstmt.execute();
            
        
    }
     public static List<InstructorBean> getInstructorDetails(UserBean user) throws SQLException
    {
            int role = user.getRole();
            
            String instructorDetails = "";
            String instructorID = "";
            if(role == 2){
            instructorID = user.getUserName();
          
             instructorDetails = "SELECT INSTRUCTOR_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, CONTACT_NUMBER, EMAIL_ID, GENDER, DATE_OF_BIRTH " +
                   " FROM INSTRUCTOR_DETAILS WHERE INSTRUCTOR_ID = '" + instructorID + "'";
            }
            else{
                instructorDetails = "SELECT INSTRUCTOR_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, CONTACT_NUMBER, EMAIL_ID, GENDER, DATE_OF_BIRTH " +
                   " FROM INSTRUCTOR_DETAILS";
            }
            
            statement = connection.createStatement();
            ResultSet rsInstructorDetails = statement.executeQuery(instructorDetails);
            if(rsInstructorDetails != null)
            {
                List<InstructorBean> list = new ArrayList<InstructorBean>();
                while (rsInstructorDetails.next())
                {
                    InstructorBean instructorBean = new InstructorBean();
                    instructorBean.setInstructorID(rsInstructorDetails.getString("INSTRUCTOR_ID"));
                    instructorBean.setInstructorFirstName(rsInstructorDetails.getString("FIRST_NAME"));
                    instructorBean.setInstructorMiddleName(rsInstructorDetails.getString("MIDDLE_NAME"));
                    instructorBean.setInstructorLastName(rsInstructorDetails.getString("LAST_NAME"));
                    instructorBean.setInstructorGender(rsInstructorDetails.getString("GENDER"));
                    instructorBean.setInstructorDOB(rsInstructorDetails.getString("DATE_OF_BIRTH"));
                    instructorBean.setInstructorContact(rsInstructorDetails.getString("CONTACT_NUMBER"));
                    instructorBean.setInstructorEmail(rsInstructorDetails.getString("EMAIL_ID"));
                    list.add(instructorBean);
                }
                return list;
            }
            else
            {
                user.setValid(false);
            }
            
        
        return null;
    }
     public static List<InstructorBean> getInstructorDetails(UserBean user,InstructorBean insBean) throws SQLException
    {       int role = user.getRole();
            String instructorDetails = "";
            String instructorID = "";
            if(role == 2){
            instructorID = user.getUserName();
             instructorDetails = "SELECT INSTRUCTOR_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, CONTACT_NUMBER, EMAIL_ID, GENDER, DATE_OF_BIRTH " +
                   " FROM INSTRUCTOR_DETAILS WHERE INSTRUCTOR_ID = '" + instructorID + "'";
            }
            else{
                instructorID = insBean.getInstructorID();
                instructorDetails = "SELECT INSTRUCTOR_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, CONTACT_NUMBER, EMAIL_ID, GENDER, DATE_OF_BIRTH " +
                   " FROM INSTRUCTOR_DETAILS WHERE INSTRUCTOR_ID = '" + instructorID + "'";
            }
            statement = connection.createStatement();
            ResultSet rsInstructorDetails = statement.executeQuery(instructorDetails);
            if(rsInstructorDetails != null)
            {
                List<InstructorBean> list = new ArrayList<InstructorBean>();
                while (rsInstructorDetails.next())
                {
                    InstructorBean instructorBean = new InstructorBean();
                    instructorBean.setInstructorID(rsInstructorDetails.getString("INSTRUCTOR_ID"));
                    instructorBean.setInstructorFirstName(rsInstructorDetails.getString("FIRST_NAME"));
                    instructorBean.setInstructorMiddleName(rsInstructorDetails.getString("MIDDLE_NAME"));
                    instructorBean.setInstructorLastName(rsInstructorDetails.getString("LAST_NAME"));
                    instructorBean.setInstructorGender(rsInstructorDetails.getString("GENDER"));
                    instructorBean.setInstructorDOB(rsInstructorDetails.getString("DATE_OF_BIRTH"));
                    instructorBean.setInstructorContact(rsInstructorDetails.getString("CONTACT_NUMBER"));
                    instructorBean.setInstructorEmail(rsInstructorDetails.getString("EMAIL_ID"));
                    list.add(instructorBean);
                }
                return list;
            }
            else
            {
                user.setValid(false);
            }
        return null;
    }
   
    public static List<InstructorBean> getInstructorDepartment(UserBean user, InstructorBean insBean) throws SQLException
    {  
        int role = user.getRole();
            String instructorDept = "";
            String instructorID = "";
            if(role == 2){
         instructorID = user.getUserName();
         instructorDept = "SELECT DEPARTMENT.DEPARTMENT_CODE, DEPARTMENT.DEPARTMENT_NAME FROM DEPARTMENT JOIN INSTRUCTOR_DETAILS " +
            "ON (DEPARTMENT.DEPARTMENT_ID = INSTRUCTOR_DETAILS.DEPARTMENT_ID) " +
            "AND INSTRUCTOR_DETAILS.INSTRUCTOR_ID = '" + instructorID + "'";
            }
            else{
             instructorID = insBean.getInstructorID();
                instructorDept = "SELECT DEPARTMENT.DEPARTMENT_CODE, DEPARTMENT.DEPARTMENT_NAME FROM DEPARTMENT JOIN INSTRUCTOR_DETAILS " +
            "ON (DEPARTMENT.DEPARTMENT_ID = INSTRUCTOR_DETAILS.DEPARTMENT_ID) " +
            "AND INSTRUCTOR_DETAILS.INSTRUCTOR_ID = '" + instructorID + "'";
            }
        statement = connection.createStatement();
        ResultSet rsInstructorDepartment = statement.executeQuery(instructorDept);
        if(rsInstructorDepartment != null)
        {
            List<InstructorBean> list = new ArrayList<InstructorBean>();
            while (rsInstructorDepartment.next())
            {
                InstructorBean instructorBean = new InstructorBean();
                instructorBean.setDepartmentCode(rsInstructorDepartment.getString(1));
                instructorBean.setDepartmentName(rsInstructorDepartment.getString(2));
                list.add(instructorBean);
            }
            return list;
        }
        else
        {
            user.setValid(false);
        }
        return null;
    }
   
    public static List<InstructorBean> getInstructorSubjects(UserBean user,InstructorBean insBean) throws SQLException
    {  
        int role = user.getRole();
            String instructorSubjects = "";
            String instructorID = "";
            if(role == 2){
           instructorID = user.getUserName();
           instructorSubjects = "SELECT SUBJECT_DETAILS.SUBJECT_NAME,SUBJECT_DETAILS.SUBJECT_CODE,SUBJECT_DETAILS.INSTRUCTOR_ID FROM SUBJECT_DETAILS JOIN INSTRUCTOR_DETAILS " +
            "ON (SUBJECT_DETAILS.INSTRUCTOR_ID = INSTRUCTOR_DETAILS.INSTRUCTOR_ID) " +
            "AND INSTRUCTOR_DETAILS.INSTRUCTOR_ID = '" + instructorID + "'";
            }
            else{
               instructorID = insBean.getInstructorID();
                instructorSubjects = "SELECT SUBJECT_DETAILS.SUBJECT_NAME,SUBJECT_DETAILS.SUBJECT_CODE,SUBJECT_DETAILS.INSTRUCTOR_ID FROM SUBJECT_DETAILS JOIN INSTRUCTOR_DETAILS " +
            "ON (SUBJECT_DETAILS.INSTRUCTOR_ID = INSTRUCTOR_DETAILS.INSTRUCTOR_ID) " +
            "AND INSTRUCTOR_DETAILS.INSTRUCTOR_ID = '" + instructorID + "'";
            }
        statement = connection.createStatement();
        ResultSet rsInstructorSubjects = statement.executeQuery(instructorSubjects);
        if(rsInstructorSubjects != null)
        {
            List<InstructorBean> list = new ArrayList<InstructorBean>();
            while (rsInstructorSubjects.next())
            {
                InstructorBean instructorBean = new InstructorBean();
                instructorBean.setSubjectName(rsInstructorSubjects.getString(1));
                instructorBean.setInstructorSubjectCode(rsInstructorSubjects.getString(2));
                instructorBean.setInstructorID(rsInstructorSubjects.getString(3));
                list.add(instructorBean);
            }
            return list;
        }
        else
        {
            user.setValid(false);
        }
        return null;
    }
    public static void updateInstructorDetails(InstructorBean instBean)
    {
        try
        {
            String contact = instBean.getInstructorContact();
            String emailId = instBean.getInstructorEmail();
            String instructorID = instBean.getInstructorID();
            String updateInstructorDetail = "UPDATE INSTRUCTOR_DETAILS SET CONTACT_NUMBER = '" + contact +
                    "', EMAIL_ID = '" + emailId + "' WHERE INSTRUCTOR_ID = '" + instructorID + "'";
           
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(updateInstructorDetail);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(InstructorDetailsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
     public static List<InstructorBean> getStudentMarks(InstructorBean insBean) throws SQLException
    {  
        String instructorID = insBean.getInstructorID();
        String subjectCode = insBean.getInstructorSubjectCode();    
              
                String query = "SELECT SSM.STUDENT_ID, STUD.FIRST_NAME||' '||STUD.MIDDLE_NAME||' '||STUD.LAST_NAME, SSM.MARKS, SSM.SUBJECT_CODE,SD.INSTRUCTOR_ID FROM SUBJECT_DETAILS SD "+
                                "JOIN STUDENT_SUBJECT_MARKS SSM ON (SD.SUBJECT_CODE = SSM.SUBJECT_CODE) "+
                                 "JOIN STUDENT_DETAILS STUD ON (SSM.STUDENT_ID = STUD.STUDENT_ID) "+
                                  "WHERE SD.INSTRUCTOR_ID = '"+instructorID+"' and SSM.SUBJECT_CODE = '"+subjectCode+"'";
           
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        if(rs != null)
        {
            List<InstructorBean> list = new ArrayList<InstructorBean>();
            while (rs.next())
            {
                InstructorBean instructorBean = new InstructorBean();
                instructorBean.setStudentId(rs.getString(1));
                instructorBean.setStudentFullName(rs.getString(2));
                instructorBean.setMarks(rs.getString(3));
                instructorBean.setInstructorSubjectCode(rs.getString(4));
                instructorBean.setInstructorID(rs.getString(5));
                list.add(instructorBean);
            }
            return list;
        }
        
        return null;
    }
    public static void updateStudentMarks(InstructorBean insBean){
        try {
            String studentId = insBean.getStudentId();
            String subjectCode = insBean.getInstructorSubjectCode();
            String marks = insBean.getMarks();
            String query = "update student_subject_marks set marks = '"+marks+"' where student_id = '"+studentId+"' and subject_code = '"+subjectCode+"'";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(InstructorDetailsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
