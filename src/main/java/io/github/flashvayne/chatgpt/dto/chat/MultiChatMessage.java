package io.github.flashvayne.chatgpt.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiChatMessage {
    private String role;
    private String content;
}
