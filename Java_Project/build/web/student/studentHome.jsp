
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Profile Page</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/style.css"/>
        <style>
            .border,.rain{
                height: 900px;
                width: 480px
            }
            form{height: 97.5%;}
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
                    <form name="studUpdate" action="<%=request.getContextPath()%>/StudentDetailsServlet" method="post">
                        <table border="1" >    
                            <c:forEach var="student" items="${students}">
                                <tr>
                                <h4>Personal Information</h4>
                                </tr>
                                 <tr>
                                    <td>Student Id</td>
                                    <td><c:out value="${student.studentID}"/><input type="hidden" name="studentId" value="<c:out value="${student.studentID}"/>"/></td>
                                </tr>
                                <tr>
                                    <td>Student Name</td>
                                    <td><c:out value="${student.studentFirstName}"/> <c:out value="${student.studentMiddleName}"/> <c:out value="${student.studentLastName}"/></td>
                                </tr>
                                <tr>
                                    <td>Gender</td>
                                    <td><c:out value="${student.studentGender}"/></td>
                                </tr>
                                <tr>
                                    <td>Date of Birth</td>
                                    <td><c:out value="${student.studentDOB}"/></td>
                                </tr>
                                <tr>
                                    <td>Contact Number</td>
                                    <td><input type="text" name="contactNumber" id="contact" required="" value="<c:out value='${student.studentContact}'/>"/></td>
                                </tr>
                                <tr>
                                    <td>Email ID</td>
                                    <td><input type="email" name="emailID" id="email"required="" value="<c:out value="${student.studentEmail}"/>"/></td>
                                </tr>
                            </c:forEach>
                            <c:forEach var="location" items="${address}">
                                <tr>
                                    <td>Address</td>
                                    <td><input type="text" name="address" id="address" required="" value="<c:out value='${location.address}'/>"/></td>
                                </tr>
                                <tr>
                                    <td>City</td>
                                    <td><input type="text" name="city" id="contact" required="" value="<c:out value='${location.city}'/>"/></td>
                                </tr>
                                <tr>
                                    <td>State</td>
                                    <td><input type="text" name="state" id="contact" required="" value="<c:out value='${location.state}'/>"/></td>
                                </tr>
                                <tr>
                                    <td>Pincode</td>
                                    <td><input type="text" name="pincode" id="contact" required="" value="<c:out value='${location.pincode}'/>"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <br/>
                        <input type="hidden" name="check" value="studUpdate"/>
                        <input type="submit" class="myButton" id="studentUpdate" value="Update"/><br/><br/><br/>
                        
                        <table border="1" >
                            <tr><h4>Marks Scored</h4></tr>

                            <tr>
                                <th>Subject Code</th>
                                <th>Subject Name</th>
                                <th>Marks</th>
                            </tr>
                            <c:forEach var="mark" items="${marks}">
                                <tr>
                                    <td><c:out value="${mark.subjectCode}"/></td>
                                    <td><c:out value="${mark.subjectName}"/></td>
                                    <td><c:out value="${mark.studentMarks}"/></td>
                                </tr>
                            </c:forEach>
                        </table><br>
                           
                    </form>
                </div>
            </div>
        </div>
        <div id="footer">
            <p style="text-align: center">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>
        </div>
    </body>
</html>
