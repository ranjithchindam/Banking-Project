package com.jsp.bank_project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bank_project.Entity.BankUser;
import com.jsp.bank_project.repository.BankUserRepo;
@Repository
public class BankUserDao {
   @Autowired
   private BankUserRepo bankRepo;

public BankUser saveUser(BankUser bankUser) {
	return bankRepo.save(bankUser);
}

public BankUser getUserByNameAndPhnoneNumber(String name, long accountNumber, String password) {
	BankUser dbBankUser=bankRepo.getUserByNameAndAccountNumber(name, accountNumber,password);
	if (dbBankUser!=null)
	{
		return dbBankUser;
	}
	return null;
}

public BankUser updateBankUser(BankUser bankUser, BankUser dbBankUser) {
		bankUser.setAccountNumber(dbBankUser.getAccountNumber());
		bankRepo.save(bankUser);
	    return bankUser;
}

public BankUser deleteUser(BankUser dbBankUser) {
	dbBankUser.setListOfBanksBranches(null);
	bankRepo.delete(dbBankUser);
	return dbBankUser;
}

public BankUser getUserByphoneNumber(long phoneNumber) {
	BankUser bankUser=bankRepo.findByPhoneNumber(phoneNumber);
	return bankUser;
}
}
