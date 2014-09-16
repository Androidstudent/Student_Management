<%-- 
    Document   : studentHome
    Created on : 12 Aug, 2014, 1:19:09 AM
    Author     : Hardkiller
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instructor Profile Page</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/style.css"/>
        <style>
            .border, .rain {
    height: 545px;
    width: 480px;
}               form{height: 66%;}
                        #editInst{
                            height: 100px;
                            width: 480px;
                        }
                        .subForm{
                            height: 160px;
                            width: 480px;
                        }
        </style>
    </head>
    <body>
        <div id="header">
            <img src="${pageContext.request.contextPath}/Style/banner.jpg" width="880px" height="150px">
        </div>
        <div id="menu">
            <ul id="menu">
                <li> <a href="<%=request.getContextPath()%>/index.jsp"> Log Out</a> </li>
            </ul> 
         </div>     
        <div id="content">
            <div class="rain">
                <div class="border start">
                    <form name="update" action="<%=request.getContextPath()%>/InstructorDetailsServlet" method="post">
                        <table border="1" >
                            <c:forEach var="instructor" items="${instructors}">
                                <tr>
                                    <h4>Personal Information</h4>
                                </tr>
                                <tr>
                                    <td>Instructor ID</td>
                                    <td><c:out value="${instructor.instructorID}"/>
                                        <input type="hidden" name="instructorID" value="<c:out value="${instructor.instructorID}"/>"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Instructor Name</td>
                                    <td><c:out value="${instructor.instructorFirstName}"/> <c:out value="${instructor.instructorMiddleName}"/> <c:out value="${instructor.instructorLastName}"/></td>
                                </tr>
                                <tr>
                                    <td>Gender</td>
                                    <td><c:out value="${instructor.instructorGender}"/></td>
                                </tr>
                                <tr>
                                    <td>Date of Birth</td>
                                    <td><c:out value="${instructor.instructorDOB}"/></td>
                                </tr>
                                <tr>
                                    <td>Contact Number</td>
                                    <td><input type="text" name="contactNumber" id="contact" required="" value="<c:out value='${instructor.instructorContact}'/>"/></td>
                                </tr>
                                <tr>
                                    <td>Email ID</td>
                                    <td><input type="email" name="emailID" id="email" required="" value="<c:out value="${instructor.instructorEmail}"/>"/></td>
                                </tr>
                            </c:forEach>
                            <c:forEach var="instructor" items="${instructorDept}">
                                <tr>
                                    <td>Department</td>
                                    <td><c:out value="${instructor.departmentCode}"/> - <c:out value="${instructor.departmentName}"/></td>
                                </tr>
                            </c:forEach>
                                <tr>
                                    <td>Subjects</td>
                                    <td>
                                        <c:forEach var="instructor" items="${instructorSubjects}">
                                        <c:out value="${instructor.subjectName}"/>, 
                                        </c:forEach>
                                    </td>
                                </tr>
                        </table>
                        <br>
                        <input type="hidden" name="check" value="EDITINSTRUCTOR"/>
                        <input type="submit" name="edit" class="myButton" value="Update">
                        
                    </form>
                    <form name="fm" class="subForm"  action="<%=request.getContextPath()%>/InstructorDetailsServlet" method="post">
                        <c:forEach var="instructor" items="${instructors}">
                             <input type="hidden" name="instructorID" value="<c:out value="${instructor.instructorID}"/>"/>
                             </c:forEach>
                            <input type="submit" name="marks" class="myButton" value="ENTER MARKS">
                        </form>
                </div>
            </div>
        </div>
        <div id="footer">
            <p style="text-align: center">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>
        </div>
    </body>
</html>