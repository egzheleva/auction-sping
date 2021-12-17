package com.auction.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.auction.dao.CampaignDao;
import com.auction.model.Campaign;
import com.auction.model.Image;
import com.auction.service.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService {

	@Autowired
	CampaignDao campaignDao;

	public List<Campaign> getAllCampaigns() {
		List<Campaign> campaigns = campaignDao.getAllCampaigns();
		for (Campaign campaign : campaigns) {
			System.out.println(campaign.toString());
		}

		return campaigns;

	}


	@Value("${spring.datasource.pathToCampaignImages}")
	String pathToCampaignImages;

	public void createNewCampaign(Campaign campaign, MultipartFile[] files) {
		
		List<Image> images = new ArrayList<Image>();
		
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				try {
					String imageName = UUID.randomUUID().toString() + ".png";
					byte[] bytes = file.getBytes();
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(new File(pathToCampaignImages + imageName)));
					stream.write(bytes);
					stream.close();
					Image image = new Image();
					image.setImageName(imageName);
					images.add(image);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		campaign.setImageNames(images);
		
		Long newCampaignId = campaignDao.createNewCampaign(campaign);
		
		//save all the images for the new campaign in the db
		for (Image image : campaign.getImageNames()) {
			campaignDao.addImageToCampaign(newCampaignId.longValue(), image.getImageName());
		}

	}

}
