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
            .border,.rain{
				height: 390px;
				width:600px
			}
                        form{height:  94%;}
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
     
    </div>     
        
        <div id="content">
        <div class="rain">
	<div class="border start">
      
            <form name="update" action="<%=request.getContextPath()%>/InstructorDetailsServlet" method="post">
                 <h4>Instructor Information</h4>
            <table border="1" >
                 <tr>
                        <th>Instructor ID</th>
                         <th>Instructor Name</th>
                         <th>Gender</th>
                         <th>Date of Birth</th>
                         <th>Contact Number</th>
                          <th>Email ID</th>
                    </tr>
                <c:forEach var="instructor" items="${loadInstructor}">
                  
                    <tr>
                       <td><c:out value='${instructor.instructorID}'/></td>
                       <td><c:out value="${instructor.instructorFirstName}"/> <c:out value="${instructor.instructorMiddleName}"/> <c:out value="${instructor.instructorLastName}"/></td>
                       <td><c:out value="${instructor.instructorGender}"/></td>
                       <td><c:out value="${instructor.instructorDOB}"/></td>
                       <td><c:out value="${instructor.instructorContact}"/></td>
                       <td><c:out value="${instructor.instructorEmail}"/></td>
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
