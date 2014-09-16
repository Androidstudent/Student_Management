<%-- 
    Document   : addInstructorUser
    Created on : Aug 13, 2014, 9:51:03 PM
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
				height: 290px;
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
        <form name="newUser" action="<%=request.getContextPath()%>/LogInServlet" method="post">
            UserName : 
            <select name="userName">
               <c:forEach var="instructor" items="${userInstructor}">
                <option value="<c:out value='${instructor.instructorID}'/>"><c:out value="${instructor.instructorID}"/></option>
                </c:forEach>
            </select><br/>
            New Password:
            <input type="password" name="password" value=""required="" /><br/>
            Confirm Password: 
            <input type="password" name="confirmPassword" value="" required="" /><br/>
            <input type="hidden" name="check" value="I"/>
            <input type="submit" name="submit" value="Create Instructor"/>
        </form>
               </div>
        </div>
        </div>
        <div id="footer">
            <p style="text-align: center">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>
        </div>
    </body>
</html>
