package sk.umb.dvestodola.rabbitmq.OpenAI.service;

import java.util.List;

import lombok.Data;

@Data
public class ImageGeneratorResponseDto {
  private List<GeneratedImage> data;
}
