package com.jsp.bank_project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.bank_project.Entity.BankOwner;
import com.jsp.bank_project.Entity.BranchAddress;
import com.jsp.bank_project.dao.BranchAddressDao;
import com.jsp.bank_project.dto.BranchAddressDto;
import com.jsp.bank_project.exception.BranchAddressNotFoundException;
import com.jsp.bank_project.responseStructure.ResponseStructiure;

@Service
public class BranchAddressService {
   @Autowired
   private BranchAddressDao branchAddressDao;
   @Autowired
   private ModelMapper modelMapper;
	public ResponseEntity<ResponseStructiure<BranchAddress>> saveAddress(BranchAddressDto branchAddressDto) {
		BranchAddress branchAddress=this.modelMapper.map(branchAddressDto, BranchAddress.class);
		BranchAddress dbBranchAddress=branchAddressDao.saveAddress(branchAddress);
		if (dbBranchAddress!=null)
		{
			ResponseStructiure<BranchAddress> responseStructiure=new ResponseStructiure<BranchAddress>();
			responseStructiure.setMessage("owner saved uccesfuly");
			responseStructiure.setObject(branchAddress);
			responseStructiure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructiure<BranchAddress>>(responseStructiure,HttpStatus.CREATED);
		}
		return null;
	}

	public ResponseEntity<ResponseStructiure<BranchAddress>> updateAddress(int addressId,BranchAddressDto branchAddressDto) {
		BranchAddress branchAddress=this.modelMapper.map(branchAddressDto, BranchAddress.class);
		BranchAddress dbBranchAddress=branchAddressDao.updateAddress(addressId,branchAddress);
		if (dbBranchAddress!=null)
		{
			ResponseStructiure<BranchAddress> responseStructiure=new ResponseStructiure<BranchAddress>();
			responseStructiure.setMessage("owner saved uccesfuly");
			responseStructiure.setObject(branchAddress);
			responseStructiure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructiure<BranchAddress>>(responseStructiure,HttpStatus.CREATED);
		}
		throw new BranchAddressNotFoundException("failed to update address");
	}

	public ResponseEntity<ResponseStructiure<BranchAddress>> getAddressById(int addressId) {
		BranchAddress dbBranchAddress=branchAddressDao.getAddressById(addressId);
		if (dbBranchAddress!=null)
		{
			BranchAddress branchAddress=this.modelMapper.map(dbBranchAddress, BranchAddress.class);
			ResponseStructiure<BranchAddress> responseStructiure=new ResponseStructiure<BranchAddress>();
			responseStructiure.setMessage("owner saved uccesfuly");
			responseStructiure.setObject(branchAddress);
			responseStructiure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructiure<BranchAddress>>(responseStructiure,HttpStatus.CREATED);
		}
		throw new BranchAddressNotFoundException("failed to fetch address");
	}

	public ResponseEntity<ResponseStructiure<BranchAddress>> deleteAddress(int addressId) {
		BranchAddress dbBranchAddress=branchAddressDao.deleteAddressById(addressId);
		if (dbBranchAddress!=null)
		{
			BranchAddress branchAddress=this.modelMapper.map(dbBranchAddress, BranchAddress.class);
			ResponseStructiure<BranchAddress> responseStructiure=new ResponseStructiure<BranchAddress>();
			responseStructiure.setMessage("owner saved succesfuly");
			responseStructiure.setObject(branchAddress);
			responseStructiure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructiure<BranchAddress>>(responseStructiure,HttpStatus.CREATED);
		}		
		throw new BranchAddressNotFoundException("failed to delete address");
	}
  
}
