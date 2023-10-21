package com.jsp.bank_project.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.bank_project.Entity.BankOwner;
import com.jsp.bank_project.Entity.BranchAddress;
import com.jsp.bank_project.Entity.ListOfBanksBranches;
import com.jsp.bank_project.dao.BankBranchDao;
import com.jsp.bank_project.dao.BranchAddressDao;
import com.jsp.bank_project.dao.OwnerDao;
import com.jsp.bank_project.dto.ListOfBanksBranchesDto;
import com.jsp.bank_project.exception.BankOwnerNotFoundException;
import com.jsp.bank_project.exception.BranchAddressNotFoundException;
import com.jsp.bank_project.exception.BranchIdNotFoundException;
import com.jsp.bank_project.responseStructure.ResponseStructiure;

@Service
public class BankBranchService {
  @Autowired
  private BankBranchDao dao;
  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  private OwnerDao ownerDao;
  @Autowired
  private BranchAddressDao branchAddressDao;
  @Autowired
  private BankBranchDao bankBranchDao;
public ResponseEntity<ResponseStructiure<ListOfBanksBranches>> saveBranch(int addressId, int ownerId, ListOfBanksBranchesDto listOfBanksBranchesDto) {
	ListOfBanksBranches listOfBanksBranches=this.modelMapper.map(listOfBanksBranchesDto, ListOfBanksBranches.class);
	BankOwner dbBankOwner=ownerDao.getOwnerById(ownerId);
	if (dbBankOwner!=null)
	{
		BranchAddress dbBranchAddress=branchAddressDao.getAddressById(addressId);
		if (dbBranchAddress!=null)
		{
			dbBranchAddress.setListOfBanksBranches(listOfBanksBranches);
			listOfBanksBranches.setBankOwner(dbBankOwner);
			listOfBanksBranches.setBranchAddress(dbBranchAddress);
			ListOfBanksBranches dbListOfBanksBranches=dao.saveBranch(listOfBanksBranches);
			if (dbListOfBanksBranches!=null)
			{
				if (dbBankOwner.getBanks().isEmpty())
				{
					List<ListOfBanksBranches> branches=dbBankOwner.getBanks();
					branches.add(dbListOfBanksBranches);
					dbBankOwner.setBanks(branches);
				}
				else
				{
					List<ListOfBanksBranches> branches=dbBankOwner.getBanks();
					branches.add(listOfBanksBranches);
					dbBankOwner.setBanks(branches);
				}
				ResponseStructiure<ListOfBanksBranches> responseStructiure=new ResponseStructiure<ListOfBanksBranches>();
				responseStructiure.setMessage("branch saved succesfully");
				responseStructiure.setObject(dbListOfBanksBranches);
				responseStructiure.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructiure<ListOfBanksBranches>>(responseStructiure,HttpStatus.CREATED);
			}
		}
		throw new BranchAddressNotFoundException("failed to add branch address not present");
	}
	throw new BankOwnerNotFoundException("failed to add branch owner not present");
	
}
public ResponseEntity<ResponseStructiure<ListOfBanksBranches>> getBranchById(int id) {
	ListOfBanksBranches dbListOfBanksBranches=dao.getBranchById(id);
	if (dbListOfBanksBranches!=null)
	{
		ResponseStructiure<ListOfBanksBranches> responseStructiure=new ResponseStructiure<ListOfBanksBranches>();
		responseStructiure.setMessage("branch fetched succesfully");
		responseStructiure.setObject(dbListOfBanksBranches);
		responseStructiure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructiure<ListOfBanksBranches>>(responseStructiure,HttpStatus.FOUND);
	}
	throw new BranchIdNotFoundException("failesd to fetch branch");
}
public ResponseEntity<ResponseStructiure<ListOfBanksBranches>> deleteBranch(int id) {
	ListOfBanksBranches dbBankBranch = bankBranchDao.getBranchById(id);
	if (dbBankBranch!=null)
	{
		BankOwner owner = ownerDao.getOwnerById(dbBankBranch.getBankOwner().getOwnerId());
//		List<ListOfBanksBranches> list = owner.getBanks();
//		for (ListOfBanksBranches branches:list)
//		{
//			if (branches.equals(dbBankBranch))
//			{
//				list.remove(branches);
//			}
//		}
//		owner.setBanks(list);
//		ownerDao.saveOwner(owner);
		BranchAddress address=branchAddressDao.getAddressById(dbBankBranch.getBranchAddress().getId());
		address.setListOfBanksBranches(null);
		ListOfBanksBranches list1=bankBranchDao.deleteBranchById(dbBankBranch);
		if (list1!=null)
		{
			ResponseStructiure<ListOfBanksBranches> responseStructiure=new ResponseStructiure<ListOfBanksBranches>();
			responseStructiure.setMessage("branch updated succesfully");
			responseStructiure.setObject(list1);
			responseStructiure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructiure<ListOfBanksBranches>>(responseStructiure,HttpStatus.OK);
		}
	}
	throw new BranchIdNotFoundException("failesd to fetch branch");
}
public ResponseEntity<ResponseStructiure<ListOfBanksBranches>> updateBranch(int id,
		ListOfBanksBranchesDto listOfBanksBranchesDto) {
	ListOfBanksBranches dbBankBranch = bankBranchDao.getBranchById(id);
	if (dbBankBranch!=null)
	{
		ListOfBanksBranches listOfBanksBranches=this.modelMapper.map(listOfBanksBranchesDto, ListOfBanksBranches.class);
		ListOfBanksBranches branch = bankBranchDao.updateBranch(listOfBanksBranches,dbBankBranch);
		if (branch!=null)
		{
			ResponseStructiure<ListOfBanksBranches> responseStructiure=new ResponseStructiure<ListOfBanksBranches>();
			responseStructiure.setMessage("branch updated succesfully");
			responseStructiure.setObject(branch);
			responseStructiure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructiure<ListOfBanksBranches>>(responseStructiure,HttpStatus.FOUND);
		}
	}
	throw new BranchIdNotFoundException("failesd to fetch branch");
}

}
