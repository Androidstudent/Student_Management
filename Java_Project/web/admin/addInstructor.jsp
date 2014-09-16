<%-- 
    Document   : instructorManage
    Created on : Aug 11, 2014, 7:15:43 PM
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
                height: 700px;
                width: 540px
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
            <h1>Add Instructor</h1>
        </div>     

        <div id="content">
            <div class="rain">
                <div class="border start">

       <form name="studentInsert" action="<%=request.getContextPath()%>/InstructorDetailsServlet" method="post">
           Instructor First Name:  
           <input type="text" name="firstName" required=""/><br/>
           Instructor Middle Name:  
           <input type="text" name="middleName" required=""/><br/>
           Instructor Last Name:  
           <input type="text" name="lastName" required=""/><br/>
            Contact Number:
           <input type="text" name="contactNumber" required=""/>
           <br/>
           Instructor Email Id:
           <input type="email" name="emailId" required=""/>
           <br/>
           Instructor Gender:<br/>  
           Male<input type="radio" name="gender" value="M"/>
           Female<input type="radio" name="gender" value="F"/>
           <br/>
           Date of Birth:<br/>
           Date:
           <select name="date">
               <%
                int i=0;
                for(i=1;i<=31;i++){
               %>
               <option value="<%=i%>"><%=i%></option>
               <%
                             }
               %>
           </select>
           Month:
            <select name="month">
               <%
                String month[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
                for(i=0;i<=11;i++){
               %>
               <option value="<%=month[i]%>"><%=month[i]%></option>
               <%
                             }
               %>
           </select>
           Year:
            <select name="year">
               <%
                int year;
                for(year=1950;year<=2014;year++){
               %>
               <option value="<%=year%>"><%=year%></option>
               <%
                             }
               %>
           </select>
         
           <input type="submit" name="submit" value="submit"/>
        </form>
              </div>
            </div>
        </div>
        <div id="footer">
            <p style="text-align: center">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>
        </div>
    </body>
</html>
