package com.jsp.bank_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.bank_project.Entity.ListOfBanksBranches;

public interface ListOfBankBranchesRepo extends JpaRepository<ListOfBanksBranches, Integer>{
    
}
