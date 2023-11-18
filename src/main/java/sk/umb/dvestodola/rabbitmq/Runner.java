package sk.umb.dvestodola.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

  @Autowired RabbitTemplate rabbitTemplate;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Sending message...");
    // Message bytes = (Message) rabbitTemplate.convertSendAndReceive(RabbitmqApplication.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
    // Object bytes = rabbitTemplate.convertSendAndReceive(RabbitmqApplication.topicExchangeName, "foo.bar.baz", "Drawn dick");
    // System.out.println(bytes);
  }
} 