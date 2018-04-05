package com.ns.bsb.beans;

import com.ns.bsb.entity.BranchDetails;

public class BranchDetailDTO {
	
		private String bsbNumber;
		private String bankCode;
		private String branchName;
		

		public BranchDetailDTO(String bsbNumber, String bankCode, String branchName) {
			this.bsbNumber = bsbNumber;
			this.bankCode = bankCode;
			this.branchName = branchName;
		}			
		
		public BranchDetailDTO(BranchDetails bd) {
			this.bsbNumber = bd.getBsbNumber();
			this.bankCode = bd.getBankCode();
			this.branchName = bd.getBranchName();			
		}
		public BranchDetailDTO(String line, String separator)
		{
			if (line != null) {
				String[] fields = line.split(separator);
				
				bsbNumber = fields[0].replace("-", "").replace("\"", "");
				bankCode = fields[1].replace("\"", "");			
				branchName = fields[2].replace("\"", ""); // remove double quotes 

			}

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
