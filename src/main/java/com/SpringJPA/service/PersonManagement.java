package com.SpringJPA.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.SpringJPA.dao.peopleManagementdao;
import com.SpringJPA.entity.Person;
import org.apache.logging.log4j.Logger;

@Service
@Component
public class PersonManagement {
	
	public static final Logger LOGGER=LogManager.getLogger(PersonManagement.class);
	
	@Autowired
    private peopleManagementdao dao;
	
	
	public Person createPerson(Person p) {
		LOGGER.info("Data saved in DB");
		return dao.save(p);
		
		
	}
	
	public Iterable<Person> createPerson(List<Person> persons) {
		LOGGER.info("list of Data saved in DB");
		
		Iterable<Person> list= dao.saveAll(persons);
		
		return list;
		
	}
	
	
	public Iterable<Person> fetchAllthePersons(){
		LOGGER.info("Data saved in DB");
		Iterable<Person> list=dao.findAll();
		
		return list;
		
	}
	  
	public Iterable<Person> fetchAllthePersonsByIds(List<Integer> idlist){
		LOGGER.info("Data saved in DB");
		Iterable<Person> persons= dao.findAllById(idlist);
		return persons;
	}
	
	
	public Person fetchPersonById(Integer id) {
		LOGGER.info("Data saved in DB");
		
		return dao.findById(id).get();
		 
	}
	
	
	
}
