package com.example.ProducerConsumer;

import com.example.ProducerConsumer.controllers.KafkaProducerController;
import com.example.ProducerConsumer.models.Student;
import com.example.ProducerConsumer.services.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProducerConsumerApplication implements CommandLineRunner {

	@Autowired
	private KafkaProducer kafkaProducer;

	@Autowired
	private KafkaProducerController kafkaProducerController;

	public static void main(String[] args) {
		SpringApplication.run(ProducerConsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ready");

		List<Student> students = new ArrayList<>();

		Student s1 = Student.builder().id(1).name("Ross").build();
		students.add(s1);
		Student s2 = Student.builder().id(2).name("Jane").build();
		students.add(s2);
		Student s3 = Student.builder().id(3).name("jim").build();
		students.add(s3);
		Student s4 = Student.builder().id(4).name("Jill").build();
		students.add(s4);
		Student s5 = Student.builder().id(5).name("Doraemon").build();
		students.add(s5);
		Student s6 = Student.builder().id(6).name("Jenny").build();
		students.add(s6);
		Student s7 = Student.builder().id(7).name("Nikki").build();
		students.add(s7);
		Student s8 = Student.builder().id(8).name("Kunal").build();
		students.add(s8);
		Student s9 = Student.builder().id(9).name("Prajakta").build();
		students.add(s9);
		Student s10 = Student.builder().id(10).name("Noddy").build();
		students.add(s10);

		kafkaProducerController.storeAllStudnets(students);
	}
}
