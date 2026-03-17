package se.mbaeumer.aiagentlab.soccer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ai")
public class AiProviderProperties {

    private String provider; // openai | azure | local

    private OpenAi openai = new OpenAi();
    private Azure azure = new Azure();
    private Local local = new Local();

     public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    // ---- Nested configs ----

    public OpenAi getOpenai() {
        return openai;
    }

    public Azure getAzure() {
        return azure;
    }

    public Local getLocal() {
        return local;
    }

    public static class OpenAi {
        private String apiKey;
        private String model;
        public String getApiKey() {
            return apiKey;
        }
        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }
        public String getModel() {
            return model;
        }
        public void setModel(String model) {
            this.model = model;
        }
    }

    public static class Azure {
        private String apiKey;
        private String endpoint;
        private String deployment;
        public String getApiKey() {
            return apiKey;
        }
        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }
        public String getEndpoint() {
            return endpoint;
        }
        public void setEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }
        public String getDeployment() {
            return deployment;
        }
        public void setDeployment(String deployment) {
            this.deployment = deployment;
        }
    }

    public static class Local {
        private String baseUrl = "http://localhost:11434";
        private String model = "llama3";
        public String getBaseUrl() {
            return baseUrl;
        }
        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }
        public String getModel() {
            return model;
        }
        public void setModel(String model) {
            this.model = model;
        }
    }

    // getters/setters
}
