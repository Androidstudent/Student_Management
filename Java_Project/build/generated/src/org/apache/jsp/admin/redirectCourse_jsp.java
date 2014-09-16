package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class redirectCourse_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin-Course</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../Style/style.css\"/>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("   \n");
      out.write("        <body id=\"home\">\n");
      out.write("        \n");
      out.write("        <div id=\"header\">\n");
      out.write("            <img src=\"../Style/banner.jpg\" width=\"880px\" height=\"150px\">\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("     <div id=\"menu\">\n");
      out.write("       <ul id=\"menu\">\n");
      out.write("    \n");
      out.write("           <li><a href=\"redirectInstructor.jsp\">Instructor</a> </li>  \n");
      out.write("           <li><a href=\"redirectStudent.jsp\">Student</a> </li>  \n");
      out.write("    <li> <a href=\"redirectCourse.jsp\"> Course </a>  </li> \n");
      out.write("    <li> <a href=\"redirectDepartment.jsp\"> Department </a> </li>\n");
      out.write("    <li> <a href=\"redirectUser.jsp\"> User </a> </li>\n");
      out.write("    \n");
      out.write("</ul> \n");
      out.write("      <h1>Course Information</h1>\n");
      out.write("    </div>     \n");
      out.write("        \n");
      out.write("    <div id=\"content\">\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("         <form name=\"temp\" id=\"temp\" action=\"");
      out.print(request.getContextPath());
      out.write("/SubjectDetailsServlet\" method=\"post\">\n");
      out.write("            <input type=\"hidden\" name=\"check\" value=\"1\"/>\n");
      out.write("            <input type=\"button\" name=\"details\"  class=\"myButton\" onclick=\"document.getElementById('temp').submit();\" value=\"GET\">\n");
      out.write("        </form>\n");
      out.write("        <form name=\"add\" id=\"add\" action=\"");
      out.print(request.getContextPath());
      out.write("/SubjectDetailsServlet\" method=\"post\">\n");
      out.write("            <input type=\"hidden\" name=\"check\" value=\"2\"/>\n");
      out.write("            <input type=\"button\" name=\"add\"  class=\"myButton\" onclick=\"document.getElementById('add').submit();\" value=\"ADD\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div id=\"content-left\">\t\n");
      out.write("            <div class=\"rain\">\n");
      out.write("\t\t\t<div class=\"border start\">\n");
      out.write("                            \n");
      out.write("       <form name=\"studentInsert\" action=\"#\" method=\"post\">\n");
      out.write("           <p> Welcome, Admin , Here Admin is able to add , update , delete the instructors information as well as for the students.\n");
      out.write("               <br> Else than this Admin is able to check the courses add them and also for the departments.</p>\n");
      out.write("        </form>\n");
      out.write("                       </div>\n");
      out.write("                </div>\n");
      out.write("        </div>\n");
      out.write("            <div id=\"content-right\"> \n");
      out.write("                <p style=\"width: 480px\" style=\"text-align: justify\"> \n");
      out.write("                Welcome, Admin , Here Admin is able to add , update , delete the instructors information as well as for the students.\n");
      out.write("                <br> Else than this Admin is able to check the courses add them and also for the departments. <br>\n");
      out.write("                Here Admin is able to add , update , delete the instructors information as well as for the students.\n");
      out.write("               <br> Else than this Admin is able to check the courses add them and also for the departments.\n");
      out.write("                \n");
      out.write("                </p>\n");
      out.write("             </div>\n");
      out.write("        </div>\n");
      out.write("           <div id=\"footer\">\n");
      out.write("               <p style=\"text-align: center\">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>\n");
      out.write("           </div>\n");
      out.write("        </body> </html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
