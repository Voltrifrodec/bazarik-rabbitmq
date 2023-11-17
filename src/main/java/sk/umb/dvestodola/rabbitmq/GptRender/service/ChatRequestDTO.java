package sk.umb.dvestodola.rabbitmq.GptRender.service;

import java.util.ArrayList;
import java.util.List;

import sk.umb.dvestodola.rabbitmq.GptRender.persistence.entity.Message;

public class ChatRequestDTO {

    private String model;
    private List<Message> messages;
    private int n;
    private double temperature;

    public ChatRequestDTO(String model, String prompt) {

        this.model = model;
        this.messages = new ArrayList<Message>();
        this.messages.add(new Message("user", prompt));

    }

    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    
}
