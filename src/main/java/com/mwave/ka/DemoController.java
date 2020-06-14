package com.mwave.ka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class DemoController {

    @Autowired
    KafkaTemplate<String,Book> kafkaTemplate;

    @Value("${cloudkarafka.topic}")
    private String TOPIC;

    /*
    kafka-console-producer.sh --broker-list 10.0.1.9:9092 --topic NewTopic
    >{"bookName":"Vendas","isbn":"333-444-555"}
    */

    @PostMapping("/publish")
    public String publishKafka(@RequestBody Book book) {
        kafkaTemplate.send(TOPIC,UUID.randomUUID().toString(),book);
        return "Message in kafka";
    }

}
