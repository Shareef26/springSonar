package com.SpringJPA.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EcxceptionHandler {
	
	@ExceptionHandler(NosuchPerson.class)
	public ResponseEntity<Object> NosuchPersonExcpetion(NosuchPerson  e){
		ApiError apierror=new ApiError(HttpStatus.BAD_REQUEST,e.getMessage(),  e);
		return new ResponseEntity<Object>(apierror, HttpStatus.OK);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> generalException(Exception e){
		//System.out.println("inside general exception handling block creating apierror");
		ApiError apierror=new ApiError(HttpStatus.BAD_REQUEST,"Internal Server error",  e);
		//System.out.println("api error created");
		//System.out.println(apierror.message);
		//System.out.println(apierror.status);
		
		return new ResponseEntity<Object>(apierror, HttpStatus.OK);
		
	}
	

}
