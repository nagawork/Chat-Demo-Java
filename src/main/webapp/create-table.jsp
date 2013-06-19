<%@ page import="javax.naming.Context" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="javax.naming.InitialContext" %>
<html>
<body>
<h1>CreateDemo</h1>
    <%
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/my-db");
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(
          "create table DEMO_CHAT (ChatNo int auto_increment, ChatName varchar(32) not null, ChatMesg text, ChatDate datetime, index(ChatNo))"
        );
        stmt.close();
        conn.close();
    %>
</p>
<strong>Success! create table DEMO_CHAT !</strong>
</body>
</html>
