package com.jsp.bank_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bank_project.Entity.BankOwner;
import com.jsp.bank_project.dto.BankOwnerDto;
import com.jsp.bank_project.responseStructure.ResponseStructiure;
import com.jsp.bank_project.service.OwnerService;

@RestController
@RequestMapping("owner")
@CrossOrigin
public class BankOwnerController {
	@Autowired
	private OwnerService service;
  @PostMapping
  public ResponseEntity<ResponseStructiure<BankOwner>> saveOwner(@RequestBody BankOwnerDto bankOwnerDto)
  {
	  return service.saveOwner(bankOwnerDto);
  }
  @PutMapping
  public ResponseEntity<ResponseStructiure<BankOwner>> updateOwner(@RequestBody BankOwnerDto bankOwnerDto,@RequestParam int ownerId)
  {
	  return service.updateOwner(ownerId,bankOwnerDto);
  }
  @GetMapping
  public ResponseEntity<ResponseStructiure<BankOwner>> getOwnerById(@RequestParam int ownerId)
  {
	  return service.getOwnerById(ownerId);
  }
  @DeleteMapping
  public ResponseEntity<ResponseStructiure<BankOwner>> deleteOwner(@RequestParam int ownerId)
  {
	  return service.deleteOwner(ownerId);
  }
}
