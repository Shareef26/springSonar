package com.SpringJPA.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

class ApiError {

	   public HttpStatus status;
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	   public LocalDateTime timestamp;
	   public String message;
	   public String debugMessage;
	  

	   private ApiError() {
	       timestamp = LocalDateTime.now();
	   }

	   ApiError(HttpStatus status) {
	       this();
	       this.status = status;
	   }

	   ApiError(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = "Unexpected error";
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	   ApiError(HttpStatus status, String message, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = message;
	       this.debugMessage = ex.getLocalizedMessage();
	   }
	}