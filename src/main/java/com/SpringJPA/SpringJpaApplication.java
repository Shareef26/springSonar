package com.SpringJPA;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.SpringJPA.dao.peopleManagementdao;
import com.SpringJPA.entity.Person;
import com.SpringJPA.service.PersonManagement;
 

@SpringBootApplication
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.SpringJPA")
public class SpringJpaApplication extends SpringBootServletInitializer  implements CommandLineRunner {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringApplication.class);
    }
	
	
	@Autowired PersonManagement Personmanage;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 
		 //findAllperons();
		//createPerson()
		//createPersons();
		//findAllperonsByIds();
		fetchpersonByid();
		
	}
	
	public void createPersons() {
		Person p=new Person(104,"amma","damma", "parveen.2017@gmail.copm", new Date());
		Person p1=new Person(105,"abba","abba", "parveen.2017@gmail.copm", new Date());
		Person p2=new Person(106,"dabba","dabba", "parveen.2017@gmail.copm", new Date());
		Person p3=new Person(106,"hasan","hasan", "hasan.2017@gmail.copm", new Date());
		
		List<Person> persons=new ArrayList<Person>();
		persons.add(p3);
		persons.add(p);
		persons.add(p1);
		persons.add(p2);
		
	   Iterable<Person> list=	Personmanage.createPerson(persons);
	   
	   for(Person per:list) {
		   System.out.println("added perons are     "+per.getFirstname());
		   
	   }
		
	}
	
	
	
	public void createPerson() {
		Person p=new Person(103,"khatun","Parveen", "parveen.2017@gmail.copm", new Date());
		Person p1=new Person(102,"shareef","ahmed", "shareef@gmail.copm", new Date());
		Person persondb=Personmanage.createPerson(p);
		
	}
	
	public  void findAllperons(){
		
		Iterable<Person> person=Personmanage.fetchAllthePersons();
		
		for(Person p:person) {
			System.out.println("All persons fetched from data bases are "+p);
		}
	}
	
	public void findAllperonsByIds() {
		
		List<Integer> idlist=new ArrayList<Integer>();
		idlist.add(101);
		idlist.add(105);
		
		Iterable<Person> person=Personmanage.fetchAllthePersonsByIds(idlist);
		
		for(Person p: person) {
			System.out.println("data fetched form table is    "+p);
		}
	}
	
	public void fetchpersonByid() {
		
		Person p=Personmanage.fetchPersonById(101);
		
		System.out.println("the fetched customer iss  "+p.toString());
		
	}

}
