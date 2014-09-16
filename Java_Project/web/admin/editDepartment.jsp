<%-- 
    Document   : editDepartment
    Created on : Aug 14, 2014, 12:18:03 AM
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
                height: 400px;
                width: 460px
            }
            .subForm{
                height: 100px;
            }
            form{height: 75%;}
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
            <h1>Edit Department</h1>
        </div>     

        <div id="content">
            <div class="rain">
                <div class="border start">

                    <form class="subForm" name="editDep" action="<%=request.getContextPath()%>/DepartmentServlet" method="post">
            Select Department Code:
            <select name="departmentCode">
                <c:forEach var="departmentCd" items="${department}">
                    <option value="<c:out value='${departmentCd.departmentCode}'/>"><c:out value="${departmentCd.departmentCode}"/></option>
                </c:forEach>
            </select>
             <input type="hidden" name="check" value="SEARCH"/>
            <input type="submit" value="Search"/>
        </form>        
        <form name="editForm" action="<%=request.getContextPath()%>/DepartmentServlet" method="post">
            Department Id:
            <select name="departmentId">
               <c:forEach var="departmentOne" items="${oneDepartment}">
                    <option value="<c:out value='${departmentOne.departmentId}'/>"><c:out value="${departmentOne.departmentId}"/></option>
                </c:forEach>
            </select><br/><br/>
            Department Code: 
            <c:forEach var="departmentOne" items="${oneDepartment}">
            <input type="text" name="departmentCode" required="" value="<c:out value="${departmentOne.departmentCode}"/>"/><br/>
             </c:forEach><br/><br/>
            Department Name:
             <c:forEach var="departmentOne" items="${oneDepartment}">
             <input type="text" name="departmentName" required="" value="<c:out value="${departmentOne.departmentName}"/>" /><br/>
             </c:forEach><br/>
            
             <input type="submit" class="myButton"  name="check" value="Update"/>
             <input type="submit" class="myButton" name="check" value="Delete">
            
        </form>
        
                </div>
            </div>
        </div>
        <div id="footer">
            <p style="text-align: center">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>
        </div>
    </body>
</html>
