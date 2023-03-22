package io.github.flashvayne.chatgpt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * ChatRequest is used to construct request body.
 * For descriptions of all fields, please refer to <a href="https://platform.openai.com/docs/api-reference/completions/create">Create completion</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatRequest {

    private String model;

    private String prompt;

    @JsonProperty("max_tokens")
    private Integer maxTokens;

    private Double temperature;

    @JsonProperty("top_p")
    private Double topP;

    private String suffix;

    private Integer n;

    private Boolean stream;

    private Integer logprobs;

    private Boolean echo;

    private String stop;

    @JsonProperty("presence_penalty")
    private Double presencePenalty;

    @JsonProperty("frequency_penalty")
    private Double frequencyPenalty;

    @JsonProperty("best_of")
    private Integer bestOf;

    @JsonProperty("logit_bias")
    private Map<String, Integer> logitBias;

    private String user;

    public ChatRequest(String model, String prompt, Integer maxTokens, Double temperature, Double topP) {
        this.model = model;
        this.prompt = prompt;
        this.maxTokens = maxTokens;
        this.temperature = temperature;
        this.topP = topP;
    }

}
