package com.jsp.bank_project.exception;

public class BranchAddressNotFoundException extends RuntimeException {
  private String message;

public BranchAddressNotFoundException(String message) {
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
