package com.SpringJPA.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringJPA.dto.PersonDto;
import com.SpringJPA.entity.Person;
import com.SpringJPA.exception.NosuchPerson;
import com.SpringJPA.service.PersonManagement;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonManagement personser;
	
	
	public static final Logger logger=LogManager.getLogger(PersonController.class);
    
	
	
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> addperson(@RequestBody PersonDto dto){		
		
		String threadId = "";
		threadId = dto.getId()+ "_addingPerson";
		logger.debug("threadId : " + threadId);
		ThreadContext.put("messageId", threadId);
		
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
	logger.info("going to call service call ");
	personser.createPerson(p);
	
	String response="The Person created with id  "+dto.getId();
	ThreadContext.clearAll();
	return ResponseEntity.ok(response);
	
	}
	
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<PersonDto>> getAllPersons(){
		
		String threadId = "";
		threadId = new Date()+ "_addingPerson";
		logger.debug("threadId : " + threadId);
		ThreadContext.put("messageId", threadId);
		
		logger.info("entering in the get fetchAll persons method");
		
		List<PersonDto> personloist=new ArrayList<PersonDto>();
		Iterable<Person> iter=personser.fetchAllthePersons();
		for(Person p:iter) {
		logger.info("prininting the list of Person entity   "+p.toString());
		
		}
		for(Person p:iter) {
			PersonDto p1=new PersonDto();
			p1.setDate(p.getDate());
			p1.setEmail(p.getEmail());
			p1.setFirstname(p.getFirstname());
			p1.setLastname(p.getLastname());
			p1.setId(p.getId());
			
			personloist.add(p1);	
			
		}
		ThreadContext.clearAll();
		return ResponseEntity.ok(personloist);
	}
	
	@GetMapping(value = "/{id}", produces = "application/json") 
	public ResponseEntity<Object> getPsersonById (@PathVariable int id) throws Throwable {
		PersonDto p=new PersonDto();
		Person entity=new Person();
		try {
		 
		String threadId = "";
		threadId = id+"  get by id method invoked";
		logger.debug("threadId : " + threadId);
		ThreadContext.put("messageId", threadId);
		
		entity=personser.fetchPersonById(id);
		if(entity==null)
		{
			throw new NosuchPerson("No such person data base");
		}
		else
			p.setDate(entity.getDate());
		    p.setEmail(entity.getEmail());
		    p.setFirstname(entity.getFirstname());
		    p.setId(entity.getId());
		    p.setLastname(entity.getLastname());
		  }
		
		catch(NosuchPerson e) {
			logger.debug("inside No such person catch block    " +e);
			throw new NosuchPerson("No such person catch block"); 
		}
		

       catch (NoSuchElementException e)		{
    	    e.printStackTrace();
			logger.error(e.getStackTrace());
			logger.error(e.getCause());
    	   throw new NosuchPerson("No such person data base");
    	   
       }
		
		catch(Exception e) {
			logger.debug("inside generic Exception catch block   " +e);
			e.printStackTrace();
		//	logger.info(e.printStackTrace());
			logger.error(e.getCause());
			
			throw new Exception(e.getMessage()); 
		}
		   
		
		    return ResponseEntity.ok(p);
	}
	
}
