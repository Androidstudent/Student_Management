
package com.connection;

import com.beans.StudentAddressBean;
import com.beans.StudentBean;
import com.beans.UserBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Raj
 */
public class StudentDetailsDB {
      static Connection connection = DBConnection.getConnection();
      static CallableStatement callstmt;
      static Statement statement;
    public static void insertStudentDetails(StudentBean studBean,StudentAddressBean studAddrBean) throws SQLException{
        
            String firstName = studBean.getStudentFirstName();
            String middleName = studBean.getStudentMiddleName();
            String lastName = studBean.getStudentLastName();
            String gender = studBean.getStudentGender();
            String DOB = studBean.getStudentDOB();
            String contact =studBean.getStudentContact();
            String emailId = studBean.getStudentEmail();
            String department = studBean.getDepartmentId();
            String address = studAddrBean.getAddress();
            String city = studAddrBean.getCity();
            String state = studAddrBean.getState();
            String pincode = studAddrBean.getPincode();
         
            callstmt = connection.prepareCall("{call pr_student_details(?,?,?,?,?,?,?,?,?,?,?,?)}");
            callstmt.setString(1,firstName);
            callstmt.setString(2,middleName);
            callstmt.setString(3,lastName);
            callstmt.setString(4,gender);
            callstmt.setString(5,DOB);
            callstmt.setString(6,contact);
            callstmt.setString(7,emailId);
            callstmt.setString(8,department);
            callstmt.setString(9,address);
            callstmt.setString(10,city);
            callstmt.setString(11,state);
            callstmt.setString(12,pincode);
            callstmt.execute();
            
        
    }
	
	public static List<StudentBean> getStudentDetails(UserBean user,StudentBean stBean) throws SQLException
    {
        int role = user.getRole();
         String studentDetails = "";
        if(role == 3){
        String studentID = user.getUserName();
         studentDetails = "SELECT STUDENT_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, GENDER, DATE_OF_BIRTH, CONTACT_NUMBER, EMAIL_ID " +
               " FROM STUDENT_DETAILS WHERE STUDENT_ID = '" + studentID + "'";
        }
        else{
           String studentID = stBean.getStudentID();
           System.out.println("Student id ==== " + studentID);
         studentDetails = "SELECT STUDENT_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, GENDER, DATE_OF_BIRTH, CONTACT_NUMBER, EMAIL_ID " +
               " FROM STUDENT_DETAILS WHERE STUDENT_ID = '" + studentID + "'";
        }
        statement = connection.createStatement();
        ResultSet rsStudentDetails = statement.executeQuery(studentDetails);
        if(rsStudentDetails != null)
        {
            List<StudentBean> list = new ArrayList<StudentBean>();
            while (rsStudentDetails.next())
            {
                StudentBean studentBean = new StudentBean();
                studentBean.setStudentID(rsStudentDetails.getString("STUDENT_ID"));
                studentBean.setStudentFirstName(rsStudentDetails.getString("FIRST_NAME"));
                studentBean.setStudentMiddleName(rsStudentDetails.getString("MIDDLE_NAME"));
                studentBean.setStudentLastName(rsStudentDetails.getString("LAST_NAME"));
                studentBean.setStudentGender(rsStudentDetails.getString("GENDER"));
                studentBean.setStudentDOB(rsStudentDetails.getString("DATE_OF_BIRTH"));
                studentBean.setStudentContact(rsStudentDetails.getString("CONTACT_NUMBER"));
                studentBean.setStudentEmail(rsStudentDetails.getString("EMAIL_ID"));
				list.add(studentBean);
            }
            return list;
        }
        else
        {
            user.setValid(false);
        }
        return null;
    }
	
	public static List<StudentBean> getStudentMarks(UserBean user,StudentBean studBean)
    {
        try
        {   int role = user.getRole();
            System.out.println("Role======" + role);
            String studentMarks = "";
            String studentID = "";
            if(role == 3){
            studentID = user.getUserName();
             studentMarks = "SELECT SSM.SUBJECT_CODE, SD.SUBJECT_NAME, SSM.MARKS FROM STUDENT_SUBJECT_MARKS SSM JOIN SUBJECT_DETAILS SD ON (SSM.SUBJECT_CODE = SD.SUBJECT_CODE) AND SSM.STUDENT_ID = '" + studentID + "'";
            }
            else{
             studentID = studBean.getStudentID();
             studentMarks = "SELECT SSM.SUBJECT_CODE, SD.SUBJECT_NAME, SSM.MARKS FROM STUDENT_SUBJECT_MARKS SSM JOIN SUBJECT_DETAILS SD ON (SSM.SUBJECT_CODE = SD.SUBJECT_CODE) AND SSM.STUDENT_ID = '" + studentID + "'";
              
            }
            statement = connection.createStatement();
            ResultSet rsStudentMarks = statement.executeQuery(studentMarks);
            if(rsStudentMarks != null)
            {
                List<StudentBean> list = new ArrayList<StudentBean>();
                while (rsStudentMarks.next())
                {
                    StudentBean studentBean = new StudentBean();
                    studentBean.setSubjectCode(rsStudentMarks.getString(1));
                    studentBean.setSubjectName(rsStudentMarks.getString(2));
                    studentBean.setStudentMarks(rsStudentMarks.getInt(3));
                    list.add(studentBean);
                }
                return list;
            }
            else
            {
                user.setValid(false);
            }
            return null;
        }
        catch (Exception e)
        {
            System.out.println("Error Message: " + e.getMessage());
        }
        return null;
    }
    
     public static List<StudentBean> getAllStudentDetails() throws SQLException
    {
        List<StudentBean> list = null;
        String query = "select s.student_id, s.first_name,s.middle_name, s.last_name, s.gender,"
                + " s.date_of_birth, s.contact_number, s.email_id, s.department_id, a.home, a.city,"
                + " a.state, a.pincode from student_details s join student_address a on(s.student_id = a.student_id)";
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        if(rs!=null){
            list = new ArrayList<StudentBean>();
            while(rs.next()){
                StudentBean studBean = new StudentBean();
                studBean.setStudentID(rs.getString(1));
                studBean.setStudentFirstName(rs.getString(2));
                studBean.setStudentMiddleName(rs.getString(3));
                studBean.setStudentLastName(rs.getString(4));
                studBean.setStudentGender(rs.getString(5));
                studBean.setStudentDOB(rs.getDate(6).toString());
                studBean.setStudentContact(rs.getString(7));
                studBean.setStudentEmail(rs.getString(8));
                studBean.setDepartmentId(rs.getString(9));
                studBean.setStudentAddress(rs.getString(10));
                studBean.setStudentCity(rs.getString(11));
                studBean.setStudentState(rs.getString(12));
                studBean.setStudentPincode(rs.getString(13));
                list.add(studBean);
            }
        }
        return list;
        
    }
        
     public static List<StudentAddressBean> getStudentAddress(UserBean user,StudentBean bean) throws SQLException
    {
         int role = user.getRole();
         String studentAddress = "";
        if(role == 3){
        String studentID = user.getUserName();
         studentAddress = "SELECT HOME, CITY, STATE, PINCODE" +
               " FROM STUDENT_ADDRESS WHERE STUDENT_ID = '" + studentID + "'";
        }
        else{
             String studentID = bean.getStudentID();
         studentAddress = "SELECT HOME, CITY, STATE, PINCODE" +
               " FROM STUDENT_ADDRESS WHERE STUDENT_ID = '" + studentID + "'";
        }
        statement = connection.createStatement();
        ResultSet rsStudentAddress = statement.executeQuery(studentAddress);
        if(rsStudentAddress != null)
        {
            List<StudentAddressBean> list = new ArrayList<StudentAddressBean>();
            while (rsStudentAddress.next())
            {
                StudentAddressBean studentAddressBean = new StudentAddressBean();
                studentAddressBean.setAddress(rsStudentAddress.getString("HOME"));
                studentAddressBean.setCity(rsStudentAddress.getString("CITY"));
                studentAddressBean.setState(rsStudentAddress.getString("STATE"));
                studentAddressBean.setPincode(rsStudentAddress.getString("PINCODE"));
                list.add(studentAddressBean);
            }
            return list;
        }
        else
        {
            user.setValid(false);
        }
        return null;
    }
     public static void updateStudent(StudentBean studBean, StudentAddressBean studAddrBean){
        try {
            
            String studentId = studBean.getStudentID();
            String firstName = studBean.getStudentFirstName();
            String middleName = studBean.getStudentMiddleName();
            String lastName = studBean.getStudentLastName();
            String contact =studBean.getStudentContact();
            String emailId = studBean.getStudentEmail();
            String address = studAddrBean.getAddress();
            String city = studAddrBean.getCity();
            String state = studAddrBean.getState();
            String pincode = studAddrBean.getPincode();
           
            String query1 = "update student_details set first_name = '" + firstName + "',"
                    + " middle_name = '" + middleName + "', last_name = '" + lastName + "',"
                    + " contact_number = '" + contact + "', email_id = '" + emailId + "'"
                    + " where student_id = '" + studentId + "'";
           
            String query2 = "update student_address set home = '"+address+"', city = '"+city+"', state = '"+state+"', pincode = '"+pincode+"' where student_id = '"+studentId+"'";
            
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query1);
           ResultSet rs2 = statement.executeQuery(query2);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDetailsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
            
     }
     
      public static void updateStudentByStudent(StudentBean studBean, StudentAddressBean studAddrBean){
        try {
            
            String studentId = studBean.getStudentID();
            String contact =studBean.getStudentContact();
            String emailId = studBean.getStudentEmail();
            String address = studAddrBean.getAddress();
            String city = studAddrBean.getCity();
            String state = studAddrBean.getState();
            String pincode = studAddrBean.getPincode();
           
            String  query1 = "update student_details set contact_number = '" + contact + "', email_id = '" + emailId + "'"
                    + " where student_id = '" + studentId + "'";
           
            String query2 = "update student_address set home = '"+address+"', city = '"+city+"', state = '"+state+"', pincode = '"+pincode+"' where student_id = '"+studentId+"'";
            System.out.println("Query1 = " + query1);
             System.out.println("Query2 = " + query2);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query1);
           ResultSet rs2 = statement.executeQuery(query2);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDetailsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
            
     }
     
    public static void displayStudentDetails(ResultSet rs)
    {
        try
        {
            /*System.out.println("Student ID: " + studentBean.getStudentID());
            System.out.println("First Name: " + studentBean.getStudentFirstName());
            System.out.println("Middle Name: " + studentBean.getStudentMiddleName());
            System.out.println("Last Name: " + studentBean.getStudentLastName());
            System.out.println("Gender: " + studentBean.getStudentGender());
            System.out.println("DOB : " + studentBean.getStudentDOB());
            System.out.println("Contact Number : " + studentBean.getStudentContact());
            System.out.println("Email ID : " + studentBean.getStudentEmail());*/
        }
        catch(Exception e)
        {
            System.out.println("Error Message" + e);
        }
    }
}
