package com.example.jbornreceivemessages.controller;

import com.example.jbornreceivemessages.entity.Word;
import com.example.jbornreceivemessages.service.WordService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WordController {
    private final WordService service;
    private final ObjectMapper objectMapper;
    private static final String orderTopic = "${topic.name}";

    @PostMapping("word/receive")
    public ResponseEntity<Word> receiveWord(@RequestBody String str) {
        Word word = service.SaveWordInDataBase(str);
        return ResponseEntity.ok(word);
    }

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        String word = objectMapper.readValue(message, String.class);
        service.SaveWordInDataBase(word);
    }
}
