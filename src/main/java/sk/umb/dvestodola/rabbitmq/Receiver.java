package sk.umb.dvestodola.rabbitmq;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

import sk.umb.dvestodola.rabbitmq.GptRender.GptRenderService;

@Component
public class Receiver {

  private CountDownLatch latch = new CountDownLatch(1);

  private GptRenderService gptRenderService;

  public Receiver(GptRenderService gptRenderService) {
	this.gptRenderService = gptRenderService;
  }

  public byte[] receiveMessage(String message) {
		System.out.println("Receiver received a message, " + message);

		// TODO: Get generated image by AI with API call
		
		try {
			// Simulating generating image
			this.simulateApiCall();
			System.out.println("Message from Chad: " + gptRenderService.chat("Hello"));

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
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}