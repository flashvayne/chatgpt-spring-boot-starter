package io.github.flashvayne.chatgpt.dto.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageResponse {
    private Date created;

    private List<ImageData> data;

}
