package com.SpringJPA.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringJPA.dto.PersonDto;
import com.SpringJPA.entity.Person;
import com.SpringJPA.service.PersonManagement;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonManagement personser;
	
	
	public static final Logger logger=LogManager.getLogger(PersonController.class);

	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> addperson(@RequestBody PersonDto dto){		
	logger.info("The incoming request is    "+dto.toString());
	System.out.println("enetered controllwer method");
	System.out.println(dto.toString());
		
	Person p=new Person();
	p.setId(dto.getId());
	p.setDate(dto.getDate());
	p.setEmail(dto.getEmail());
	p.setFirstname(dto.getFirstname());
	p.setId(dto.getId());
	p.setLastname(dto.getLastname());
	
	logger.info("The generated entity is   "+p.toString());
	personser.createPerson(p);
	
	String response="The Person created with id  "+dto.getId();
	return ResponseEntity.ok(response);
	}
	
}
