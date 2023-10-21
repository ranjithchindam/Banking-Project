package com.jsp.bank_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.bank_project.Entity.BranchAddress;

public interface BranchAddressRepo extends JpaRepository<BranchAddress, Integer>{

}
