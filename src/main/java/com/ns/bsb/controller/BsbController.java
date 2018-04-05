package com.ns.bsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ns.bsb.beans.BranchDetailDTO;
import com.ns.bsb.service.LoadBsbService;

@RestController
@RequestMapping("/bsbService")
public class BsbController {

	// private static String bsbFile = "C:\\ECLIPSE_MARS\\WS01\\BSBServices\\src\\main\\data\\BSBDirectoryMar18-264.csv";
	@Autowired
	LoadBsbService	loadBsb;
	
	@RequestMapping( method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<BranchDetailDTO> getBankDetails(@RequestParam String bsbNumber)  {
		
		return loadBsb.findByBSB(bsbNumber);
	}
	
	
	@RequestMapping(value="load", method = RequestMethod.POST)
	public @ResponseBody String loadBsbFile(@RequestParam String fileName) {
		loadBsb.printBranchDetails(fileName);
		//return HttpStatus.OK;
		return "Loaded file"; 
	}
	
	@RequestMapping(value="loadFromUrl", method = RequestMethod.POST)
	public @ResponseBody String loadBsbFilefromUrl(@RequestParam String bsbUrl) {
		loadBsb.saveBranchDetailsFromUrl(bsbUrl);
		
		//return HttpStatus.OK;
		return "Loaded file"; 
	}
}
