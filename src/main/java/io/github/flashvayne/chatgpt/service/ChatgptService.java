package io.github.flashvayne.chatgpt.service;

import io.github.flashvayne.chatgpt.dto.ChatRequest;
import io.github.flashvayne.chatgpt.dto.ChatResponse;
import io.github.flashvayne.chatgpt.dto.chat.MultiChatMessage;
import io.github.flashvayne.chatgpt.dto.chat.MultiChatRequest;
import io.github.flashvayne.chatgpt.dto.chat.MultiChatResponse;

import java.util.List;

public interface ChatgptService {

    String sendMessage(String message);

    ChatResponse sendChatRequest(ChatRequest request);

    String multiChat(List<MultiChatMessage> messages);

    MultiChatResponse multiChatRequest(MultiChatRequest multiChatRequest);
}
