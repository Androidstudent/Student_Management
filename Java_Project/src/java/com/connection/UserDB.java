
package com.connection;

import com.beans.InstructorBean;
import com.beans.StudentBean;
import com.beans.UserBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDB {
    static Connection con = DBConnection.getConnection();
    static Statement stmt;
    static CallableStatement callstmt;
    
    public static UserBean check(UserBean user) throws SQLException{
        String userName = user.getUserName();
        String password = user.getPassword();
        int role;
        String query = "select role from user_table where user_name = '" + userName + "' and password = '" + password + "'";
       
       stmt = con.createStatement();
       ResultSet rs = stmt.executeQuery(query);
       if(rs != null){
           while(rs.next()){
               role = rs.getInt("role");
               user.setRole(role);
               user.setValid(true);
           }
       }
       else{
           user.setValid(false);
       }
       return user; 
    }
    public static void createUser(UserBean user){
        try {
            String userName = user.getUserName();
            String password = user.getPassword();
            int role = user.getRole();
            callstmt = con.prepareCall("{call pr_user(?,?,?)}");
            callstmt.setString(1, userName);
            callstmt.setString(2, password);
            callstmt.setInt(3, role);
            callstmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static List getStudentUser(){
        List<StudentBean> list = null;
        try {
            String query = "select student_id from student_details";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs!=null){
                list = new ArrayList<StudentBean>();
                while(rs.next()){
                  StudentBean studBean = new StudentBean();
                  studBean.setStudentID(rs.getString(1));
                  list.add(studBean);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public static List getInstructorUser(){
        List<InstructorBean> list = null;
        try {
            String query = "select instructor_id from instructor_details";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs!=null){
                list = new ArrayList<InstructorBean>();
                while(rs.next()){
                  InstructorBean inBean = new InstructorBean();
                  inBean.setInstructorID(rs.getString(1));
                  list.add(inBean);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
