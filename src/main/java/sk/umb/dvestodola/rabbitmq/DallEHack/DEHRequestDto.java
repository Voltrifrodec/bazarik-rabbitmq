package sk.umb.dvestodola.rabbitmq.DallEHack;

import java.util.List;

import lombok.Data;

@Data
public class DEHRequestDto {
    
    private List<DEHRequestDtoItem> text_prompts;

    public DEHRequestDto() {}

    public DEHRequestDto(List<DEHRequestDtoItem> text_prompts) {
        this.text_prompts = text_prompts;
    }

    @Data
    public static class DEHRequestDtoItem {
    
        private String text;
    
        public DEHRequestDtoItem() {}
        
        public DEHRequestDtoItem(String text) {
            this.text = text;
        }
    
    }
}


