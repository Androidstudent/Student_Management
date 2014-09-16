<%-- 
    Document   : addSubjectDetails
    Created on : Aug 13, 2014, 2:38:11 PM
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
				height: 300px;
				width: 530px
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
      <h1>Add Subject</h1>
    </div>     
        
        <div id="content">
        <div class="rain">
			<div class="border start">
        
        <form name="addSubject" action="<%=request.getContextPath()%>/AddSubjectDetailsServlet" method="post">
        
        Subject Name:
        <input type="text" name="subjectName" required=""/><br/>
        Semester:
        <select name="semester">
           
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
        </select><br/><br/>
       Instructor : 
        <select name="instructorId">
            <c:forEach var="varinstructor" items="${instructor}">
                <option value="<c:out value='${varinstructor.instructorID}'/>"><c:out value="${varinstructor.instructorFirstName}"/> <c:out value="${varinstructor.instructorLastName}"/></option>
            </c:forEach>
        </select><br/><br/>
       Department : 
        <select name="departmentId">
           <c:forEach var="department" items="${department}">
            <option value="<c:out value='${department.departmentId}'/>"><c:out value="${department.departmentCode}"/></option>
             </c:forEach>
        </select><br/><br/>
        <input type="submit" class="myButton" value="submit" name="submit"/>
        </form>
        
                        </div>
                </div>
        </div>
            <div id="footer">
               <p style="text-align: center">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>
           </div>
    </body>
</html>
