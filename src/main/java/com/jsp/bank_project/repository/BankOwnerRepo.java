package com.jsp.bank_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.bank_project.Entity.BankOwner;

public interface BankOwnerRepo extends JpaRepository<BankOwner, Integer>{

}
