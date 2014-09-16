<%-- 
    Document   : addDepartment
    Created on : Aug 13, 2014, 11:30:56 PM
    Author     : Raj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="../Style/style.css"/>
        <style>
            .border,.rain{
                height: 380px;
                width: 530px
            }
        </style>
    </head>
    <body>
        <div id="header">
            <img src="../Style/banner.jpg" width="880px" height="150px">
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
            <h1>Add Department</h1>
        </div>     

        <div id="content">
            <div class="rain">
                <div class="border start">


                    <form name="department" action="<%=request.getContextPath()%>/DepartmentServlet" method="post">
                        Department Code:
                        <input type="text" name="departmentCode" required=""/><br/>
                        Department Name:
                        <input type="text" name="departmentName" required=""/><br/>
                        <input type="submit" value="Add Department"/> 
                    </form>

                </div>
            </div>
        </div>
        <div id="footer">
            <p style="text-align: center">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>
        </div>
    </body>
</html>
