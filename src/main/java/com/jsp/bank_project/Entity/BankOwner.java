package com.jsp.bank_project.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BankOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;
	private String ownerName;
	private String ownerEmail;
	private String ownerPhone;
	private long pinCode;
	   private String village;
	   private String mondel;
	   private String district;
	   private String state;
	   private String country;
	  @OneToMany(mappedBy = "bankOwner",fetch = FetchType.EAGER)
	  private List<ListOfBanksBranches> banks;
	  
	
	
	/**
	 * @return the banks
	 */
	public List<ListOfBanksBranches> getBanks() {
		return banks;
	}
	/**
	 * @param banks the banks to set
	 */
	public void setBanks(List<ListOfBanksBranches> banks) {
		this.banks = banks;
	}
	
	/**
	 * @return the ownerId
	 */
	public int getOwnerId() {
		return ownerId;
	}
	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	/**
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}
	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	/**
	 * @return the ownerEmail
	 */
	public String getOwnerEmail() {
		return ownerEmail;
	}
	/**
	 * @param ownerEmail the ownerEmail to set
	 */
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	/**
	 * @return the ownerPhone
	 */
	public String getOwnerPhone() {
		return ownerPhone;
	}
	/**
	 * @param ownerPhone the ownerPhone to set
	 */
	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	/**
	 * @return the pinCode
	 */
	public long getPinCode() {
		return pinCode;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(long pinCode) {
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
