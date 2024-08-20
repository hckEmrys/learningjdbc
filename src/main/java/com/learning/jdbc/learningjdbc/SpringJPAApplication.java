package com.learning.jdbc.learningjdbc;

import com.learning.jdbc.learningjdbc.data.Person;
import com.learning.jdbc.learningjdbc.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Date;


@SpringBootApplication
public class SpringJPAApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(SpringJPAApplication.class);

	@Autowired
	private PersonJpaRepository personJpaRepository;



	public static void main(String[] args) {
		SpringApplication.run(SpringJPAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	logger.info("Logging the person found for id {}",personJpaRepository.findById(10001).toString());
	logger.info("Creating a row");
	personJpaRepository.insertPerson(new Person("Arun","new York", new Date()));
	logger.info("Updating {}",personJpaRepository.update(new Person(10001,"Arun","SSPN",new Date())));
	logger.info("Repo delete by id for 1");
	logger.info("Find all {}", personJpaRepository.findAll().toString());
	}
}
