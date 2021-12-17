package com.auction.service;

import java.util.List;

import com.auction.model.Item;

public interface ItemService {
	List<Item> getItemsForCampaign(Long campaignId);
	Item getItemById(Long itemId);
	Item submitBid(Item item);
	List<Item> getUserItems(Long userId);
}
