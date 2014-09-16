package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insertSuccess_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../Style/style.css\"/>\n");
      out.write("         <style>\n");
      out.write("            .border,.rain{\n");
      out.write("\t\t\t\theight: 300px;\n");
      out.write("\t\t\t\twidth: 530px\n");
      out.write("\t\t\t}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("          \n");
      out.write("         <div id=\"header\">\n");
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
      out.write("      <h1>Add Instructor</h1>\n");
      out.write("    </div>     \n");
      out.write("        \n");
      out.write("        <div id=\"content\">\n");
      out.write("        <div class=\"rain\">\n");
      out.write("\t\t\t<div class=\"border start\">\n");
      out.write("        <form>\n");
      out.write("        <h1>Data Inserted successfully!</h1>\n");
      out.write("        </form>\n");
      out.write("          \n");
      out.write("                        </div>\n");
      out.write("                </div>\n");
      out.write("        </div>\n");
      out.write("            <div id=\"footer\">\n");
      out.write("               <p style=\"text-align: center\">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>\n");
      out.write("           </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
