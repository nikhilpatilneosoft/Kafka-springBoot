package com.example.ProducerConsumer.services;

import com.example.ProducerConsumer.models.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer
{
    @Value("${group-id")
    private String myGroupId;
    @KafkaListener(topics = "javaguides", groupId = "1", containerFactory = "kafkaListenerContainerFactory")
    public void consume(Student student)
    {
        System.out.println(student.getName());
    }
}
