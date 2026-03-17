package se.mbaeumer.aiagentlab.soccer.agent;

import org.springframework.stereotype.Component;

import dev.langchain4j.model.chat.ChatLanguageModel;

@Component
public class DummyAgent {

    private final ChatLanguageModel model;

    public DummyAgent(ChatLanguageModel model) {
        this.model = model;
    }

    public String ask(String question) {

        String prompt = """
        You are a helpful assistant.

        Answer the following question briefly:

        """ + question;

        return model.generate(prompt);
    }

    public String askForSoccerOption(){
        String prompt = """
        You are a soccer coach assistant. The team is playing a match and 
        you need to suggest the next move. The team is leading and there are 10 minutes left in the game. 
        The opponent is playing very offensively and has a strong attack.
        The options are: "attack", "defend", "counter-attack". 

        Based on the current situation, suggest one of these options.

        """;

        return model.generate(prompt);
    }
}