package com.auction.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.auction.model.Campaign;

public interface CampaignService {
	public List<Campaign> getAllCampaigns();
	public void createNewCampaign(Campaign campaing, MultipartFile[] files);

}
