package com.jsp.bank_project.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BankUser {
	@Id
	private long accountNumber=(long) Math.floor(Math.random()*1000000000);
	private long adhharNumber;
    private String name;
    private long phoneNumber;
    private long balance;
    private String pinCode;
	   private String village;
	   private String mondel;
	   private String district;
	   private String state;
	   private String country;
	   private String password;
	   private String BranchName;
	@ManyToOne
	@JsonIgnore
	   private ListOfBanksBranches listOfBanksBranches;
	   /**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
		
		/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return BranchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		BranchName = branchName;
	}

		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}  
	/**
	 * @return the accountNumber
	 */
	public long getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the adhharNumber
	 */
	public long getAdhharNumber() {
		return adhharNumber;
	}
	/**
	 * @param adhharNumber the adhharNumber to set
	 */
	public void setAdhharNumber(long adhharNumber) {
		this.adhharNumber = adhharNumber;
	}
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the phoneNumber
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the balance
	 */
	public long getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(long balance) {
		this.balance = balance;
	}
	/**
	 * @return the userAddress
	 */
	/**
	 * @return the id
	 */
	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	/**
	 * @return the village
	 */
	public String getVillage() {
		return village;
	}
	/**
	 * @param village the village to set
	 */
	public void setVillage(String village) {
		this.village = village;
	}
	/**
	 * @return the mondel
	 */
	public String getMondel() {
		return mondel;
	}
	/**
	 * @param mondel the mondel to set
	 */
	public void setMondel(String mondel) {
		this.mondel = mondel;
	}
	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	   
    
}
