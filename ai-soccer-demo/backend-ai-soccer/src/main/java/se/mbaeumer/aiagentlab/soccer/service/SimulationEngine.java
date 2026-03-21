package se.mbaeumer.aiagentlab.soccer.service;

import org.springframework.stereotype.Component;

import se.mbaeumer.aiagentlab.soccer.agent.PlayerAgent;
import se.mbaeumer.aiagentlab.soccer.model.Game;
import se.mbaeumer.aiagentlab.soccer.model.Player;

@Component
public class SimulationEngine {

  private final SimulationStateHolder stateHolder;
  private final PlayerAgent agent;

  private int tickCounter = 0;

  public SimulationEngine(SimulationStateHolder stateHolder, PlayerAgent agent) {
    this.stateHolder = stateHolder;
    this.agent = agent;
  }

  public void tick() {

    Game state = stateHolder.get();

    // 1. Occasionally ask agents (not every tick!)
    if (tickCounter % 20 == 0) { // once per second (if 50ms tick)
      updateAgentDecisions(state);
    }

    // TODO:
    // TODO: 2. Apply physics every tick
    //updatePhysics(state);

    // 3. Store updated state
    stateHolder.update(state);

    tickCounter++;
  }

  private void updateAgentDecisions(Game state) {

    Player player = state.getPlayer();

    // build perception
    // let the agent decide on an action
    // apply the action to the player (update player state)
    

    // TODO: Later, we will have multiple players and teams, so we need to loop through all players here
    /* 
    for (Player player : state.getPlayers()) {

      PlayerPerception perception = perceptionBuilder.build(player, state);

      Decision decision = agent.decide(perception);

      player.setDecision(decision);
    }
    */
  }
}
