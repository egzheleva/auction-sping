package com.auction.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auction.model.Campaign;
import com.auction.model.Item;
import com.auction.service.CampaignService;
import com.auction.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	@GetMapping(value = "/campaignItems", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getItemsforCampaign(Long campaignId) {
		
		return itemService.getItemsForCampaign(campaignId);
	}
	
	@GetMapping(value = "/itemById", produces=MediaType.APPLICATION_JSON_VALUE)
	public Item getItemById(Long itemId) {
		
		return itemService.getItemById(itemId);
	}
	
	@PostMapping(value = "/submitBid")
	public Item submitBid(@RequestBody Item item) {
		return itemService.submitBid(item);
	}
	
	@GetMapping(value = "/getUserItems", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getUserItems(Long userId) {
		
		return itemService.getUserItems(userId);
	}

}
