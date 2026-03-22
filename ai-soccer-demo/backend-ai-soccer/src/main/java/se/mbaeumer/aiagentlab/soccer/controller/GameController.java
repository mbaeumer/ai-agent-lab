package se.mbaeumer.aiagentlab.soccer.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.mbaeumer.aiagentlab.soccer.model.Game;
import se.mbaeumer.aiagentlab.soccer.service.GameStateService;

@CrossOrigin(origins = "*") // Allow CORS for all origins (for development purposes)
@RestController
@RequestMapping("/api/game")
public class GameController {
  private final GameStateService gameStateService;

  public GameController(GameStateService gameStateService) {
    this.gameStateService = gameStateService;
  }

  @GetMapping("/init")
  public Game initGame() {
    return gameStateService.initGame();
  }

  @PostMapping("/start")
  public void startGame() {
    gameStateService.startGame();
  }
}
