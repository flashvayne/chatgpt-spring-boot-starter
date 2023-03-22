package io.github.flashvayne.chatgpt.dto.chat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * MultiChatRequest is used to construct request body.
 * For descriptions of all fields, please refer to <a href="https://platform.openai.com/docs/api-reference/chat/create">Create chat completion</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MultiChatRequest {
    private String model;

    private List<MultiChatMessage> messages;

    /**
     * The maximum number of tokens to generate in the completion.
     * The token count of your prompt plus max_tokens cannot exceed the model's context length.
     * Most models have a context length of 2048 tokens (except for the newest models, which support 4096).
     */
    @JsonProperty("max_tokens")
    private Integer maxTokens;

    private Double temperature;

    @JsonProperty("top_p")
    private Double topP;

    private Integer n;

    private Boolean stream;

    private String stop;

    @JsonProperty("presence_penalty")
    private Double presencePenalty;

    @JsonProperty("frequency_penalty")
    private Double frequencyPenalty;

    @JsonProperty("logit_bias")
    private Map<String, Integer> logitBias;

    private String user;

    public MultiChatRequest(String model, List<MultiChatMessage> messages, Integer maxTokens, Double temperature, Double topP) {
        this.model = model;
        this.messages = messages;
        this.maxTokens = maxTokens;
        this.temperature = temperature;
        this.topP = topP;
    }

}
