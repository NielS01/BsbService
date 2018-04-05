package com.ns.bsb.service;

import java.io.File;
import java.util.List;

import com.ns.bsb.beans.BranchDetailDTO;

public interface LoadBsbService {
	public void printBranchDetails(File bsbFile);
	
	public void printBranchDetails(String bsbFile);
	
	public void printBranchDetailsFromUrl(String bsbUrl);
	
	public void saveBranchDetailsFromUrl(String bsbUrl);
	
	List<BranchDetailDTO> findByBSB(String bsbNumber);
}
