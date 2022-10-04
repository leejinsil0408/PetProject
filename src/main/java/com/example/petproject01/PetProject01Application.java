package com.example.petproject01;

import com.example.petproject01.repository.NoticeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class PetProject01Application {

	public static void main(String[] args) {
		SpringApplication.run(PetProject01Application.class, args);
	}

}
