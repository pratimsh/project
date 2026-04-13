package com.reactive.web_mono_flux_sample.repository;

import com.reactive.web_mono_flux_sample.model.Message;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MessageRepository extends ReactiveMongoRepository<Message, String> {}


