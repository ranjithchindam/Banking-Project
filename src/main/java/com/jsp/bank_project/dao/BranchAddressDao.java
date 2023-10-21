package com.jsp.bank_project.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bank_project.Entity.BranchAddress;
import com.jsp.bank_project.dto.BranchAddressDto;
import com.jsp.bank_project.repository.BranchAddressRepo;

@Repository
public class BranchAddressDao {
  @Autowired
  private BranchAddressRepo repo;

public BranchAddress saveAddress(BranchAddress branchAddress) {
		return repo.save(branchAddress);
}

public BranchAddress updateAddress(int addressId, BranchAddress branchAddress) {
	Optional<BranchAddress> optional = repo.findById(addressId);
	if (optional.isPresent())
	{
		BranchAddress branchAddress2=optional.get();
		branchAddress.setId(branchAddress2.getId());
		return branchAddress;
	}
	return null;
}

public BranchAddress getAddressById(int addressId) {
	Optional<BranchAddress> optional = repo.findById(addressId);
	if (optional.isPresent())
	{
		return optional.get();
	}
	return null;
}

public BranchAddress deleteAddressById(int addressId) {
	Optional<BranchAddress> optional = repo.findById(addressId);
	if (optional.isPresent())
	{
		BranchAddress branchAddress2=optional.get();
		repo.delete(optional.get() );
		return branchAddress2;
	}
	return null;
}
  
}
