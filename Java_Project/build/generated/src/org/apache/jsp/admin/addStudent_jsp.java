package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addStudent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"../Style/style.css\"/>\n");
      out.write("        <style>\n");
      out.write("            .border,.rain{\n");
      out.write("                height: 1040px;\n");
      out.write("                width: 530px\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <div id=\"header\">\n");
      out.write("            <img src=\"../Style/banner.jpg\" width=\"880px\" height=\"150px\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"menu\">\n");
      out.write("            <ul id=\"menu\">\n");
      out.write("\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/redirectInstructor.jsp\">Instructor</a> </li>  \n");
      out.write("                <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/redirectStudent.jsp\">Student</a> </li>  \n");
      out.write("                <li> <a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/redirectCourse.jsp\"> Course </a>  </li> \n");
      out.write("                <li> <a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/redirectDepartment.jsp\"> Department </a> </li>\n");
      out.write("                <li> <a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/redirectUser.jsp\"> User </a> </li>\n");
      out.write("                <li> <a href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp\"> Log Out</a> </li>\n");
      out.write("\n");
      out.write("            </ul> \n");
      out.write("            <h1>Add Department</h1>\n");
      out.write("        </div>     \n");
      out.write("\n");
      out.write("        <div id=\"content\">\n");
      out.write("            <div class=\"rain\">\n");
      out.write("                <div class=\"border start\">\n");
      out.write("        <form name=\"studentInsert\" action=\"");
      out.print(request.getContextPath());
      out.write("/StudentDetailsServlet\" method=\"post\">\n");
      out.write("           Student First Name:  \n");
      out.write("           <input type=\"text\" name=\"firstName\" required=\"\"/><br/>\n");
      out.write("           Student Middle Name:  \n");
      out.write("           <input type=\"text\" name=\"middleName\"required=\"\"/><br/>\n");
      out.write("           Student Last Name:  \n");
      out.write("           <input type=\"text\" name=\"lastName\"required=\"\"/><br/>\n");
      out.write("           Student Gender:  <br/>\n");
      out.write("           Male:<input type=\"radio\" name=\"gender\" value=\"M\"/>\n");
      out.write("           Female:<input type=\"radio\" name=\"gender\" value=\"F\"/>\n");
      out.write("           <br/>\n");
      out.write("           Date of Birth:<br/>\n");
      out.write("           Date:\n");
      out.write("           <select name=\"date\">\n");
      out.write("               ");

                int i=0;
                for(i=1;i<=31;i++){
               
      out.write("\n");
      out.write("               <option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("               ");

                             }
               
      out.write("\n");
      out.write("           </select>\n");
      out.write("           Month:\n");
      out.write("            <select name=\"month\">\n");
      out.write("               ");

                String month[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
                for(i=0;i<=11;i++){
               
      out.write("\n");
      out.write("               <option value=\"");
      out.print(month[i]);
      out.write('"');
      out.write('>');
      out.print(month[i]);
      out.write("</option>\n");
      out.write("               ");

                             }
               
      out.write("\n");
      out.write("           </select>\n");
      out.write("           Year:\n");
      out.write("            <select name=\"year\">\n");
      out.write("               ");

                int year;
                for(year=1970;year<=2014;year++){
               
      out.write("\n");
      out.write("               <option value=\"");
      out.print(year);
      out.write('"');
      out.write('>');
      out.print(year);
      out.write("</option>\n");
      out.write("               ");

                             }
               
      out.write("\n");
      out.write("           </select>\n");
      out.write("           <br/>\n");
      out.write("           Contact Number:\n");
      out.write("           <input type=\"text\" name=\"contactNumber\" required=\"\"/>\n");
      out.write("           <br/>\n");
      out.write("           Student Email Id:\n");
      out.write("           <input type=\"email\" name=\"emailId\" required=\"\"/>\n");
      out.write("           <br/>\n");
      out.write("           Department:\n");
      out.write("           <select name=\"department\">\n");
      out.write("               <option value=\"1\">IPCT</option>\n");
      out.write("               <option value=\"2\">MDEV</option>\n");
      out.write("               <option value=\"3\">BMKT</option>\n");
      out.write("               <option value=\"4\">HOPM</option>\n");
      out.write("               <option value=\"5\">PUBH</option>\n");
      out.write("           </select>\n");
      out.write("           <br/>\n");
      out.write("           Student Address:\n");
      out.write("           <textarea name=\"address\" rows=\"4\" cols=\"20\" required=\"\">\n");
      out.write("           </textarea>\n");
      out.write("           <br/>\n");
      out.write("           City:\n");
      out.write("           <input type=\"text\" name=\"city\" required=\"\"/>\n");
      out.write("           <br/>\n");
      out.write("           State:\n");
      out.write("           <input type=\"text\" name=\"state\" required=\"\"/>\n");
      out.write("           <br/>\n");
      out.write("           Pincode:\n");
      out.write("           <input type=\"text\" name=\"pincode\" required=\"\"/>\n");
      out.write("           <br/>\n");
      out.write("           <input type=\"submit\" name=\"submit\" value=\"submit\"/>\n");
      out.write("        </form>\n");
      out.write("         </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"footer\">\n");
      out.write("            <p style=\"text-align: center\">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>\n");
      out.write("        </div>\n");
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
