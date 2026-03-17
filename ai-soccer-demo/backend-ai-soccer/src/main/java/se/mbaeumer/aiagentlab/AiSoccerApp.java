package se.mbaeumer.aiagentlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(se.mbaeumer.aiagentlab.soccer.config.AiProviderProperties.class)
public class AiSoccerApp {
    public static void main(String[] args) {
    SpringApplication.run(AiSoccerApp.class, args);
  }

}
