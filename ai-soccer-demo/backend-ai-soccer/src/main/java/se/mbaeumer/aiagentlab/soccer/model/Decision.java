package se.mbaeumer.aiagentlab.soccer.model;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Decision {

    private String action;
    private double intensity;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
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