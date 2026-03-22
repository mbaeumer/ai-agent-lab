package se.mbaeumer.aiagentlab.soccer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class DecisionTest {

    @Test
    public void testFromJson() {
        String json = "{\"action\":\"MOVE\",\"intensity\":0.8}";
        Decision decision = Decision.fromAgentResponse(json);
        assertNotNull(decision);
        //assert "MOVE".equals(decision.getAction());
        assertEquals(0.8, decision.getIntensity());
    }

}
