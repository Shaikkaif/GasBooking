package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bank {
	
	public Bank() {
		super();
	}
	public Bank(long bankId, String bankName, String ifscNo, String bankAddress) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.ifscNo = ifscNo;
		this.bankAddress = bankAddress;
	}
	@Id
	private long bankId;
	private String bankName;
	private String ifscNo;
	private String bankAddress;
	public long getBankId() {
		return bankId;
	}
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscNo() {
		return ifscNo;
	}
	public void setIfscNo(String ifscNo) {
		this.ifscNo = ifscNo;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	

}

