package org.nagazumi.demo.chat;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Demo program for SAH Study Vol.2
 * @author Copyright (C) 2013 Nagazumi
 */
public class ChatDemoServlet extends HttpServlet {

  // JDBC Driver Datasource
  private ChatDemo chatdemo = null;

  /**
   *
   * Initial Servlet
   *
   */
  public void init() throws ServletException {
    chatdemo = new ChatDemo();
    try{
      chatdemo.initChatDemo();
    } catch (Exception e) {
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
    ChatData data = new ChatData();
    data.setName(request.getParameter("chat_nam"));
    data.setMesg(request.getParameter("chat_msg"));

    // Check Parameter
    if (data.checkPostData() == false){
      RequestDispatcher dispatcher = request.getRequestDispatcher(forward_url);
      dispatcher.forward(request, response);
      return;
    }

    // Store Data
    try {
      chatdemo.insertChatData(data);
    } catch (Exception e) {
      throw new ServletException(e);
    }

    // Forward Chat data Get Service
    RequestDispatcher dispatcher = request.getRequestDispatcher(forward_url);
    dispatcher.forward(request, response);
  }
}
