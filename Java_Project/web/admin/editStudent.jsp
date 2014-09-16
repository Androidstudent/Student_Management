<%-- 
    Document   : editStudent
    Created on : Aug 13, 2014, 11:59:09 PM
    Author     : Raj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/style.css"/>
        <style>
            .border,.rain{
                height: 200px;
                width: 430px
            }
            .subForm{
                height: 100px;
            }
            form{
                height:  48%;
            }
        </style>
    </head>
    <body>
         <div id="header">
            <img src="${pageContext.request.contextPath}/Style/banner.jpg" width="880px" height="150px">
        </div>

        <div id="menu">
            <ul id="menu">

               <li><a href="<%=request.getContextPath()%>/admin/redirectInstructor.jsp">Instructor</a> </li>  
                <li><a href="<%=request.getContextPath()%>/admin/redirectStudent.jsp">Student</a> </li>  
                <li> <a href="<%=request.getContextPath()%>/admin/redirectCourse.jsp"> Course </a>  </li> 
                <li> <a href="<%=request.getContextPath()%>/admin/redirectDepartment.jsp"> Department </a> </li>
                <li> <a href="<%=request.getContextPath()%>/admin/redirectUser.jsp"> User </a> </li>
                <li> <a href="<%=request.getContextPath()%>/index.jsp"> Log Out</a> </li>

            </ul> 
            <h1>Edit Student</h1>
        </div>     

        <div id="content">
            <div class="rain">
                <div class="border start">

        <form name="edit" class="subForm" action="<%=request.getContextPath()%>/StudentDetailsServlet" method="post">
            Choose Student Id: 
            <select name="studentId">
                <c:forEach var="student" items="${loadStudent}">
                <option value="<c:out value='${student.studentID}'/>"><c:out value="${student.studentID}"/></option>
                </c:forEach>
            </select>
            <input type="hidden" name="check" value="SEARCH"/>
            <input type="submit" value="search"/>
        </form>
        <form name="editStudent" action="<%=request.getContextPath()%>/StudentDetailsServlet" method="post">
              <table border="1" >    
                <c:forEach var="student" items="${students}">
                    <tr>
                        <h4>Personal Information</h4>
                    </tr>
                     <tr>
                        <td>Student ID:</td>
                        <td><select name="studentId">
                                <option value="<c:out value='${student.studentID}'/> "><c:out value="${student.studentID}"/> </option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Student First Name</td>
                        <td><input type="text" name="firstName" id="contact" required="" value="<c:out value='${student.studentFirstName}'/>"/></td>
                    </tr>
                    <tr>
                        <td>Student Middle Name</td>
                        <td><input type="text" name="middleName" id="contact" required="" value="<c:out value='${student.studentMiddleName}'/>"</td>
                    </tr>
                    <tr>
                        <td>Student Last Name</td>
                        <td><input type="text" name="lastName" id="contact" required="" value="<c:out value='${student.studentLastName}'/>"/></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td><input type="text" name="gender" id="contact"  value="<c:out value='${student.studentGender}'/>"/></td>
                    </tr>
                    <tr>
                        <td>Date of Birth</td>
                        <td><input type="text" name="DOB" id="contact" value="<c:out value='${student.studentDOB}'/>"/></td>
                    </tr>
                    <tr>
                        <td>Contact Number</td>
                        <td><input type="text" name="contactNumber" required="" id="contact" value="<c:out value='${student.studentContact}'/>"/></td>
                    </tr>
                    <tr>
                        <td>Email ID</td>
                        <td><input type="email" name="emailID" id="email" required="" value="<c:out value="${student.studentEmail}"/>"/></td>
                    </tr>
                </c:forEach>
                <c:forEach var="location" items="${address}">
                    <tr>
                        <td>Address</td>
                        <td><input type="text" name="address" id="address"  value="<c:out value='${location.address}'/>"/></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td><input type="text" name="city" id="contact" value="<c:out value='${location.city}'/>"/></td>
                    </tr>
                    <tr>
                        <td>State</td>
                        <td><input type="text" name="state" id="contact" value="<c:out value='${location.state}'/>"/></td>
                    </tr>
                    <tr>
                        <td>Pincode</td>
                        <td><input type="text" name="pincode" id="contact" value="<c:out value='${location.pincode}'/>"/></td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit"  name="check" value="Update"/>
            <%--  <input type="submit" name="check" value="Delete">--%>
      
        </form>
               </div>
            </div>
        </div>
        <div id="footer">
            <p style="text-align: center">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>
        </div>
    </body>
</html>
