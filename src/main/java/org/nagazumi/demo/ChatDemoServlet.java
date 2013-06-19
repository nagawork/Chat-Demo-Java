package org.nagazumi.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Demo program for SAH Study Vol.2
 * @author Copyright (C) 2013 Nagazumi
 */
public class ChatDemoServlet extends HttpServlet {

  // JDBC Driver Datasource
  private DataSource dataSource = null;

 /**
  *
  * Initial Servlet
  *
  */
  public void init() throws ServletException {
    try{
      Context context = new InitialContext();
      dataSource = (DataSource)context.lookup("java:comp/env/jdbc/naga-demo");
    } catch (NamingException e) {
      throw new ServletException(e);
    }
  }

  /**
   *
   * Chat data posting
   * @param request  Servlet Reqest
   * @param response Servlet Responce
   * @throws IOException 
   * @throws ServletException 
   *
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {

    // URL for Chat data get Service
    String forward_url = "/get-chat-data.jsp";

    // Set CharacterSet
    // response.setContentType("text/html; charset=utf-8");
    request.setCharacterEncoding("utf-8");
    
    // Get Parameter
    String chat_nam = request.getParameter("chat_nam");
    if (chat_nam == null || chat_nam.length() == 0){
      RequestDispatcher dispatcher = request.getRequestDispatcher(forward_url);
      dispatcher.forward(request, response);
      return;
    }
    String chat_msg = request.getParameter("chat_msg");
    if (chat_msg == null || chat_msg.length() == 0){
      RequestDispatcher dispatcher = request.getRequestDispatcher(forward_url);
      dispatcher.forward(request, response);
      return;
    }

    // Store Data Base
    try {
      Connection conn = dataSource.getConnection();
      String sql = "insert into DEMO_CHAT (ChatName, ChatMesg, ChatDate) values (?, ?, now())";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1,chat_nam);
      stmt.setString(2,chat_msg);
      stmt.executeUpdate();
      stmt.close();
      conn.close();
    }
    catch (SQLException e) {
      throw new ServletException(e);
    }

    // Forward Chat data Get Service
    RequestDispatcher dispatcher = request.getRequestDispatcher(forward_url);
    dispatcher.forward(request, response);
  }
}
