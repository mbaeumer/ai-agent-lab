package se.mbaeumer.aiagentlab.soccer.service;

import org.springframework.stereotype.Component;

import se.mbaeumer.aiagentlab.soccer.model.Game;

@Component
public class SimulationStateHolder {

    private volatile Game state = null;

    public Game get() {
        return state;
    }

    public void update(Game newState) {
        this.state = newState;
    }
}