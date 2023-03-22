package io.github.flashvayne.chatgpt.dto.chat;

import io.github.flashvayne.chatgpt.dto.Usage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiChatResponse {
    private String id;
    private String object;
    private LocalDate created;
    private String model;
    private List<MultiResponseChoice> choices;
    private Usage usage;
}
