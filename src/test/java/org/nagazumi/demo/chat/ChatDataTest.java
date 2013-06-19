package org.nagazumi.demo.chat;
import junit.framework.*;

public class ChatDataTest extends TestCase {

  public ChatDataTest (String name){
       super(name);
  }
  public void testCheckPostData() {
    ChatData data = new ChatData();
    data.setName("NameTest");
    data.setMesg("MesgTest");
    assertTrue(data.checkPostData());
  }

  public void testCheckPostDataNameNull() {
    ChatData data = new ChatData();
    data.setMesg("MesgTest");
    assertFalse(data.checkPostData());
  }
  public void testCheckPostDataMesgNull() {
    ChatData data = new ChatData();
    data.setName("NameTest");
    assertFalse(data.checkPostData());
  }

  public void testCheckPostDataNameBlank() {
    ChatData data = new ChatData();
    data.setName("");
    data.setMesg("MesgTest");
    assertFalse(data.checkPostData());
  }
  public void testCheckPostDataMesgBlank() {
    ChatData data = new ChatData();
    data.setName("NameTest");
    data.setMesg("");
    assertFalse(data.checkPostData());
  }

}


