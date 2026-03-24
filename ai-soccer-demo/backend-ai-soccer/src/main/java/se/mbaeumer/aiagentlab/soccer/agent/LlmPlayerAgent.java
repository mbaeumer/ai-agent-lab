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

        Decide the next action. Possible actions are RUN_TO_BALL,KICK_BALL or DRIBBLE
        Some rules:
        - There is no specific unit when it comes to distanceToBall, but you can use the distanceToBall as a reference. For example, if distanceToBall is 100, you are quite far from the ball, if it's 10 you are close to the ball.
        - The unit for distanceToGoal is meters. 
        - You can only KICK_BALL if you are close to the ball (distanceToBall < 25) and you are allowed to kick (isAllowedToKickBall is true).
        
        Return JSON:

        {
          "action": "<action>",
          "intensity": 0.0-1.0,
          "explanation": "short explanation of why you chose this action"
        }

        Game state:
        """ + perception.toJson();

        String response = model.generate(prompt);

        return response; //DecisionParser.parse(response);
    }

    

}