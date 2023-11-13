package sk.umb.dvestodola.rabbitmq;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import sk.umb.dvestodola.rabbitmq.services.Receiver;

@Component
public class Runner implements CommandLineRunner {

  private final RabbitTemplate rabbitTemplate;
  private final Receiver receiver;

  public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
    this.receiver = receiver;
    this.rabbitTemplate = rabbitTemplate;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Sending message...");
    // Message bytes = (Message) rabbitTemplate.convertSendAndReceive(RabbitmqApplication.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
    Object bytes = rabbitTemplate.convertSendAndReceive(RabbitmqApplication.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
    System.out.println(bytes);
    // receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
  }

} 