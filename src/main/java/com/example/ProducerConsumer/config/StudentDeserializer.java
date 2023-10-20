package com.example.ProducerConsumer.config;

import com.example.ProducerConsumer.models.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class StudentDeserializer implements Deserializer<Student> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No additional configuration needed
    }

    @Override
    public Student deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        Student student = null;
        try {
            student = mapper.readValue(data, Student.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void close() {
        // No resources to release
    }
}
