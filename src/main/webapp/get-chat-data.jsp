<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="javax.naming.InitialContext" %>

    <%
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/my-db");
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "select ChatName, ChatMesg, DATE_FORMAT(ChatDate, \'%Y/%m/%d %k:%i:%s\') "
          + " from DEMO_CHAT order by ChatDate";
        ResultSet rst = stmt.executeQuery(sql);
        while (rst.next()) {
          out.print("<br/><span style=\'color:red;\'>" + rst.getString(1) + "</span>");
          out.print(" &gt; " + rst.getString(2));
          out.print(" <span style=\'color:gray;\'>(" + rst.getString(3) + ")</span>");
        }
        rst.close();
        stmt.close();
        conn.close();
    %>
