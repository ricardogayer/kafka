package com.mwave.ka;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@EnableKafka
@Component
public class Consumer {

    /*
    kafka-console-consumer.sh --bootstrap-server 10.0.1.9:9092 --topic NewTopic --from-beginning --group group_id
     */

    @KafkaListener(topics = "#{'${cloudkarafka.topic}'}", groupId = "#{'${spring.kafka.consumer.group-id}'}")
    public void consumer(@Payload Book book) {

        System.out.println("****************************************");
        System.out.println("Book Name: "+ book.getBookName());
        System.out.println("Book ISBN: "+ book.getIsbn());
        System.out.println("****************************************");
    }

}
