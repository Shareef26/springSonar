package com.SpringJPA.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


public class PersonDto {
	

	@NotNull(message="id cannot be null")
	private Integer id;
	@NotBlank(message="first name cannot be blank")
	@NotNull(message="first name cannot be null")
	private String firstname;
	@NotNull (message="lastname cannot be null")
	private String lastname;
	@NotNull (message="email cannot be null")
	private String email;
	@JsonFormat(timezone="Asia/Calcutta")
	@NotNull (message="date cannot be null")
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
