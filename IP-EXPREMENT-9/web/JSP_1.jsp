<%-- 
    Document   : JSP_1
    Created on : 22 Mar, 2023, 2:47:15 PM
    Author     : himal
--%>
<% Class.forName("org.apache.derby.jdbc.ClientDriver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="2" style="border-collapse: collapse ; text-align: center">
            <tr>
            <th>NUMBER OF INVOICES</th>
            <th>TOTAL INVOICE</th>
            <th>AVERAGE INVOICE</th>
            </tr>
        <%
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
        %>
        
                <% 
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
                %>
        </table>
    </body>
</html>
