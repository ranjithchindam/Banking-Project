package com.jsp.bank_project.exception;

public class AdhharNumberIsAlreadyPresentException extends RuntimeException {
   private String response;
   public AdhharNumberIsAlreadyPresentException(String response) {
	this.response=response;
}
/**
 * @return the response
 */
public String getResponse() {
	return response;
}
/**
 * @param response the response to set
 */
public void setResponse(String response) {
	this.response = response;
}
   
   
}
