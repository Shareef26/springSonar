package com.SpringJPA.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringJPA.dao.peopleManagementdao;
import com.SpringJPA.entity.Person;

@Service
public class MyuserDetailsService  implements UserDetailsService{
	
	@Autowired
	peopleManagementdao repo;
	
	@Override
	public UserDetails loadUserByUsername(String firstname) throws UsernameNotFoundException {
		Person p=repo.findByFirstname(firstname);
		UserDetails user=User.withUsername(p.getFirstname()).password(p.getLastname()).authorities("USER").build();
		return user;
		
		 
	}

}
