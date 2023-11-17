package sk.umb.dvestodola.rabbitmq.GptRender;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
// import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.service.annotation.PostExchange;

import sk.umb.dvestodola.rabbitmq.GptRender.service.ChatRequestDTO;
import sk.umb.dvestodola.rabbitmq.GptRender.service.ChatResponse;

// interface GptClient {
//     @PostExchange("/v1/chat/completions")
//     ChatResponse chat(@RequestBody ChatRequestDTO requestDto);
// }

@Service
public class GptRenderService {

    public String chat(String prompt) {
        
        final String url = "https://api.openai.com/v1/chat/completions";
        final String params = "?prompt=" + prompt + "?model=gpt-3.5-turbo-0613";
        final String apiKey = "no";


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        // Create HttpEntity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        
    
        try{
    
            ResponseEntity<ChatResponse> responseEntity = restTemplate.postForEntity(url + "" + params, entity,
                    ChatResponse.class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return responseEntity.getBody().getChoices().get(0).getMessage().getContent();
            }
    
        }catch(
        Exception err)
        {
            System.out.println("Error: " + err);
            return "Nie je uvedený žiadny opis.";
        }
    
        System.out.println("<error>");
        return "Nie je uvedený žiadny opis.";

    }


    
    // @Qualifier("openaiRestTemplate")
    // private final RestTemplate restTemplate;

    // public GptRenderService(RestTemplate restTemplate) {
    //     this.restTemplate = restTemplate;
    // }

    

    // // @Value("${openai.model}")
    // // FIXME: Presunúť späť do application.properties!
    // private final String MODEL = "gpt-3.5-turbo";
    
    // // @Value("${openai.api.url}")
    // // FIXME: Presunúť späť do application.properties!
    // private final String API_URL = "https://api.openai.com/v1/chat/completions";
    
    // public String chat(@RequestParam String prompt) throws IOException {

    //     var wc = builder.baseUrl("https://api.openai.com")
    //             .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    //             .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
    //             .clientConnector(new ReactorClientHttpConnector(httpClient))
    //             .build();

    //     URL url = new URL(API_URL + "/chat");
    //     HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    //     connection.setRequestMethod("GET");
    //     connection.connect();


    //     ChatRequestDTO request = new ChatRequestDTO(MODEL, prompt);

    //     ChatResponse response = restTemplate.postForObject(API_URL, connection, ChatResponse.class);

    //     if(response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
    //         return "Nie je uvedený žiadny opis.";
    //     }

    //     return response.getChoices().get(0).getMessage().getContent();

    // }

}
