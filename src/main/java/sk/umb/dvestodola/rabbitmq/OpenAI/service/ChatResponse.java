package sk.umb.dvestodola.rabbitmq.OpenAI.service;

import java.util.List;

import sk.umb.dvestodola.rabbitmq.OpenAI.persistence.entity.Message;

public class ChatResponse {
    
    //? Premenné
    private List<Choice> choices;


    //? Konštruktor
    // public ChatResponse() {}


    //? Getters, Setters
    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }


    // TODO: Inam? Je ale statická...
    //? Statická trieda Choice (možnosť)
    public static class Choice {

        //? Premenné
        private int index;
        private Message message;


        //? Konštruktor
        public Choice(int index, Message message) {
            this.index = index;
            this.message = message;
        }


        //? Getters, Setters
        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }


    }

}
