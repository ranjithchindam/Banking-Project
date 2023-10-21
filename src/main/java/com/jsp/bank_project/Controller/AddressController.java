package com.jsp.bank_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bank_project.Entity.BankOwner;
import com.jsp.bank_project.Entity.BranchAddress;
import com.jsp.bank_project.dto.BankOwnerDto;
import com.jsp.bank_project.dto.BranchAddressDto;
import com.jsp.bank_project.responseStructure.ResponseStructiure;
import com.jsp.bank_project.service.BranchAddressService;

@RestController
@RequestMapping("address")
public class AddressController {
	@Autowired
	private BranchAddressService service;
  @PostMapping
  public ResponseEntity<ResponseStructiure<BranchAddress>> saveAddress(@RequestBody BranchAddressDto branchAddressDto)
  {
	  return service.saveAddress(branchAddressDto);
  }
  @PutMapping
  public ResponseEntity<ResponseStructiure<BranchAddress>> updateAddress(@RequestBody BranchAddressDto branchAddressDto,@RequestParam int addressId)
  {
	  return service.updateAddress(addressId,branchAddressDto);
  }
  @GetMapping
  public ResponseEntity<ResponseStructiure<BranchAddress>> getAddressById(@RequestParam int addressId)
  {
	  return service.getAddressById(addressId);
  }
  @DeleteMapping
  public ResponseEntity<ResponseStructiure<BranchAddress>> deleteAddress(@RequestParam int addressId)
  {
	  return service.deleteAddress(addressId);
  }
}
