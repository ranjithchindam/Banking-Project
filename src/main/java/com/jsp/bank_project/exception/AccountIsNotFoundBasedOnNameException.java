package com.jsp.bank_project.exception;

public class AccountIsNotFoundBasedOnNameException extends RuntimeException {
  private String message;

public AccountIsNotFoundBasedOnNameException(String message) {
	this.message = message;
}

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
  
}
