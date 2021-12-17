package com.auction.dao;

import java.util.List;

import com.auction.model.Campaign;

public interface CampaignDao {
	public List<Campaign> getAllCampaigns();
	public Long createNewCampaign(Campaign campaign);
	public void addImageToCampaign(Long campaignId, String imageName);
}
