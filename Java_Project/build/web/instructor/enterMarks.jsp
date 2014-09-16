
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instructor Profile Page</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/style.css"/>
        <style>
            .border,.rain{
                height: 400px;
                width: 480px
            }
            .subForm{
                height: 120px;
                width: 480px;
            }
            form{height: 70%;}
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
                    <form class="subForm" name="editDep" action="<%=request.getContextPath()%>/InstructorDetailsServlet" method="post">
                        Select Subject:
                        <select name="subjectCode">
                            <c:forEach var="instructor" items="${instructorSubjects}">
                                <option value="<c:out value='${instructor.instructorSubjectCode}'/>"><c:out value="${instructor.subjectName}"/></option>
                            </c:forEach>
                        </select>
                        <c:forEach var="instructor" items="${instructorSubjects}">
                            <input type="hidden" name="instructorID" value="<c:out value='${instructor.instructorID}'/>"/>
                        </c:forEach>
                        <input type="hidden" name="check" value="SEARCHMARKS"/>
                        <input type="submit" class="myButton" value="Search"/>
                    </form>        
                    <form name="updateMarks" action="<%=request.getContextPath()%>/InstructorDetailsServlet" method="post">
                        <table border="1" >
                            <tr>
                                <th>Student ID</th>
                                <th>Student Name</th>
                                <th>Marks</th>

                            </tr>
                            <c:forEach var="studMarks" items="${marks}">

                                <tr>
                                    <td><c:out value='${studMarks.studentId}'/></td>
                                    <td><c:out value="${studMarks.studentFullName}"/> </td>
                                    <td><c:out value="${studMarks.marks}"/></td>                      
                                </tr>

                            </c:forEach>
                        </table>
                        <h4>Update Marks</h4>
                        Select Student Id:            
                        <select name="studentId">
                            <c:forEach var="studMarks" items="${marks}">
                                <option value="<c:out value='${studMarks.studentId}'/>"><c:out value='${studMarks.studentId}'/> - <c:out value="${studMarks.studentFullName}"/></option>
                            </c:forEach>
                        </select> <br/>
                        Enter Marks:
                        <c:forEach var="studMarks" items="${marks}">
                            <input type="hidden" name="subjectcode"  value="<c:out value='${studMarks.instructorSubjectCode}'/>"/>
                        </c:forEach>
                        <c:forEach var="instructor" items="${marks}">
                            <input type="hidden" name="instructorID" value="<c:out value='${instructor.instructorID}'/>"/>
                        </c:forEach>
                        <input type="text" name="studentMarks" required=""/> <br/>
                        <input type="hidden" name="check" value="UPDATEMARKS"/>
                        <input type="submit" class="myButton" value="Update Marks"/>    
                    </form>

                </div>
            </div>
        </div>
        <div id="footer">
            <p style="text-align: center">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>
        </div>
    </body>
</html>