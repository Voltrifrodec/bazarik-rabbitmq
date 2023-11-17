package sk.umb.dvestodola.rabbitmq;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

import sk.umb.dvestodola.rabbitmq.OpenAI.service.OpenAIService;

@Component
public class Receiver {

  private CountDownLatch latch = new CountDownLatch(1);

  private OpenAIService openAIService;

  public Receiver(OpenAIService openAIService) {
	this.openAIService = openAIService;
  }

  public byte[] receiveMessage(String message) {
		System.out.println("Receiver received a message, " + message);

		// TODO: Get generated image by AI with API call
		
		try {
			// Simulating generating image
			this.simulateApiCall();


			return getClass().getResourceAsStream("/generated_image.jpg").readAllBytes();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
  }

  public CountDownLatch getLatch() {
    return latch;
  }

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