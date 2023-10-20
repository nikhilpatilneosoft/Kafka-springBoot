package com.example.ProducerConsumer.controllers;

import com.example.ProducerConsumer.models.Student;
import com.example.ProducerConsumer.services.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    private List<Student> students;
    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send1")
    public ResponseEntity<String> send1() {
        kafkaProducer.sendStudent(students);
        return ResponseEntity.ok().build();
    }

    public void storeAllStudnets(List<Student> students) {
        this.students = students;
    }
}
