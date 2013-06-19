package org.nagazumi.demo.chat;

public class ChatData
{
  private int id = 0;
  private String name = null;
  private String mesg = null;
  private String date = null;
  
  public void setId(int id) { this.id = id; }
  public void setName(String name) { this.name = name; }
  public void setMesg(String mesg) { this.mesg = mesg; }
  public void setDate(String date) { this.date = date; }
  
  public int getId() { return this.id; }
  public String getName() { return this.name; }
  public String getMesg() { return this.mesg; }
  public String getDate() { return this.date; }
  
  public boolean checkPostData() {
    if (name == null || name.length() == 0) { return false; }
    if (mesg == null || mesg.length() == 0) { return false; } 
    return true;
  }
}