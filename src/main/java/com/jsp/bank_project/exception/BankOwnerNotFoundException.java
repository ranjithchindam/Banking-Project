package com.jsp.bank_project.exception;

public class BankOwnerNotFoundException extends RuntimeException {
   private String message;

/**
 * @return the message
 */
public String getMessage() {
	return message;
}

/**
 * @param message the message to set
 */
public void setMessage(String message) {
	this.message = message;
}

public BankOwnerNotFoundException(String message) {
	this.message = message;
}
   
}
