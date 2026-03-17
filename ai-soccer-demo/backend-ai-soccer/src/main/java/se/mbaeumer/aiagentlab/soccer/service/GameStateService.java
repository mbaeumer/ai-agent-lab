package se.mbaeumer.aiagentlab.soccer.service;

import org.springframework.stereotype.Service;

import se.mbaeumer.aiagentlab.soccer.model.Ball;
import se.mbaeumer.aiagentlab.soccer.model.Player;
import se.mbaeumer.aiagentlab.soccer.model.PlayerRole;
import se.mbaeumer.aiagentlab.soccer.model.Position;

@Service
public class GameStateService {

  public void initGame() {
    // Initialize game state, players, ball position, etc.
    Position ballStartPosition = new Position(50, 50);
    Ball ball = new Ball(ballStartPosition);

    Position player1StartPosition = new Position(10, 50);
    Player player1 = new Player("Player 1", PlayerRole.FORWARD, player1StartPosition);
  }

  public static double squaredDistance(double x1, double y1, double x2, double y2) {
    double dx = x2 - x1;
    double dy = y2 - y1;
    return dx * dx + dy * dy;
  }
}
