package sk.umb.dvestodola.rabbitmq.OpenAI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ImageGeneratorService {
  
	@Autowired RestTemplate restTemplate;

	@Value("${openai.model}")
	private String model;
	// private String model = "gpt-3.5-turbo";
	
	@Value("${openai.api.url}")
	private String url;
	// private String url = "https://api.openai.com/v1/chat/completions";

	public byte[] generateImage(String advertName) {
		System.out.println("Generate image method was called with prompt, " + advertName);

		ImageGeneratorRequestDto request = new ImageGeneratorRequestDto();
    request.setModel(model);
    request.setPrompt(advertName);

    System.out.println(model);
    System.out.println(url);
    System.out.println(request.toString());

    Object response = restTemplate.postForObject(url, request, ImageGeneratorResponseDto.class);
    if (response == null) {
      throw new RuntimeException("Response is null.");
    }
    System.out.println(response.toString());

		// return response.getData().get(0).getUrl();
    return new byte[0];
	}
}
