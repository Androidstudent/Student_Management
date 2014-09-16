package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            function fillDdl()\n");
      out.write("            {\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("\t\t$(function(){\n");
      out.write("\t\t  var $form_inputs =   $('form input');\n");
      out.write("\t\t  var $rainbow_and_border = $('.rain, .border');\n");
      out.write("\t\t  /* Used to provide loping animations in fallback mode */\n");
      out.write("\t\t /* $form_inputs.bind('focus', function(){\n");
      out.write("\t\t  \t$rainbow_and_border.addClass('end').removeClass('unfocus start');\n");
      out.write("\t\t  });\n");
      out.write("\t\t  $form_inputs.bind('blur', function(){\n");
      out.write("\t\t  \t$rainbow_and_border.addClass('unfocus start').removeClass('end');\n");
      out.write("\t\t  });*/\n");
      out.write("\t\t  $form_inputs.first().delay(800).queue(function() {\n");
      out.write("\t\t\t$(this).focus();\n");
      out.write("\t\t  });\n");
      out.write("\t\t});\n");
      out.write("\t</script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Style/style.css\"/>\n");
      out.write("        <style>\n");
      out.write("        .border,.rain{\n");
      out.write("\t\t\t\theight: 270px;\n");
      out.write("\t\t\t\twidth: 240px\n");
      out.write("\t\t\t}\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("\t</head>\n");
      out.write("        <title>Home</title>\n");
      out.write("    </head>\n");
      out.write("    <body id=\"home\">\n");
      out.write("        \n");
      out.write("        <div id=\"header\">\n");
      out.write("            <img src=\"Style/banner.jpg\" width=\"880px\" height=\"150px\">\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("     <div id=\"menu\">\n");
      out.write("    \n");
      out.write("      <h1>Welcome , Lambton Student Management System.</h1>\n");
      out.write("    </div>     \n");
      out.write("        \n");
      out.write("    <div id=\"content\">\n");
      out.write("    \n");
      out.write("        <div id=\"content-left\">\t\n");
      out.write("            <div class=\"rain\">\n");
      out.write("\t\t\t<div class=\"border start\">\n");
      out.write("                            \n");
      out.write("       <form name=\"studentInsert\" action=\"");
      out.print(request.getContextPath());
      out.write("/LogInServlet\" method=\"post\">\n");
      out.write("           <div style=\"margin-left:1%;text-align:center;font-weight:bold\">Login</div>\n");
      out.write("           <label>Username:</label>  \n");
      out.write("         <input type=\"text\" name=\"userName\" id=\"userName\" />\n");
      out.write("           <label>Password:</label>  \n");
      out.write("            <input type=\"password\" name=\"password\" id=\"password\"/>\n");
      out.write("           <input type=\"submit\" style=\"outline:none; width:105px\" name=\"submit\" value=\"submit\"/>\n");
      out.write("        </form>\n");
      out.write("                       </div>\n");
      out.write("                </div>\n");
      out.write("        </div>\n");
      out.write("            <div id=\"content-right\"> \n");
      out.write("                <p style=\"width: 450px\" style=\"text-align: justify\"> \n");
      out.write("                       Lambton College is in its 47th year and in that time the College has gained worldwide \n");
      out.write("                       recognition as a specialized institution. Lambton currently has its main campus in Sarnia, \n");
      out.write("                       the Fire & Public Safety  Centre of Excellence just outside city limits and an Employment \n");
      out.write("                       and Learning Centre in Petrolia. We also have multiple campuses located in China.<br/>\n");
      out.write("                       In the past 46 years, the College has been working hard to provide even more to its 3,600+ \n");
      out.write("                       full-time and 6,500 part-time students. The College continues to grow every year by offering \n");
      out.write("                       new programs, new research opportunities and improved lab and classroom facilities. \n");
      out.write("                </p>\n");
      out.write("             </div>\n");
      out.write("        </div>\n");
      out.write("           <div id=\"footer\">\n");
      out.write("               <p style=\"text-align: center\">  All Rights Reserved. Copyrights 2014 | Developed By: Banana Software Inc. </p>\n");
      out.write("           </div>\n");
      out.write("           \n");
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
