<%-- 
    Document   : editSubject
    Created on : Aug 14, 2014, 12:00:38 AM
    Author     : Raj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="edits" action="#" method="post">
            <select name="subjectCode">
                <c:forEach var="subject" items="${loadSubject}">
                    <option value="<c:out value='${subject.subjectCode}'/>"><c:out value="${subject.subjectCode}"/></option>
                </c:forEach>
            </select>
        </form>
    </body>
</html>
