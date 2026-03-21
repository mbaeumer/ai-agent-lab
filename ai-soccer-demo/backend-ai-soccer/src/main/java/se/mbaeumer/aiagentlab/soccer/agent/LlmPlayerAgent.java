package se.mbaeumer.aiagentlab.soccer.agent;

import org.springframework.stereotype.Component;

import dev.langchain4j.model.chat.ChatLanguageModel;
import se.mbaeumer.aiagentlab.soccer.model.Decision;
import se.mbaeumer.aiagentlab.soccer.model.PlayerPerception;

@Component
public class LlmPlayerAgent implements PlayerAgent {

    private final ChatLanguageModel model;

    public LlmPlayerAgent(ChatLanguageModel model) {
        this.model = model;
    }

    @Override
    public Decision decide(PlayerPerception perception) {

        String prompt = """
        You are a soccer player in a simulation.

        Decide the next action.

        Return JSON:

        {
          "action": "MOVE | PASS | SHOOT | HOLD",
          "targetPlayerId": "optional",
          "intensity": 0.0-1.0
        }

        Game state:
        """ + perception.toString();

        String response = model.generate(prompt);

        return null; //DecisionParser.parse(response);
    }

}