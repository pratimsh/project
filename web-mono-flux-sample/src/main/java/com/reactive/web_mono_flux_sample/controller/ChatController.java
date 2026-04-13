package com.reactive.web_mono_flux_sample.controller;

import com.reactive.web_mono_flux_sample.model.Message;
import com.reactive.web_mono_flux_sample.service.ChatService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/message")
    public Mono<Message> sendMessage(@RequestBody Message message) {
        return chatService.saveMessage(message);
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> streamMessages() {
        return chatService.streamMessages();
    }
}

