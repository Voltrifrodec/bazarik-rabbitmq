package sk.umb.dvestodola.rabbitmq.OpenAI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import sk.umb.dvestodola.rabbitmq.OpenAI.service.ChatRequestDTO;
import sk.umb.dvestodola.rabbitmq.OpenAI.service.ChatResponse;

@RestController
public class OpenAIController {
    
    //? Premenné
    @Qualifier("openaiRestTemplate")
    private final RestTemplate restTemplate;

    // TODO: Nastaviť custom property v application.properties
    // @Value("${openai.model}")
    private String model = "gpt-3.5-turbo";
    
    // TODO: Nastaviť custom property v application.properties
    // @Value("${openai.api.url}")
    private String url = "https://api.openai.com/v1/chat/completions";


    //? Konštruktor
    public OpenAIController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) {

        ChatRequestDTO request = new ChatRequestDTO(model, prompt);

        ChatResponse response = restTemplate.postForObject(url, request, ChatResponse.class);

        // response.getChoices == null je redundantné?
        if(response == null || response.getChoices().isEmpty() || response.getChoices() == null) {
            return "Tento inzerát nemá popis.";
        }

        return response.getChoices().get(0).getMessage().getContent();

    }


}
