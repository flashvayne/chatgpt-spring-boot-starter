package io.github.flashvayne.chatgpt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Choice {
    private String text;
    private Integer index;
    private String logprobs;

    @JsonProperty("finish_reason")
    private String finishReason;

}
