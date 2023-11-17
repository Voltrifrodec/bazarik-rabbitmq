package sk.umb.dvestodola.rabbitmq.OpenAI.persistence.entity;

public class Message {
    
    //? Premenné
    private String role;
    private String content;


    //? Konštruktor
    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }


    //? Getters, Setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
