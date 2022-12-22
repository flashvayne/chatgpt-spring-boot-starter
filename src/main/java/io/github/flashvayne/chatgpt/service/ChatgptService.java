package io.github.flashvayne.chatgpt.service;

import io.github.flashvayne.chatgpt.dto.ChatRequest;
import io.github.flashvayne.chatgpt.dto.ChatResponse;

public interface ChatgptService {

    String sendMessage(String message);

    ChatResponse sendChatRequest(ChatRequest request);

}
