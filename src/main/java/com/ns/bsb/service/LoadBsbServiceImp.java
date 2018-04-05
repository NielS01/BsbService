package com.ns.bsb.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ns.bsb.beans.BranchDetailDTO;
import com.ns.bsb.entity.BranchDetails;
import com.ns.bsb.repository.BranchDetailsRepository;

@Component
public class LoadBsbServiceImp implements LoadBsbService {
	
	private static final String REGEX_SEPARATOR = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"; // split on the comma only if that comma has zero, or an even number of quotes ahead of it.
	
	@Autowired
	private BranchDetailsRepository branchDetailsRepository;
	
	 List<BranchDetailDTO> bsbReadFile(String fName) {
		InputStream is;
		try {
				is = new FileInputStream(new File(fName));
				BufferedReader br = new BufferedReader(new InputStreamReader(is));			 
				
				List<BranchDetailDTO> branchList =  br.lines().map((e) -> {return new BranchDetailDTO(e, REGEX_SEPARATOR);}).collect(Collectors.toList());
				
				return branchList;
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return null;
	}	

	 List<BranchDetailDTO> bsbReadFile(File bsbFile) {
		InputStream is;
		try {
				is = new FileInputStream(bsbFile);
				BufferedReader br = new BufferedReader(new InputStreamReader(is));			 
				
				List<BranchDetailDTO> branchList =  br.lines().map((e) -> {return new BranchDetailDTO(e, REGEX_SEPARATOR);}).collect(Collectors.toList());
				
				return branchList;
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return null;
	}	 
	@Override
	public void printBranchDetails(String fName) {
		List<BranchDetailDTO> bankList = bsbReadFile(fName);
		
		for (BranchDetailDTO bankDetails : bankList) {
			
			String message = String.format("bsb=[%s],bank=[%s],branch=[%s]", bankDetails.getBsbNumber(), bankDetails.getBankCode(), bankDetails.getBranchName());
			System.out.println(message);
		}
	}
	
	@Override
	public void printBranchDetails(File bsbFile) {
		List<BranchDetailDTO> bankList = bsbReadFile(bsbFile);
		
		for (BranchDetailDTO bankDetails : bankList) {
			
			String message = String.format("bsb=[%s],bank=[%s],branch=[%s]", bankDetails.getBsbNumber(), bankDetails.getBankCode(), bankDetails.getBranchName());
			System.out.println(message);
		}
	}
	
	@Override
	public void printBranchDetailsFromUrl(String bsbUrl) {
		final String tempFile = "TEMP-Bsbfile.txt";
		File bsbFile = new File(tempFile);  // Create temporary file
		
		System.out.println("Temporary File is: " + bsbFile.getAbsolutePath());
		try {
			
			URL targetUrl = new URL(bsbUrl);
			FileUtils.copyURLToFile(targetUrl, bsbFile);
			List<BranchDetailDTO> bankList = bsbReadFile(bsbFile);
			
			for (BranchDetailDTO bankDetails : bankList) {
				
				String message = String.format("bsb=[%s],bank=[%s],branch=[%s]", bankDetails.getBsbNumber(), bankDetails.getBankCode(), bankDetails.getBranchName());
				System.out.println(message);
			}
			bsbFile.deleteOnExit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void saveBranchDetailsFromUrl(String bsbUrl) {
		final String tempFile = "TEMP-Bsbfile.txt";
		File bsbFile = new File(tempFile);  // Create temporary file
		
		System.out.println("Temporary File is: " + bsbFile.getAbsolutePath());
		try {
			
			URL targetUrl = new URL(bsbUrl);
			FileUtils.copyURLToFile(targetUrl, bsbFile);
			List<BranchDetailDTO> bankList = bsbReadFile(bsbFile);
			
			for (BranchDetailDTO bd : bankList) {
				BranchDetails branchDet = new BranchDetails(bd.getBsbNumber(), bd.getBankCode(), bd.getBranchName());
				branchDetailsRepository.save(branchDet);
				
				String message = String.format("bsb=[%s],bank=[%s],branch=[%s]", bd.getBsbNumber(), bd.getBankCode(), bd.getBranchName());
				// System.out.println(message);
			}
			bsbFile.deleteOnExit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Override
	public List<BranchDetailDTO> findByBSB(String bsbNumber) {
		List<BranchDetails> listOfBranchDet =  branchDetailsRepository.findBybsbNumber(bsbNumber);
		List<BranchDetailDTO> result = null;
		if (listOfBranchDet != null && listOfBranchDet.size() > 0) {
			result = listOfBranchDet.stream().map(bd -> new BranchDetailDTO(bd)).collect(Collectors.toList());
		}
		return result;
	}
}
