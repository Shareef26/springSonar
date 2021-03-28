package com.SpringJPA.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonDto {
	
	
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	@JsonFormat(timezone="Asia/Calcutta")
	private Date date;
	public PersonDto(Integer id, String firstname, String lastname, String email, Date date) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.date = date;
	}

	public PersonDto() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PersonDto [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", date=" + date + "]";
	};
	
	
	
}
