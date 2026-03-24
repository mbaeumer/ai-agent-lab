package se.mbaeumer.aiagentlab.soccer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class DecisionTest {

    @Test
    public void testFromJson() {
        String json = "{\"action\":\"RUN_TO_BALL\",\"intensity\":0.8}";
        Decision decision = Decision.fromAgentResponse(json);
        assertNotNull(decision);
        assertEquals(PlayerAction.RUN_TO_BALL, decision.getAction());
        assertEquals(0.8, decision.getIntensity());
    }
}
