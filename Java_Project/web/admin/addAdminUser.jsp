<%-- 
    Document   : addAdminUser
    Created on : Aug 13, 2014, 9:51:18 PM
    Author     : Raj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/style.css"/>
         <style>
            .border,.rain{
				height: 400px;
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
            <input type="text" name="userName" value="" required=""/>
            <br/>
            New Password:
            <input type="password" name="password" value=""  required=""/><br/>
            Confirm Password: 
            <input type="password" name="confirmPassword" value="" required=""/><br/>
            <input type="hidden" name="check" value="A"/>
            <input type="submit" name="submit" value="Create User"/>
        </form>
                             </div>
        </div>
        </div>
        <div id="footer">
            <p style="text-align: center">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>
        </div>
    </body>
</html>
