package se.mbaeumer.aiagentlab.soccer.service;

import org.springframework.stereotype.Service;

import se.mbaeumer.aiagentlab.soccer.model.Ball;
import se.mbaeumer.aiagentlab.soccer.model.Game;
import se.mbaeumer.aiagentlab.soccer.model.GameStatus;
import se.mbaeumer.aiagentlab.soccer.model.Goal;
import se.mbaeumer.aiagentlab.soccer.model.Pitch;
import se.mbaeumer.aiagentlab.soccer.model.Player;
import se.mbaeumer.aiagentlab.soccer.model.PlayerRole;
import se.mbaeumer.aiagentlab.soccer.model.Position;

@Service
public class GameStateService {

  private final SimulationStateHolder stateHolder;

  public GameStateService(SimulationStateHolder stateHolder) {
    this.stateHolder = stateHolder;
  }

  public Game initGame() {
    // Initialize game state, players, ball position, etc.
    Position ballStartPosition = new Position(250, 280);
    Ball ball = new Ball(ballStartPosition);

    Position player1StartPosition = new Position(350, 400);
    Player player1 = new Player("Player 1", PlayerRole.FORWARD, player1StartPosition);

    Pitch pitch = new Pitch(800, 800);
    Goal goal = new Goal(new Position(400, 0));

    Game game = new Game(pitch, player1, ball, goal, GameStatus.NOT_STARTED);

    stateHolder.update(game);
    return game;
  }

  public void startGame(){
    Game game = stateHolder.get();
    if (game != null) {
      game.setGameStatus(GameStatus.IN_PROGRESS);
      stateHolder.update(game);
    }
  }

  public Game getCurrentState() {
    return stateHolder.get();
  }

  public static double squaredDistance(double x1, double y1, double x2, double y2) {
    double dx = x2 - x1;
    double dy = y2 - y1;
    return dx * dx + dy * dy;
  }

  public static double calculaeDistance(int x1, int y1, int x2, int y2) {
    double dx = x2 - x1;
    double dy = y2 - y1;
    return Math.sqrt(dx * dx + dy * dy);
  }
}
