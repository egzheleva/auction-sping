package com.auction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auction.dao.ItemDao;
import com.auction.model.Item;
import com.auction.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemDao itemDao;

	public List<Item> getItemsForCampaign(Long campaignId) {
		return itemDao.getItemsForCampaign(campaignId);
	}

	public Item getItemById(Long itemId) {
		return itemDao.getItemById(itemId);
	}
	
	public Item submitBid(Item item) {
		itemDao.submitBid(item);
		return itemDao.getItemById(item.getItemId());
	}

	public List<Item> getUserItems(Long userId) {
		return itemDao.getUserItems(userId);
	}
	

}
