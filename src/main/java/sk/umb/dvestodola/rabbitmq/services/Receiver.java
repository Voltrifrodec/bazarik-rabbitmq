package sk.umb.dvestodola.rabbitmq.services;

import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

  private CountDownLatch latch = new CountDownLatch(1);

  public byte[] receiveMessage(String message) {
    System.out.println("Received <" + message + ">");
    byte[] bytes = new byte[message.length()];
    System.arraycopy(message.getBytes(), 0, bytes, 0, message.length());
    System.out.println("returning: " + bytes.toString());
    return bytes;
    // latch.countDown();
  }

  public CountDownLatch getLatch() {
    return latch;
  }

}