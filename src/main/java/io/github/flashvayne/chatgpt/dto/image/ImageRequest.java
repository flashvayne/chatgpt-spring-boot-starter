package io.github.flashvayne.chatgpt.dto.image;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ImageRequest is used to construct request body.
 * For descriptions of all fields, please refer to <a href="https://platform.openai.com/docs/api-reference/images/create">Create image</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageRequest {

    private String prompt;
    private Integer n;
    private String size;

    @JsonProperty("response_format")
    private String responseFormat;

    private String user;

}
