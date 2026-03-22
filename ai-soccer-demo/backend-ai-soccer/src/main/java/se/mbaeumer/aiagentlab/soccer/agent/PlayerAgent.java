package se.mbaeumer.aiagentlab.soccer.agent;

import se.mbaeumer.aiagentlab.soccer.model.PlayerPerception;

public interface PlayerAgent {
    String decide(PlayerPerception perception);
}
