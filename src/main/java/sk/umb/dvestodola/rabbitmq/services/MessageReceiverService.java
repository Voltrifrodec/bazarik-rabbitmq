package sk.umb.dvestodola.rabbitmq.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiverService {
    
    @RabbitListener(queues = "advert-id")
    public void receiveAdvertId(String advertId) {
        System.out.println("Received advert ID: " + advertId);
    }

}
