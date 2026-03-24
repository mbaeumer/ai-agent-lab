package se.mbaeumer.aiagentlab.soccer.service;

import org.springframework.stereotype.Component;

import se.mbaeumer.aiagentlab.soccer.agent.PlayerAgent;
import se.mbaeumer.aiagentlab.soccer.model.Ball;
import se.mbaeumer.aiagentlab.soccer.model.Direction;
import se.mbaeumer.aiagentlab.soccer.model.Game;
import se.mbaeumer.aiagentlab.soccer.model.Goal;
import se.mbaeumer.aiagentlab.soccer.model.Player;
import se.mbaeumer.aiagentlab.soccer.model.PlayerPerception;

@Component
public class SimulationEngine {

  private static final System.Logger logger = System.getLogger(SimulationEngine.class.getName());

  private final SimulationStateHolder stateHolder;
  private final PlayerAgent agent;

  private int tickCounter = 0;

  public SimulationEngine(SimulationStateHolder stateHolder, PlayerAgent agent) {
    this.stateHolder = stateHolder;
    this.agent = agent;
  }

  public void tick() {

    Game state = stateHolder.get();
    if (state == null) {
      return;
    }

    // 1. Occasionally ask agents (not every tick!)
    if (tickCounter % 20 == 0) { // once per second (if 50ms tick)
      updateAgentDecisions(state);
    }

    // TODO:
    // TODO: 2. Apply physics every tick
    // updatePhysics(state);

    // 3. Store updated state
    stateHolder.update(state);

    tickCounter++;
  }

  private void updateAgentDecisions(Game state) {

    Player player = state.getPlayer();
    Ball ball = state.getBall();
    Goal goal = state.getGoal();
    double distanceToBall =
        calculateDistance(
            player.getPosition().x(),
            player.getPosition().y(),
            ball.getPosition().x(),
            ball.getPosition().y());
    double distanceToGoal =
        calculateDistance(
            player.getPosition().x(),
            player.getPosition().y(),
            goal.getPosition().x(),
            goal.getPosition().y());
    boolean hasBallControl = distanceToBall < 25; // Example threshold for ball control

    PlayerPerception perception = new PlayerPerception();
    perception.setDistanceToBall(distanceToBall);
    perception.setDistanceToGoal(distanceToGoal);
    perception.setHasBall(hasBallControl);

    String response = agent.decide(perception);

    logger.log(System.Logger.Level.INFO, response);
    //Decision decision = Decision.fromAgentResponse(response);

    Direction direction = Direction.fromPositions(player.getPosition(), ball.getPosition()).getNormalized();
    direction = direction.getNormalized().scale(distanceToBall * 0.3);
    
    player.move(direction);
    state.setPlayer(player);
    stateHolder.update(state);
    // build perception
    // let the agent decide on an action
    // apply the action to the player (update player state)

    // TODO: Later, we will have multiple players and teams, so we need to loop through all players
    // here
    /*
    for (Player player : state.getPlayers()) {

      PlayerPerception perception = perceptionBuilder.build(player, state);

      Decision decision = agent.decide(perception);

      player.setDecision(decision);
    }
    */
  }

  private double calculateDistance(int x1, int y1, int x2, int y2) {
    double dx = x2 - x1;
    double dy = y2 - y1;
    return Math.sqrt(dx * dx + dy * dy);
  }
}
