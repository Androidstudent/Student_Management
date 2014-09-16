<%-- 
    Document   : editInstructor
    Created on : Aug 13, 2014, 11:59:34 PM
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
        <form name="editD" action="#" method="post">
            <select name="instructorId">
                <c:forEach var="instructorI" items="${loadInstructor}">
                    <option value="<c:out value='${instructorI.instructorID}'/>"><c:out value="${instructorI.instructorID}"/></option>
                </c:forEach>
            </select>
        </form>
    </body>
</html>
