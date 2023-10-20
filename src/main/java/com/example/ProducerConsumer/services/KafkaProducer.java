package com.example.ProducerConsumer.services;

import com.example.ProducerConsumer.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KafkaProducer
{
    @Autowired
    private KafkaTemplate<String, Student> kafkaTemplate;

    public void sendStudent(List<Student> students)
    {
        for(Student student : students)
            kafkaTemplate.send("javaguides", student);
    }
}