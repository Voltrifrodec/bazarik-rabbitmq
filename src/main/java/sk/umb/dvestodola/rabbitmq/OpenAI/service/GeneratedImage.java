package sk.umb.dvestodola.rabbitmq.OpenAI.service;

import lombok.Data;

@Data
public class GeneratedImage {
  private String url;
  private String b64_json;
}
