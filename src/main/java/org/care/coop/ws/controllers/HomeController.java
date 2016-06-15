package org.care.coop.ws.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class HomeController {

	@RequestMapping("/care-coop")
	public String index() {
		return "/index/index";
	}
	
	@RequestMapping("/care-coop/home")
	public String home() {
		return "/home/home";
	}
	
	@RequestMapping("/care-coop/verifier")
	public String verifier() {
		return "/home/verifier/verifier";
	}
	
	@RequestMapping("/care-coop/cashcollection")
	public String cashCollection() {
		return "/home/cashcollection/cashcollection";
	}
	
	@RequestMapping("/care-coop/cashdisbursement")
	public String cashDisbursement() {
		return "/home/cashdisbursement/cashdisbursement";
	}
	
	@RequestMapping("/care-coop/journalvoucher")
	public String journalVoucher() {
		return "/home/journalvoucher/journalvoucher";
	}
	
	@RequestMapping("/care-coop/generalledger")
	public String generalLedger() {
		return "/home/generalledger/generalledger";
	}
	
	@RequestMapping("/care-coop/subsidiaryledger")
	public String subsidiaryLedger() {
		return "/home/subsidiaryledger/subsidiaryledger";
	}
	
	@RequestMapping("/care-coop/setupcomputation")
	public String setupComputation() {
		return "/home/setupcomputation/setupcomputation";
	}
	
	@RequestMapping("/care-coop/utility")
	public String utility() {
		return "/home/utility/utility";
	}
	
}
