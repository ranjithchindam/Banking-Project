package com.jsp.bank_project.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.bank_project.responseStructure.ResponseStructiure;

@RestControllerAdvice
public class ExceptionHandlingClass extends ResponseEntityExceptionHandler{
  @ExceptionHandler
  public ResponseEntity<ResponseStructiure<String>> branchAddressNotFoundException(BranchAddressNotFoundException branchAddressNotFoundException) {
	  ResponseStructiure<String> responseStructiure=new ResponseStructiure<String>();
	  responseStructiure.setMessage("address is not found");
	  responseStructiure.setStatus(HttpStatus.NOT_FOUND.value());
	  responseStructiure.setObject(branchAddressNotFoundException.getMessage());
	  ResponseEntity<ResponseStructiure<String>> responseEntity=new ResponseEntity<ResponseStructiure<String>>(responseStructiure,HttpStatus.NOT_FOUND);
     return responseEntity;
  }
  @ExceptionHandler
  public ResponseEntity<ResponseStructiure<String>> bankOwnerNotFoundException(BankOwnerNotFoundException bankOwnerNotFoundException) {
	  ResponseStructiure<String> responseStructiure=new ResponseStructiure<String>();
	  responseStructiure.setMessage("owner is not found");
	  responseStructiure.setStatus(HttpStatus.NOT_FOUND.value());
	  responseStructiure.setObject(bankOwnerNotFoundException.getMessage());
	  ResponseEntity<ResponseStructiure<String>> responseEntity=new ResponseEntity<ResponseStructiure<String>>(responseStructiure,HttpStatus.NOT_FOUND);
     return responseEntity;
  }
  @ExceptionHandler
  public ResponseEntity<ResponseStructiure<String>> branchIdNotFoundException(BranchIdNotFoundException branchIdNotFoundException) {
	  ResponseStructiure<String> responseStructiure=new ResponseStructiure<String>();
	  responseStructiure.setMessage("branch is not found");
	  responseStructiure.setStatus(HttpStatus.NOT_FOUND.value());
	  responseStructiure.setObject(branchIdNotFoundException.getMessage());
	  ResponseEntity<ResponseStructiure<String>> responseEntity=new ResponseEntity<ResponseStructiure<String>>(responseStructiure,HttpStatus.NOT_FOUND);
     return responseEntity;
  }
  @ExceptionHandler
  public ResponseEntity<ResponseStructiure<String>> bankUserNotFoundBasedOnNameAndAccountNumber(BankUserNotFoundBasedOnNameAndAccountNumber ex) {
	  ResponseStructiure<String> responseStructiure=new ResponseStructiure<String>();
	  responseStructiure.setMessage("user is not found");
	  responseStructiure.setStatus(HttpStatus.NOT_FOUND.value());
	  responseStructiure.setObject(ex.getMessage());
	  ResponseEntity<ResponseStructiure<String>> responseEntity=new ResponseEntity<ResponseStructiure<String>>(responseStructiure,HttpStatus.NOT_FOUND);
     return responseEntity;
  }
  @ExceptionHandler
  public ResponseEntity<ResponseStructiure<String>> phoneNumberIsAlreadyPresentException(PhoneNumberIsAlreadyPresentException ex) {
	  ResponseStructiure<String> responseStructiure=new ResponseStructiure<String>();
	  responseStructiure.setMessage("User Is Alredy Registered with This Phone Number");
	  responseStructiure.setStatus(HttpStatus.NOT_FOUND.value());
	  responseStructiure.setObject(ex.getResponse());
	  ResponseEntity<ResponseStructiure<String>> responseEntity=new ResponseEntity<ResponseStructiure<String>>(responseStructiure,HttpStatus.NOT_FOUND);
     return responseEntity;
  }
  @ExceptionHandler
  public ResponseEntity<ResponseStructiure<String>> adhharNumberExceptionHandler(AdhharNumberIsAlreadyPresentException ex) {
	  ResponseStructiure<String> responseStructiure=new ResponseStructiure<String>();
	  responseStructiure.setMessage("User Is Alredy Registered with This Adhhar Number");
	  responseStructiure.setStatus(HttpStatus.NOT_FOUND.value());
	  responseStructiure.setObject(ex.getResponse());
	  ResponseEntity<ResponseStructiure<String>> responseEntity=new ResponseEntity<ResponseStructiure<String>>(responseStructiure,HttpStatus.NOT_FOUND);
     return responseEntity;
  }
}
