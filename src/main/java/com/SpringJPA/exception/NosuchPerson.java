package com.SpringJPA.exception;

public class NosuchPerson extends Exception{
	private static final long serialVersionUID = -9079454849611061074L;
	
	String error_message;
	
   public NosuchPerson (String error_message) {
	   
	   super(error_message);
	   
   }
	
}
