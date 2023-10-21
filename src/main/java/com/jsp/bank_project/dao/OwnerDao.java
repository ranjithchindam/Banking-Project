package com.jsp.bank_project.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bank_project.Entity.BankOwner;
import com.jsp.bank_project.repository.BankOwnerRepo;

@Repository
public class OwnerDao {
  @Autowired
  private BankOwnerRepo repo;
	public BankOwner saveOwner(BankOwner bankOwner) {
	repo.save(bankOwner);
	return bankOwner;
	}
	public BankOwner updateOwner(int ownerId, BankOwner bankOwner) {
		Optional<BankOwner> dbBankOwner = repo.findById(ownerId);
		if (dbBankOwner.isPresent())
		{
			BankOwner owner=dbBankOwner.get();
			bankOwner.setOwnerId(owner.getOwnerId());
			return repo.save(bankOwner);
		}
		return null;
	}
	public BankOwner getOwnerById(int ownerId) {
		Optional<BankOwner> dbBankOwner = repo.findById(ownerId);
		if (dbBankOwner.isPresent())
		{
			return dbBankOwner.get();
		}
		return null;
	}
	public BankOwner deleteOwner(int ownerId) {
		Optional<BankOwner> dbBankOwner = repo.findById(ownerId);
		if (dbBankOwner.isPresent())
		{
			BankOwner owner=dbBankOwner.get();
			repo.delete(dbBankOwner.get());
			return owner;
		}
		return null;
	}
    
}
