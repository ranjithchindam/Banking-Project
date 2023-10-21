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

import com.jsp.bank_project.Entity.BankUser;
import com.jsp.bank_project.Entity.ListOfBanksBranches;
import com.jsp.bank_project.dto.BankUserDto;
import com.jsp.bank_project.responseStructure.ResponseStructiure;
import com.jsp.bank_project.service.BankUserService;

@RestController
@RequestMapping("user")
@CrossOrigin
public class BankUserController {
	@Autowired
	private BankUserService service;
   @PostMapping
   private ResponseEntity<ResponseStructiure<BankUser>>  saveUser(@RequestBody BankUserDto bankUserDto,@RequestParam int branchid)
   {
	   return service.saveUser(bankUserDto,branchid);
   }
   @GetMapping
   private ResponseEntity<ResponseStructiure<BankUser>>  getUserByNameAndPhnoneNumber(@RequestParam String name,@RequestParam long accountNumber,@RequestParam String password)
   {
	   return service.getUserByNameAndAccountNumber(name,accountNumber,password);
   }
   @DeleteMapping
   private ResponseEntity<ResponseStructiure<BankUser>>  deleteBankUser(@RequestParam String name,@RequestParam long accountNumber,@RequestParam String password)
   {
	   return service.deleteUserByNameAndAccountNumber(name,accountNumber,password);
   }
   @PutMapping
   private ResponseEntity<ResponseStructiure<BankUser>>  updateBankUser(@RequestParam String name,@RequestParam long accountNumber,@RequestParam String password,@RequestBody BankUserDto bankUserDto)
   {
	   return service.updateUserByNameAndAccountNumber(name,accountNumber,bankUserDto,password);
   }
}
