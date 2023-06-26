package com.example.jbornreceivemessages.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Consumer {
    private final WordService wordService;

    @KafkaListener(id = "consumer-1", topics = "${kafka.topics.topic}", containerFactory = "kafkaListenerContainerFactory")
    public void handle(@Payload String word) {
        readMessage(word);
    }

    public void readMessage(String word) {
        log.info("Прочитано сообщение: {}", word);
        wordService.SaveWordInDataBase(word);
    }
}
