package se.mbaeumer.aiagentlab.soccer.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GameLoop {

    private final SimulationEngine engine;

    public GameLoop(SimulationEngine engine) {
        this.engine = engine;
    }

    @Scheduled(fixedRate = 50) // 20 ticks per second
    public void tick() {
        engine.tick();
    }
}