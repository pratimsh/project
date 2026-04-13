package com.reactive.web_mono_flux_sample.controller;

import com.reactive.web_mono_flux_sample.model.Note;
import com.reactive.web_mono_flux_sample.service.NoteService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/notes")
public class NotesController {
    private final NoteService notesService;

    public NotesController(NoteService notesService) {
        this.notesService = notesService;
    }

    @PutMapping("/{id}")
    public Mono<Note> updateNote(@PathVariable String id, @RequestBody Note note) {
        return notesService.updateNote(id, note);
    }

    @GetMapping(value = "/{id}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Note> streamNote(@PathVariable String id) {
        return notesService.streamNoteUpdates(id);
    }

    @GetMapping
    public Flux<Note> listNotes() {
        return notesService.getAllNotes();
    }
}


