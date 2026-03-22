package se.mbaeumer.aiagentlab.soccer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GameLoop {

    private static final Logger log = LoggerFactory.getLogger(GameLoop.class);

    private final SimulationEngine engine;

    public GameLoop(SimulationEngine engine) {
        this.engine = engine;
    }

    @Scheduled(fixedRate = 50) // 20 ticks per second
    public void tick() {
        engine.tick();
    }
}