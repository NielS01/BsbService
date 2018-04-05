package com.ns.bsb.beans;

public class BankDetails {
	private String bankCode;
	private String bankName;
	private String bankPrefix;
	
	
	public BankDetails(String line, String separator)
	{
		String[] fields = null;
		if (line != null) 
		{
				fields = line.split(separator);
				bankCode = fields[0];
				bankName = fields[1].replace("\"", ""); // remove double quotes 
				bankPrefix = fields[2];				

		}

	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankPrefix() {
		return bankPrefix;
	}
	public void setBankPrefix(String bankPrefix) {
		this.bankPrefix = bankPrefix;
	}
	
	
}
