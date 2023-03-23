package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class JSP_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
 Class.forName("org.apache.derby.jdbc.ClientDriver"); 
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Connection c= DriverManager.getConnection("jdbc:derby://localhost:1527/exp-9-ip-invoice","invoice","invoice");
            Statement s1=c.createStatement();
            int count =0;
            ResultSet rs1=s1.executeQuery("select count(*) from invoice");
            while(rs1.next())
            {
                count = rs1.getInt(1);
            }
            Statement s2=c.createStatement();
            ResultSet rs2=s2.executeQuery("select sum(TOTAL_AMOUNT) from invoice");
            double tot_invoice=0;
            while(rs2.next())
            {
                tot_invoice = rs2.getDouble(1);
            }
            Statement s3=c.createStatement();
            ResultSet rs3=s3.executeQuery("select avg(TOTAL_AMOUNT) from invoice");
            double avg_invoice = 0;
            while(rs3.next())
            {
                avg_invoice = rs3.getDouble(1);
            }
            out.println("<tr>"+"<td>"+count+"</td>"+"<td>"+tot_invoice+"</td>"+"<td>"+avg_invoice+"</td>"+"</tr>");
        
      out.write("\n");
      out.write("        <table border=\"2\" style=\"border-collapse: collapse ; text-align: center\">\n");
      out.write("            <tr>\n");
      out.write("            <th>NUMBER OF INVOICES</th>\n");
      out.write("            <th>TOTAL INVOICE</th>\n");
      out.write("            <th>AVERAGE INVOICE</th>\n");
      out.write("            </tr>\n");
      out.write("                ");
 
//                    int count = 0;
//                    double tot_invoice=0;
//                    double avg_invoice = 0;
//                    while(rs.next())
//                    {
//                       count++;
//                       tot_invoice = tot_invoice + rs.getDouble(4);
//                    }
//                    avg_invoice=tot_invoice/count;
//                    out.println("<tr>"+"<td>"+count+"</td>"+"<td>"+tot_invoice+"</td>"+"<td>"+avg_invoice+"</td>"+"</tr>");
                
      out.write("\n");
      out.write("        </table>\n");
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
