package com.SpringJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.SpringJPA.dao.peopleManagementdao;
import com.SpringJPA.entity.Person;

@Service
@Component
public class PersonManagement {
	
	@Autowired
    private peopleManagementdao dao;
	
	
	public Person createPerson(Person p) {
		return dao.save(p);
		
	}
	
	public Iterable<Person> createPerson(List<Person> persons) {
		
		Iterable<Person> list= dao.saveAll(persons);
		
		return list;
		
	}
	
	
	public Iterable<Person> fetchAllthePersons(){
	 
		Iterable<Person> list=dao.findAll();
		
		return list;
		
	}
	  
	public Iterable<Person> fetchAllthePersonsByIds(List<Integer> idlist){
		
		Iterable<Person> persons= dao.findAllById(idlist);
		return persons;
	}
	
	
	public Person fetchPersonById(Integer id) {
		
		return dao.findById(id).get();
		 
	}
	
	
	
}
