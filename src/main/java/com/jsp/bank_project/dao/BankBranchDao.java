package com.jsp.bank_project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bank_project.Entity.BankOwner;
import com.jsp.bank_project.Entity.BankUser;
import com.jsp.bank_project.Entity.BranchAddress;
import com.jsp.bank_project.Entity.ListOfBanksBranches;
import com.jsp.bank_project.dto.ListOfBanksBranchesDto;
import com.jsp.bank_project.repository.BankOwnerRepo;
import com.jsp.bank_project.repository.BranchAddressRepo;
import com.jsp.bank_project.repository.ListOfBankBranchesRepo;

@Repository
public class BankBranchDao {
    @Autowired
    private ListOfBankBranchesRepo repo;
	public ListOfBanksBranches saveBranch(ListOfBanksBranches listOfBanksBranches) {
	
		return repo.save(listOfBanksBranches);
	}
	public ListOfBanksBranches getBranchById(int id) {
		Optional<ListOfBanksBranches> optional = repo.findById(id);
		if (optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public ListOfBanksBranches updateBranch(ListOfBanksBranches listOfBanksBranches, ListOfBanksBranches dbBankBranch) {
		listOfBanksBranches.setBankOwner(dbBankBranch.getBankOwner());
		listOfBanksBranches.setBranchAddress(dbBankBranch.getBranchAddress());
		listOfBanksBranches.setId(dbBankBranch.getId());
		return repo.save(listOfBanksBranches);
	}
	public ListOfBanksBranches deleteBranchById(ListOfBanksBranches dbBankBranch) {
		
			dbBankBranch.setBankOwner(null);
			dbBankBranch.setBranchAddress(null);
			ListOfBanksBranches list=dbBankBranch;
			repo.delete(dbBankBranch);
			return list;
		
	}

}
