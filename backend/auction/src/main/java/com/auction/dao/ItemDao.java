package com.auction.dao;

import java.util.List;

import com.auction.model.Item;

public interface ItemDao {
	List<Item> getItemsForCampaign(Long campaignId);
	Item getItemById(Long itemId);
	void submitBid(Item item);
	List<Item> getUserItems(Long userId);
}
