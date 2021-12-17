package com.auction.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.auction.model.Campaign;
import com.auction.model.Item;
import com.auction.service.CampaignService;

@RestController
@RequestMapping("/campaign")
public class CampaignController {
	
	@Autowired
	private CampaignService campaignService;
	
	
	
	@GetMapping(value = "/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Campaign> getAllCampaigns() {
		
		return campaignService.getAllCampaigns();
	}
	
	@PostMapping(value="/createNewCampaign", consumes= "multipart/form-data") 
	public Campaign createNewCampaign(@RequestParam("filesArray") MultipartFile[] filesArray, 
	        @RequestParam(value = "campaignName", required = false) String campaignName,
	        @RequestParam(value = "campaignDescription", required = false) String campaignDescription,
	        @RequestParam(value = "validFrom", required = false) Date validFrom,
	        @RequestParam(value = "validTo", required = false) Date validTo) {
		
		Campaign campaign = new Campaign();
		campaign.setCampaignName(campaignName);
		campaign.setCampaignDescription(campaignDescription);
		campaign.setValidFrom(validFrom);
		campaign.setValidTo(validTo);
		campaignService.createNewCampaign(campaign, filesArray);
		return new Campaign();
	}

}
