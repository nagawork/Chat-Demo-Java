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
}