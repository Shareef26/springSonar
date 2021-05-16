package com.SpringJPA.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringJPA.entity.Person;

@Repository
public interface peopleManagementdao extends CrudRepository<Person, Integer> {
	Person findByFirstname(String firstname);
	

}
