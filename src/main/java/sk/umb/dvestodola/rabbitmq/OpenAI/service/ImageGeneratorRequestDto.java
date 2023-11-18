package sk.umb.dvestodola.rabbitmq.OpenAI.service;

import org.springframework.beans.factory.annotation.Value;
import lombok.Data;

@Data
public class ImageGeneratorRequestDto {
	@Value("${openai.model}")
	private String model;

  private String prompt;

  private String size = "1024x1024";

	private String response_format = "b64_json";

  private int n = 1;
}
