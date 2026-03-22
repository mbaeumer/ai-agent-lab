package se.mbaeumer.aiagentlab.soccer.agent;

import org.springframework.stereotype.Component;

import dev.langchain4j.model.chat.ChatLanguageModel;
import se.mbaeumer.aiagentlab.soccer.model.PlayerPerception;

@Component
public class LlmPlayerAgent implements PlayerAgent {

    private final ChatLanguageModel model;

    public LlmPlayerAgent(ChatLanguageModel model) {
        this.model = model;
    }

    @Override
    public String decide(PlayerPerception perception) {

        String prompt = """
        You are a soccer player in a simulation.

        Decide the next action.

        Return JSON:

        {
          "action": "RUN_TO_BALL|KICK_BALL|DRIBBLE |PASS_BALL",
          "intensity": 0.0-1.0
        }

        Game state:
        """ + perception.toJson();

        String response = model.generate(prompt);

        return response; //DecisionParser.parse(response);
    }

    

}