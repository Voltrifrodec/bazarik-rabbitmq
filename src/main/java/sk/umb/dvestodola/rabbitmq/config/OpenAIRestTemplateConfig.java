package sk.umb.dvestodola.rabbitmq.config;

import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAIRestTemplateConfig {
    
    // TODO: Nastaviť custom property v application.properties
    // @Value("${openai.api.key}")
    private String openaiApiKey = "no";

    @Bean
    @Qualifier("openaiRestTemplate")
    public RestTemplate openaiRestTemplate() {
        
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {

            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
            return execution.execute(request, body);

        });

        return restTemplate;

    }

}
