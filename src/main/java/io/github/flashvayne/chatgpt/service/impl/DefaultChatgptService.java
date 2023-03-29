package io.github.flashvayne.chatgpt.service.impl;

import io.github.flashvayne.chatgpt.dto.ChatRequest;
import io.github.flashvayne.chatgpt.dto.chat.MultiChatMessage;
import io.github.flashvayne.chatgpt.dto.chat.MultiChatRequest;
import io.github.flashvayne.chatgpt.dto.chat.MultiChatResponse;
import io.github.flashvayne.chatgpt.dto.image.*;
import io.github.flashvayne.chatgpt.exception.ChatgptException;
import io.github.flashvayne.chatgpt.property.ChatgptProperties;
import io.github.flashvayne.chatgpt.dto.ChatResponse;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class DefaultChatgptService implements ChatgptService {

    protected final ChatgptProperties chatgptProperties;

    private final String AUTHORIZATION;

    private final RestTemplate restTemplate = new RestTemplate();

    public DefaultChatgptService(ChatgptProperties chatgptProperties) {
        this.chatgptProperties = chatgptProperties;
        AUTHORIZATION = "Bearer " + chatgptProperties.getApiKey();
    }

    @Override
    public String sendMessage(String message) {
        ChatRequest chatRequest = new ChatRequest(chatgptProperties.getModel(), message, chatgptProperties.getMaxTokens(), chatgptProperties.getTemperature(), chatgptProperties.getTopP());
        ChatResponse chatResponse = this.getResponse(this.buildHttpEntity(chatRequest), ChatResponse.class, chatgptProperties.getUrl());
        try {
            return chatResponse.getChoices().get(0).getText();
        } catch (Exception e) {
            log.error("parse chatgpt message error", e);
            throw e;
        }
    }

    @Override
    public ChatResponse sendChatRequest(ChatRequest chatRequest) {
        return this.getResponse(this.buildHttpEntity(chatRequest), ChatResponse.class, chatgptProperties.getUrl());
    }

    @Override
    public String multiChat(List<MultiChatMessage> messages) {
        MultiChatRequest multiChatRequest = new MultiChatRequest(chatgptProperties.getMulti().getModel(), messages, chatgptProperties.getMulti().getMaxTokens(), chatgptProperties.getMulti().getTemperature(), chatgptProperties.getMulti().getTopP());
        MultiChatResponse multiChatResponse = this.getResponse(this.buildHttpEntity(multiChatRequest), MultiChatResponse.class, chatgptProperties.getMulti().getUrl());
        try {
            return multiChatResponse.getChoices().get(0).getMessage().getContent();
        } catch (Exception e) {
            log.error("parse chatgpt message error", e);
            throw e;
        }
    }

    @Override
    public MultiChatResponse multiChatRequest(MultiChatRequest multiChatRequest) {
        return this.getResponse(this.buildHttpEntity(multiChatRequest), MultiChatResponse.class, chatgptProperties.getMulti().getUrl());
    }

    @Override
    public String imageGenerate(String prompt) {
        ImageRequest imageRequest = new ImageRequest(prompt, null, null, null, null);
        ImageResponse imageResponse = this.getResponse(this.buildHttpEntity(imageRequest), ImageResponse.class, chatgptProperties.getImage().getUrl());
        try {
            return imageResponse.getData().get(0).getUrl();
        } catch (Exception e) {
            log.error("parse image url error", e);
            throw e;
        }
    }

    @Override
    public List<String> imageGenerate(String prompt, Integer n, ImageSize size, ImageFormat format) {
        ImageRequest imageRequest = new ImageRequest(prompt, n, size.getSize(), format.getFormat(), null);
        ImageResponse imageResponse = this.getResponse(this.buildHttpEntity(imageRequest), ImageResponse.class, chatgptProperties.getImage().getUrl());
        try {
            List<String> list = new ArrayList<>();
            imageResponse.getData().forEach(imageData -> {
                if (format.equals(ImageFormat.URL)) {
                    list.add(imageData.getUrl());
                } else {
                    list.add(imageData.getB64Json());
                }
            });
            return list;
        } catch (Exception e) {
            log.error("parse image url error", e);
            throw e;
        }
    }

    @Override
    public ImageResponse imageGenerateRequest(ImageRequest imageRequest) {
        return this.getResponse(this.buildHttpEntity(imageRequest), ImageResponse.class, chatgptProperties.getImage().getUrl());
    }

    protected <T> HttpEntity<?> buildHttpEntity(T request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        headers.add("Authorization", AUTHORIZATION);
        return new HttpEntity<>(request, headers);
    }

    protected <T> T getResponse(HttpEntity<?> httpEntity, Class<T> responseType, String url) {
        log.info("request url: {}, httpEntity: {}", url, httpEntity);
        ResponseEntity<T> responseEntity = restTemplate.postForEntity(url, httpEntity, responseType);
        if (responseEntity.getStatusCodeValue() != HttpStatus.OK.value()) {
            log.error("error response status: {}", responseEntity);
            throw new ChatgptException("error response status :" + responseEntity.getStatusCodeValue());
        } else {
            log.info("response: {}", responseEntity);
        }
        return responseEntity.getBody();
    }

}
