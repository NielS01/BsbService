package com.ns.bsb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BranchDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String bsbNumber;
	private String bankCode;
	private String branchName;
	
	protected BranchDetails() {}
	
	public BranchDetails(String bsbNumber, String bankCode, String branchName) {
		this.bsbNumber = bsbNumber;
		this.bankCode = bankCode;
		this.branchName = branchName;
	}	
	
	public String getBsbNumber() {
		return bsbNumber;
	}
	public void setBsbNumber(String bsbNumber) {
		this.bsbNumber = bsbNumber;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}	
	

}
