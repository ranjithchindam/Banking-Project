package com.jsp.bank_project.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BranchAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String branchPincode;
  private String branchCountry;
  private String branchState;
  private String branchVillage;
  private String branchHouseNo;
  @OneToOne
  @JsonIgnore
  private ListOfBanksBranches listOfBanksBranches;
/**
 * @return the listOfBanksBranches
 */
public ListOfBanksBranches getListOfBanksBranches() {
	return listOfBanksBranches;
}
/**
 * @param listOfBanksBranches the listOfBanksBranches to set
 */
public void setListOfBanksBranches(ListOfBanksBranches listOfBanksBranches) {
	this.listOfBanksBranches = listOfBanksBranches;
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
 * @return the branchPincode
 */
public String getBranchPincode() {
	return branchPincode;
}
/**
 * @param branchPincode the branchPincode to set
 */
public void setBranchPincode(String branchPincode) {
	this.branchPincode = branchPincode;
}
/**
 * @return the branchCountry
 */
public String getBranchCountry() {
	return branchCountry;
}
/**
 * @param branchCountry the branchCountry to set
 */
public void setBranchCountry(String branchCountry) {
	this.branchCountry = branchCountry;
}
/**
 * @return the branchState
 */
public String getBranchState() {
	return branchState;
}
/**
 * @param branchState the branchState to set
 */
public void setBranchState(String branchState) {
	this.branchState = branchState;
}
/**
 * @return the branchVillage
 */
public String getBranchVillage() {
	return branchVillage;
}
/**
 * @param branchVillage the branchVillage to set
 */
public void setBranchVillage(String branchVillage) {
	this.branchVillage = branchVillage;
}
/**
 * @return the branchHouseNo
 */
public String getBranchHouseNo() {
	return branchHouseNo;
}
/**
 * @param branchHouseNo the branchHouseNo to set
 */
public void setBranchHouseNo(String branchHouseNo) {
	this.branchHouseNo = branchHouseNo;
}

}
