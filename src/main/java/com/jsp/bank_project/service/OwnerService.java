package com.jsp.bank_project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.bank_project.Entity.BankOwner;
import com.jsp.bank_project.dao.OwnerDao;
import com.jsp.bank_project.dto.BankOwnerDto;
import com.jsp.bank_project.exception.OwnerIdNotFoundException;
import com.jsp.bank_project.responseStructure.ResponseStructiure;

@Service
public class OwnerService {
@Autowired
private OwnerDao ownerDao;
@Autowired
private ModelMapper modelMapper;
	public ResponseEntity<ResponseStructiure<BankOwner>> saveOwner(BankOwnerDto bankOwnerDto) {
		BankOwner bankOwner=this.modelMapper.map(bankOwnerDto, BankOwner.class);
		BankOwner dbbankOwner=ownerDao.saveOwner(bankOwner);
		if (dbbankOwner!=null)
		{
			ResponseStructiure<BankOwner> responseStructiure=new ResponseStructiure<BankOwner>();
			responseStructiure.setMessage("owner saved uccesfuly");
			responseStructiure.setObject(dbbankOwner);
			responseStructiure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructiure<BankOwner>>(responseStructiure,HttpStatus.CREATED);
		}
		return null;
	}
	public ResponseEntity<ResponseStructiure<BankOwner>> updateOwner(int ownerId, BankOwnerDto bankOwnerDto) {
		BankOwner bankOwner=this.modelMapper.map(bankOwnerDto, BankOwner.class);
		BankOwner dbbankOwner=ownerDao.updateOwner(ownerId,bankOwner);
		if (dbbankOwner!=null)
		{
			ResponseStructiure<BankOwner> responseStructiure=new ResponseStructiure<BankOwner>();
			responseStructiure.setMessage("owner updated uccesfuly");
			responseStructiure.setObject(dbbankOwner);
			responseStructiure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructiure<BankOwner>>(responseStructiure,HttpStatus.CREATED);
		}
		throw new OwnerIdNotFoundException("failed to fetch owner");
	}
	public ResponseEntity<ResponseStructiure<BankOwner>> getOwnerById(int ownerId) {
		BankOwner dbbankOwner=ownerDao.getOwnerById(ownerId);
		if (dbbankOwner!=null)
		{
			ResponseStructiure<BankOwner> responseStructiure=new ResponseStructiure<BankOwner>();
			responseStructiure.setMessage("owner updated uccesfuly");
			responseStructiure.setObject(dbbankOwner);
			responseStructiure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructiure<BankOwner>>(responseStructiure,HttpStatus.FOUND);
		}
		throw new OwnerIdNotFoundException("failed to fetch owner");
	}
	public ResponseEntity<ResponseStructiure<BankOwner>> deleteOwner(int ownerId) {
		BankOwner dbbankOwner=ownerDao.deleteOwner(ownerId);
		if (dbbankOwner!=null)
		{
			ResponseStructiure<BankOwner> responseStructiure=new ResponseStructiure<BankOwner>();
			responseStructiure.setMessage("owner updated uccesfuly");
			responseStructiure.setObject(dbbankOwner);
			responseStructiure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructiure<BankOwner>>(responseStructiure,HttpStatus.FOUND);
		}
		throw new OwnerIdNotFoundException("failed to fetch owner");
	}
   
}
