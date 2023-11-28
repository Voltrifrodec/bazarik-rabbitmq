package sk.umb.dvestodola.rabbitmq;

import org.apache.logging.log4j.message.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

  @Autowired RabbitTemplate rabbitTemplate;

  @Override
  public void run(String... args) throws Exception {
    // System.out.println("Sending message...");
    // Message bytes = (Message) rabbitTemplate.convertSendAndReceive(RabbitmqApplication.topicExchangeName, "foo.bar.image", "Generate an image featuring a strikingly beautiful woman, amidst the serene yet eerie backdrop of a forest, experiencing a complex mix of emotions as she both laughs and cries, her form adorned with blood. In this captivating scene, the dappled sunlight filters through the dense foliage, creating a surreal ambiance. The woman, with an ethereal and captivating presence, stands in a clearing surrounded by ancient trees. Her tear-streaked face carries the weight of sorrow, yet her laughter is echoed in the haunting stillness of the forest. The blood, both a stark contrast and a mysterious element, adds an intriguing layer to the narrative. Use lighting to create a delicate play between shadows and highlights, emphasizing the woman's beauty while maintaining the emotional depth of the scene. The forest, with its towering trees and lush vegetation, becomes a silent witness to the complexity of her emotions. The overall composition should evoke a sense of both beauty and tragedy, inviting the viewer to explore the intricate emotions within the image. Ensure that the image captures the enigmatic blend of beauty, laughter, and sorrow, offering a visually stunning and emotionally charged portrayal of the woman in this haunting forest setting.");
    // Message bytes = (Message) rabbitTemplate.convertSendAndReceive(RabbitmqApplication.topicExchangeName, "foo.bar.image", "Generate an image featuring a strikingly beautiful woman, amidst the serene yet eerie backdrop of a forest, experiencing a complex mix of emotions as she both laughs and cries, her form adorned with blood. In this captivating scene, the dappled sunlight filters through the dense foliage, creating a surreal ambiance. The woman, with an ethereal and captivating presence, stands in a clearing surrounded by ancient trees. Her tear-streaked face carries the weight of sorrow, yet her laughter is echoed in the haunting stillness of the forest. The blood, both a stark contrast and a mysterious element, adds an intriguing layer to the narrative. Use lighting to create a delicate play between shadows and highlights, emphasizing the woman's beauty while maintaining the emotional depth of the scene. The forest, with its towering trees and lush vegetation, becomes a silent witness to the complexity of her emotions. The overall composition should evoke a sense of both beauty and tragedy, inviting the viewer to explore the intricate emotions within the image. Ensure that the image captures the enigmatic blend of beauty, laughter, and sorrow, offering a visually stunning and emotionally charged portrayal of the woman in this haunting forest setting.");
    // Object bytes = rabbitTemplate.convertSendAndReceive(RabbitmqApplication.topicExchangeName, "foo.bar.baz", "Drawn dick");
    // System.out.println(bytes);
    return;
  }
} 