<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import=" java.util.ArrayList" %>
<%@ page import="org.nagazumi.demo.chat.ChatData" %>
<%@ page import="org.nagazumi.demo.chat.ChatDemo" %>

    <%
        ChatDemo chatdemo = new ChatDemo();
        chatdemo.initChatDemo();
        
        ArrayList<ChatData> array = chatdemo.selectAllChatData();
        for (ChatData data: array) {
          out.print("<br/><span style=\'color:red;\'>" + data.getName() + "</span>");
          out.print(" &gt; " + data.getMesg());
          out.print(" <span style=\'color:green;\'>(" + data.getDate() + ")</span>");
        }
    %>
