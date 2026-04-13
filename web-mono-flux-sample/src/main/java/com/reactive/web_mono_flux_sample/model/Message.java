package com.reactive.web_mono_flux_sample.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document
public class Message {
        @Id
        private String id;
        private String sender;
        private String content;
        private Instant timestamp = Instant.now();


}
