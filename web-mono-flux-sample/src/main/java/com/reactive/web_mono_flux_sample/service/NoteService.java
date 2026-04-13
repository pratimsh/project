package com.reactive.web_mono_flux_sample.service;

import com.reactive.web_mono_flux_sample.model.Note;
import com.reactive.web_mono_flux_sample.repository.NoteRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
public class NoteService {
    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public Mono<Note> updateNote(String id, Note note) {
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setTitle(note.getTitle());
                    existing.setContent(note.getContent());
                    existing.setLastUpdated(Instant.now());
                    return repository.save(existing);
                });
    }

    public Flux<Note> streamNoteUpdates(String id) {
        return repository.findById(id).flux().repeat();
    }

    public Flux<Note> getAllNotes() {
        return repository.findAll();
    }
}

