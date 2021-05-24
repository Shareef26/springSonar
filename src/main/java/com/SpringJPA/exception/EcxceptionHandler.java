package com.SpringJPA.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EcxceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NosuchPerson.class)
	public ResponseEntity<Object> NosuchPersonExcpetion(NosuchPerson  e){
		ApiError apierror=new ApiError(HttpStatus.BAD_REQUEST,e.getMessage(),  e);
		return new ResponseEntity<Object>(apierror, HttpStatus.OK);}
		
	//
	/*
	
	*if you extend the ResponseEntityExceptionHandler then you not need to mention @ExceptionHandler(MethodArgumentNotValidException.class)
	*it will automatically all the exception falling in it
	*
	*if first name tag is missing in request it will handled by 
    and @notnull message on dto will be executed.
    
	**if first name tag is present but value is null  in request it will handled by 
    and @notblank message on dto will be executed.
	*
	@ExceptionHandler(MethodArgumentNotValidException.class)
	 public ResponseEntity<Object> handleInputValidation(MethodArgumentNotValidException e )	{
		ApiError apierror=new ApiError(HttpStatus.BAD_REQUEST,"please check the request again",  e);
		return new ResponseEntity<Object>(apierror, HttpStatus.OK);
		
		the above method worked fine when I did not extend ResponseEntityExceptionHandler and wrote just above method with 
		MethodArgumentNotValidException e  parameter only. in the same method if I tried to write other params  wihtout extending 
		ResponseEntityExceptionHandler then no compile error, but this exception was not invoked, instead 400 was thrown with no info
		
		when I extended ResponseEntityExceptionHandler I had to write the below method as it is then it worked.
	}*/
	
	//below method works fine when extended responseEntity.
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request)
	{
		
		ApiError apierror=new ApiError(HttpStatus.BAD_REQUEST,"please check the request again",  ex);
		return new ResponseEntity<Object>(apierror, HttpStatus.OK);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> generalException(Exception e){
		System.out.println(e);
		//System.out.println("inside general exception handling block creating apierror");
		ApiError apierror=new ApiError(HttpStatus.BAD_REQUEST,"Internal Server error",  e);
		//System.out.println("api error created");
		//System.out.println(apierror.message);
		//System.out.println(apierror.status);
		
		return new ResponseEntity<Object>(apierror, HttpStatus.OK);
		
	}
	

}
