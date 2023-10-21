package com.jsp.bank_project.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ListOfBanksBranches {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String bankName;
   private String manager;
   @OneToOne
   private BranchAddress branchAddress;
   @ManyToOne
   @JoinColumn
   @JsonIgnore
   private BankOwner bankOwner;
   @OneToMany
   @JoinColumn
   private List<BankUser> bankUsers;
  
/**
 * @return the bankUsers
 */
public List<BankUser> getBankUsers() {
	return bankUsers;
}
/**
 * @param bankUsers the bankUsers to set
 */
public void setBankUsers(List<BankUser> bankUsers) {
	this.bankUsers = bankUsers;
}
/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the bankName
 */
public String getBankName() {
	return bankName;
}
/**
 * @param bankName the bankName to set
 */
public void setBankName(String bankName) {
	this.bankName = bankName;
}
/**
 * @return the manager
 */
public String getManager() {
	return manager;
}
/**
 * @param manager the manager to set
 */
public void setManager(String manager) {
	this.manager = manager;
}
/**
 * @return the branchAddress
 */
public BranchAddress getBranchAddress() {
	return branchAddress;
}
/**
 * @param branchAddress the branchAddress to set
 */
public void setBranchAddress(BranchAddress branchAddress) {
	this.branchAddress = branchAddress;
}
/**
 * @return the bankOwner
 */
public BankOwner getBankOwner() {
	return bankOwner;
}
/**
 * @param bankOwner the bankOwner to set
 */
public void setBankOwner(BankOwner bankOwner) {
	this.bankOwner = bankOwner;
}
   
}
