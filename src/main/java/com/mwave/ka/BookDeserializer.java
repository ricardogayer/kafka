package com.mwave.ka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import java.io.IOException;

public class BookDeserializer implements Deserializer<Book> {

    @Override
    public Book deserialize(String topic, byte[] data) {

        Book book = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            book = mapper.readValue(data, Book.class);
        } catch (IOException e) {

        }

        return book;
    }

}