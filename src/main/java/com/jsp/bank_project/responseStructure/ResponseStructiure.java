package com.jsp.bank_project.responseStructure;

public class ResponseStructiure<Object> {
  private int status;
  private String message;
  private Object object;
/**
 * @return the status
 */
public int getStatus() {
	return status;
}
/**
 * @param status the status to set
 */
public void setStatus(int status) {
	this.status = status;
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
/**
 * @return the object
 */
public Object getObject() {
	return object;
}
/**
 * @param object the object to set
 */
public void setObject(Object object) {
	this.object = object;
}
  
}
