package com.jsp.bank_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.jsp.bank_project.Entity.BankUser;
import com.jsp.bank_project.responseStructure.ResponseStructiure;

public interface BankUserRepo extends JpaRepository<BankUser,Integer>{
	@Query("select p from BankUser p where p.name=?1 and p.accountNumber=?2 and p.password=?3")
  public BankUser getUserByNameAndAccountNumber(String name,long accountNumber, String password);
	@Query("select p from BankUser p where p.phoneNumber=?1")  
	public BankUser findByPhoneNumber(long longphoneNumber);
	@Query("select p from BankUser p where p.adhharNumber=?1")
	public BankUser findByAdhharNumber(long adhharNumber);
}
