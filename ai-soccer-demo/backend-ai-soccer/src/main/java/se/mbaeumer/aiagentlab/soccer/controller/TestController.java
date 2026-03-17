package se.mbaeumer.aiagentlab.soccer.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.mbaeumer.aiagentlab.soccer.agent.DummyAgent;

@CrossOrigin(origins = "*") // Allow CORS for all origins (for development purposes)
@RestController
@RequestMapping("/api/test")
public class TestController {
  private final DummyAgent agent;

  public TestController(DummyAgent agent) {
    this.agent = agent;
  }

  @GetMapping("/hello")
  public String hello() {
    return "Hello from AI Soccer Demo!";
  }

  @GetMapping("/ai/hello")
  public String test() {
    return agent.ask("Say hello");
  }

  @GetMapping("/ai/soccer-option")
  public String testSoccerOption() {
    return agent.askForSoccerOption();
  }

  @GetMapping("/move")
  public Map<String, Integer> move() {
    return Map.of(
        "dx", 10,
        "dy", 0);
  }
}
