package sk.umb.dvestodola.rabbitmq;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sk.umb.dvestodola.rabbitmq.DallEHack.DEHService;
// import sk.umb.dvestodola.rabbitmq.OpenAI.service.ImageGeneratorService;

@Component
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);

	@Autowired
	private DEHService dehService;

	public byte[] receiveMessage(String message) {
		System.out.println("Receiver received a message of length " + message.length());

		return dehService.generateImage(message);

	}

	// @Autowired
  	// private ImageGeneratorService generateImageService;

	// public byte[] receiveMessage(String message) {
	// 	System.out.println("Receiver received a message, " + message);

	// 	// TODO: Get generated image by AI with API call
		
	// 	return generateImageService.generateImage(message);

  	// }

 	public CountDownLatch getLatch() {
    	return latch;
  	}

	@SuppressWarnings("unused")
	private void simulateApiCall() {
		System.out.println("Simulating an api call");
		int miliseconds = 2 * 1000;
		try {
			// System.out.println("Message from Chad: " + openAIService.chat("Hello"));
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}