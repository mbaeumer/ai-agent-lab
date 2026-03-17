package se.mbaeumer.aiagentlab.soccer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

@Configuration
public class AiModelConfig {

    private final AiProviderProperties aiProviderProperties;
    private String provider;

    public AiModelConfig(AiProviderProperties aiProviderProperties) {
        this.aiProviderProperties = aiProviderProperties;
    }

    @Bean
    public ChatLanguageModel chatLanguageModel() {

        provider = aiProviderProperties.getProvider();

        if (provider == null) {
            throw new IllegalStateException("AI provider is not configured. Please set 'ai.provider' property.");
        }

        return switch (provider.toLowerCase()) {

            
            case "openai" -> OpenAiChatModel.builder()
                    .apiKey(aiProviderProperties.getOpenai().getApiKey())
                    .modelName(aiProviderProperties.getOpenai().getModel())
                    .temperature(1.0)
                    .build();

                    /*
            case "azure" -> AzureOpenAiChatModel.builder()
                    .apiKey(props.getAzure().getApiKey())
                    .endpoint(props.getAzure().getEndpoint())
                    .deploymentName(props.getAzure().getDeployment())
                    .temperature(0.2)
                    .build();
                */               
            case "local" -> OllamaChatModel.builder()
                    .baseUrl(aiProviderProperties.getLocal().getBaseUrl())
                    .modelName(aiProviderProperties.getLocal().getModel())
                    .build();

            default -> throw new IllegalStateException("Unknown AI provider: " + aiProviderProperties.getProvider());
        };
    }
}
