package io.github.flashvayne.chatgpt.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "chatgpt")
public class ChatgptProperties {

    private String apiKey = "";

    private String url = "https://api.openai.com/v1/completions";

    private String model = "text-davinci-003";

    private Integer maxTokens = 500;

    private Double temperature = 1.0;

    private Double topP = 1.0;

    private MultiChatProperties multi;

    private ImageProperties image;

    public ChatgptProperties() {
        this.multi = new MultiChatProperties();
        this.image = new ImageProperties();
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getTopP() {
        return topP;
    }

    public void setTopP(Double topP) {
        this.topP = topP;
    }

    public MultiChatProperties getMulti() {
        return multi;
    }

    public void setMulti(MultiChatProperties multi) {
        this.multi = multi;
    }

    public ImageProperties getImage() {
        return image;
    }

    public void setImage(ImageProperties image) {
        this.image = image;
    }
}
