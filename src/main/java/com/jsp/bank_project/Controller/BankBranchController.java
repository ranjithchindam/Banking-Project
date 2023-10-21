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

import com.jsp.bank_project.Entity.ListOfBanksBranches;
import com.jsp.bank_project.dto.BankOwnerDto;
import com.jsp.bank_project.dto.ListOfBanksBranchesDto;
import com.jsp.bank_project.responseStructure.ResponseStructiure;
import com.jsp.bank_project.service.BankBranchService;

@RestController
@RequestMapping("/branch")
@CrossOrigin
public class BankBranchController {
   @Autowired
   private BankBranchService service;
   @PostMapping
   public ResponseEntity<ResponseStructiure<ListOfBanksBranches>> saveBranch(@RequestParam int addressId,@RequestParam int ownerId,@RequestBody ListOfBanksBranchesDto listOfBanksBranchesDto)
   {
	   return service.saveBranch(addressId,ownerId,listOfBanksBranchesDto);
   }
   @GetMapping
   public ResponseEntity<ResponseStructiure<ListOfBanksBranches>> getBranchById(@RequestParam int id)
   {
	   return service.getBranchById(id);
   }
   
   @DeleteMapping
   public ResponseEntity<ResponseStructiure<ListOfBanksBranches>> deleteBranch(@RequestParam int id)
   {
	   return service.deleteBranch(id);
   }
   @PutMapping
   public ResponseEntity<ResponseStructiure<ListOfBanksBranches>> updateBranch(@RequestParam int id,@RequestBody ListOfBanksBranchesDto listOfBanksBranchesDto)
   {
	   return service.updateBranch(id,listOfBanksBranchesDto);
   }
}
