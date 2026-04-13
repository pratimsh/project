package com.reactive.web_mono_flux_sample.service;

import com.reactive.web_mono_flux_sample.model.Message;
import com.reactive.web_mono_flux_sample.repository.MessageRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ChatService {
    private final MessageRepository repository;

    public ChatService(MessageRepository repository) {
        this.repository = repository;
    }

    public Mono<Message> saveMessage(Message message) {
        return repository.save(message);
    }

    public Flux<Message> streamMessages() {
        return repository.findAll().repeat();
    }
}

