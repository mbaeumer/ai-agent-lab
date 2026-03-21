package se.mbaeumer.aiagentlab.soccer.agent;

import se.mbaeumer.aiagentlab.soccer.model.Decision;
import se.mbaeumer.aiagentlab.soccer.model.PlayerPerception;

public interface PlayerAgent {
    Decision decide(PlayerPerception perception);
}
