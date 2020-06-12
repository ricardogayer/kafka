package com.mwave.ka;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(topics = "NewTopic", groupId = "group_id")
    public void consumer(@Payload Book book) {

        System.out.println("****************************************");
        System.out.println("Book Name: "+ book.getBookName());
        System.out.println("Book ISBN: "+ book.getIsbn());
        System.out.println("****************************************");
    }

}
