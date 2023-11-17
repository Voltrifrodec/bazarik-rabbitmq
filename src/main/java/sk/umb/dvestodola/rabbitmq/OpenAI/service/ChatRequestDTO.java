package sk.umb.dvestodola.rabbitmq.OpenAI.service;

import java.util.ArrayList;
import java.util.List;

import sk.umb.dvestodola.rabbitmq.OpenAI.persistence.entity.Message;

public class ChatRequestDTO {
    
    //? Premenné
    private String model;                                           //  Model, ktorý sa má použiť pri promptovaní. Zoznam modelov: https://platform.openai.com/docs/models/overview
    private List<Message> messages;                                 //  Správa, ktorú odosielame. Obsahuje rolu a text.
    private int n = 1;                                              //  Počet odpovedí.
    private double temperature = 0.7;                               //  Balancovanie výsledku medzi kreativitou a súdržnosťou, hodnota medzi 0 a 1.
    private int maxTokens;                                          //  Maximálny počet tokenov, default hodnota je nekonečno.


    //? Konštruktor
    public ChatRequestDTO(String prompt) {
        
        this.model = "gpt-3.5-turbo";
        this.messages = new ArrayList<Message>();

        this.messages.add(new Message("user",
              "\nWrite a description for the text written in brackets, such as ${Zbierka maľovaných váz} or ${Kniha 'Moby Dick' do vrecka}. Your response cannot contain confirming sentences, just the generated description for the text. Your response must be in Slovak. Occasionally, add a typo or skip a letter in the word. Your respondent is an average Slovak who you address formally, rarely informally. Do not write the original name in brackets. Skip one line and write in the state of the object you are describing (new, old, in good state, etc)."
            + "\nText: ${" + prompt + "}"
            + "\n--temperature: " + this.temperature
            + "\n--n: " + this.n
        ));

    }

    public ChatRequestDTO(String model, String prompt) {

        this.model = prompt;
        this.messages = new ArrayList<Message>();

        this.messages.add(new Message("user",
              "\nWrite a description for the text written in brackets, such as ${Zbierka maľovaných váz} or ${Kniha 'Moby Dick' do vrecka}. Your response cannot contain confirming sentences, just the generated description for the text. Your response must be in Slovak. Occasionally, add a typo or skip a letter in the word. Your respondent is an average Slovak who you address formally, rarely informally. Do not write the original name in brackets. Skip one line and write in the state of the object you are describing (new, old, in good state, etc)."
            + "\nText: ${" + prompt + "}"
            + "\n--temperature: " + this.temperature
            + "\n--n: " + this.n
        ));
        
    }


    //? Getters, Setters
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

    public int getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
    }

}
