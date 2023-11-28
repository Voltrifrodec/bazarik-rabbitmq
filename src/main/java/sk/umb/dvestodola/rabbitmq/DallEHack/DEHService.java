package sk.umb.dvestodola.rabbitmq.DallEHack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sk.umb.dvestodola.rabbitmq.DallEHack.DEHRequestDto.DEHRequestDtoItem;
import sk.umb.dvestodola.rabbitmq.DallEHack.DEHResponseDto.DEHResponseDtoItem;

@Service
public class DEHService {
    
    @Value("${openai.api.url}")
    private static String API_URL;

    @Value("${opeain.api.key}")
    private static String TOKEN;

    public byte[] generateImage(String imageText) {

        System.out.println("\"Generate Image From Text\" method has been called, text length: " + imageText.length());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer " + TOKEN);

        DEHRequestDto requestBody = new DEHRequestDto();
        List<DEHRequestDtoItem> whatAmIDoingWithMyLife = new ArrayList<>();
        whatAmIDoingWithMyLife.add(new DEHRequestDtoItem(imageText));
        requestBody.setText_prompts(whatAmIDoingWithMyLife);

        HttpEntity<DEHRequestDto> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DEHResponseDto> responseEntity = restTemplate.postForEntity(API_URL, requestEntity, DEHResponseDto.class);

        try {
            
            if(responseEntity.getStatusCode().is2xxSuccessful()) {
                List<DEHResponseDtoItem> result = responseEntity.getBody().getArtifacts();
                if(result.size() > 0) {
                    System.out.println("Found result: " + result.get(0).getBase64().length);
                    return result.get(0).getBase64();
                }
                return null;
            }

        }
        catch(Exception exc) {
            exc.printStackTrace();
        }


        System.out.println("Didn't find result");
        return null;


    }

}
