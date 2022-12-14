package com.lefnds.jpatablerelationship;

import com.lefnds.jpatablerelationship.models.Person;
import com.lefnds.jpatablerelationship.models.enums.Gender;
import com.lefnds.jpatablerelationship.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class JpaTableRelationshipApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaTableRelationshipApplication.class, args);
	}

	@Autowired
	PersonService service;
	public void run(ApplicationArguments applicationArguments) throws Exception {
		Person p = new Person();
		p.setAge(30);
		p.setGender(Gender.Female);

	}

}
