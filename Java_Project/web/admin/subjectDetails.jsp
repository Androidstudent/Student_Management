
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subject-Details</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/style.css"/>
         <style>
            .border,.rain{
				height: 500px;
				width: 480px
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
     
    </div>     
        
        <div id="content">
        <div class="rain">
			<div class="border start">
                            <form>
       <table border="1" >  
           <tr>
                    <th>Subject Name</th>
                    <th>Semester</th>
                    <th>Instructor Name</th>
                    <th>Department</th>
           </tr>
            <c:forEach var="subjectDetails" items="${subject}">    
                <tr>                    
                    <td><c:out value="${subjectDetails.subjectName}"/></td>
                    <td><c:out value="${subjectDetails.semister}"/></td>
                    <td><c:out value="${subjectDetails.instructorName}"/></td>
                    <td><c:out value="${subjectDetails.departmentCode}"/></td>
                </tr>
                       
            </c:forEach>
        </table>
         </form>
        
         </div>
        </div>
        </div>
        <div id="footer">
            <p style="text-align: center">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>
        </div>
    </body>
</html>
