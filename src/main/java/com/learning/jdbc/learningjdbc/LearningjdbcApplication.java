package com.learning.jdbc.learningjdbc;

import com.learning.jdbc.learningjdbc.dao.PersonJDBCDao;
import com.learning.jdbc.learningjdbc.data.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class LearningjdbcApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(LearningjdbcApplication.class);

	@Autowired
	private PersonJDBCDao personJDBCDao;



	public static void main(String[] args) {
		SpringApplication.run(LearningjdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		personJDBCDao.findAll().stream().forEach(
		p -> logger.info(p.toString())
		);


		logger.info("Query for object");

		logger.info(
		personJDBCDao.findById(10001).toString());

		logger.info("Delete by ID {}", personJDBCDao.deleteById(10004));


		logger.info("Inserting 10004 -> {}", personJDBCDao.insertPerson(new Person(10004,"Nagashree","Mysore",new Date())));

		logger.info("Updating 10003 -> {}", personJDBCDao.update(new Person(10003,"Advi","Puttaprthi",new Date())));
	}
}
