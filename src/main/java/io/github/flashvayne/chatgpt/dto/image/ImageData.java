package io.github.flashvayne.chatgpt.dto.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ImageData {
    private String url;

    @JsonProperty("b64_json")
    private String b64Json;
}
