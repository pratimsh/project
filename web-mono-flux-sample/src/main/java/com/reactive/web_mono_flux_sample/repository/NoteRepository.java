package com.reactive.web_mono_flux_sample.repository;


import com.reactive.web_mono_flux_sample.model.Note;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface NoteRepository extends ReactiveMongoRepository<Note, String> {}

