package io.github.flashvayne.chatgpt.service;

import io.github.flashvayne.chatgpt.dto.ChatRequest;
import io.github.flashvayne.chatgpt.dto.ChatResponse;
import io.github.flashvayne.chatgpt.dto.chat.MultiChatMessage;
import io.github.flashvayne.chatgpt.dto.chat.MultiChatRequest;
import io.github.flashvayne.chatgpt.dto.chat.MultiChatResponse;
import io.github.flashvayne.chatgpt.dto.image.ImageFormat;
import io.github.flashvayne.chatgpt.dto.image.ImageRequest;
import io.github.flashvayne.chatgpt.dto.image.ImageResponse;
import io.github.flashvayne.chatgpt.dto.image.ImageSize;

import java.util.List;

public interface ChatgptService {

    String sendMessage(String message);

    ChatResponse sendChatRequest(ChatRequest request);

    String multiChat(List<MultiChatMessage> messages);

    MultiChatResponse multiChatRequest(MultiChatRequest multiChatRequest);

    /**
     * @param prompt A text description of the desired image(s). The maximum length is 1000 characters.
     * @return generated image url
     */
    String imageGenerate(String prompt);

    /**
     * @param prompt A text description of the desired image(s). The maximum length is 1000 characters.
     * @param n      The number of images to generate. Must be between 1 and 10.
     * @param size   The size of the generated images. Must be one of ImageFormat.SMALL("256x256"), ImageFormat.MEDIUM("512x512"), ImageFormat.LARGE("1024x1024").
     * @param format The format in which the generated images are returned. Must be one of ImageFormat.URL("url"), ImageFormat.BASE64("b64_json").
     * @return image url/base64 list
     */
    List<String> imageGenerate(String prompt, Integer n, ImageSize size, ImageFormat format);

    ImageResponse imageGenerateRequest(ImageRequest imageRequest);

}
