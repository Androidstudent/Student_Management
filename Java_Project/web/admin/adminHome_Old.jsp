
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Admin!</h1>

        <a href="<%=request.getContextPath()%>/admin/addStudent.jsp">Students Manage</a><br/>
        <a href="<%=request.getContextPath()%>/admin/addInstructor.jsp">Instructor Manage</a><br/>
        <a href="<%=request.getContextPath()%>/admin/addDepartment.jsp">Add Department</a><br/>
        <br/>
        <form name="temp" id="temp" action="<%=request.getContextPath()%>/SubjectDetailsServlet" method="post">
            <input type="hidden" name="check" value="1"/>
            <input type="button" name="details" onclick="document.getElementById('temp').submit();" value="Subject_Details">
        </form>
        <form name="add" id="add" action="<%=request.getContextPath()%>/SubjectDetailsServlet" method="post">
            <input type="hidden" name="check" value="2"/>
            <input type="button" name="add" onclick="document.getElementById('add').submit();" value="Add new Subject_Details">
        </form>

        <form name="getStudent" id="getStudent" action="<%=request.getContextPath()%>/StudentDetailsServlet" method="post">
            <input type="hidden" name="check" value="3"/>
            <input type="button" name="add" onclick="document.getElementById('getStudent').submit();" value="Get_Student_Details">
        </form> 
        <br/>

        <form name="studentUser" id="studentUser" action="<%=request.getContextPath()%>/LogInServlet" method="post">
            <input type="hidden" name="check" value="SU1"/>
            <input type="button" name="details" onclick="document.getElementById('studentUser').submit();" value="Add Students Users">
        </form>
        <form name="instUser" id="instUser" action="<%=request.getContextPath()%>/LogInServlet" method="post">
            <input type="hidden" name="check" value="IN1"/>
            <input type="button" name="add" onclick="document.getElementById('instUser').submit();" value="Add Instructor Users">
        </form>

        <form name="adminUser" id="adminUser" action="<%=request.getContextPath()%>/LogInServlet" method="post">
            <input type="hidden" name="check" value="AD1"/>
            <input type="button" name="add" onclick="document.getElementById('adminUser').submit();" value="Add Admin Users">
        </form> 

        <form name="editStud" id="editStud" action="<%=request.getContextPath()%>/StudentDetailsServlet" method="post">
            <input type="hidden" name="check" value="EDITSTUD"/>
            <input type="button" name="add" onclick="document.getElementById('editStud').submit();" value="Edit Student">
        </form> 
        <form name="editInst" id="editInst" action="<%=request.getContextPath()%>/InstructorDetailsServlet" method="post">
            <input type="hidden" name="check" value="EDITINST"/>
            <input type="button" name="add" onclick="document.getElementById('editInst').submit();" value="Edit Instructor">
        </form> 
        <form name="editSubj" id="editSubj" action="<%=request.getContextPath()%>/SubjectDetailsServlet" method="post">
            <input type="hidden" name="check" value="EDITSUBJ"/>
            <input type="button" name="add" onclick="document.getElementById('editSubj').submit();" value="Edit Subject">
        </form>
        <form name="editDep" id="editDep" action="<%=request.getContextPath()%>/DepartmentServlet" method="post">
            <input type="hidden" name="check" value="EDITDEP"/>
            <input type="button" name="add" onclick="document.getElementById('editDep').submit();" value="Edit Department">
        </form> 
    </body>
</html>
