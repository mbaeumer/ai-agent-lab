package se.mbaeumer.aiagentlab.soccer.service;

import org.junit.jupiter.api.Test;

import se.mbaeumer.aiagentlab.soccer.model.Position;

public class GameServiceServiceTest {

  @Test
  public void testDistance() {
    Position ballStartPosition = new Position(50, 50);
    Position player1StartPosition = new Position(400, 400);

    double distance =
        GameStateService.calculaeDistance(
            ballStartPosition.x(),
            ballStartPosition.y(),
            player1StartPosition.x(),
            player1StartPosition.y());
    System.out.println("Distance: " + distance);
  }
}
