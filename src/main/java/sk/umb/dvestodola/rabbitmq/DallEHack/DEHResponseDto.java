package sk.umb.dvestodola.rabbitmq.DallEHack;

import java.util.List;

import lombok.Data;

@Data
public class DEHResponseDto {
    
    private List<DEHResponseDtoItem> artifacts;

    public DEHResponseDto() {}

    public DEHResponseDto(List<DEHResponseDtoItem> artifacts) {
        this.artifacts = artifacts;
    }

    @Data
    public static class DEHResponseDtoItem {
    
        private byte[] base64;
    
        public DEHResponseDtoItem() {}
        
        public DEHResponseDtoItem(byte[] base64) {
            this.base64 = base64;
        }
    
    }
}


