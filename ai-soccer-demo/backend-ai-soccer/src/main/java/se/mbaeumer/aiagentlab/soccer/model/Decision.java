package se.mbaeumer.aiagentlab.soccer.model;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Decision {

    private PlayerAction action;
    private double intensity;

    public PlayerAction getAction() {
        return action;
    }

    public void setAction(PlayerAction action) {
        this.action = action;
    }

    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    public static Decision fromAgentResponse(String response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(response, Decision.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;    
        }
    }
}