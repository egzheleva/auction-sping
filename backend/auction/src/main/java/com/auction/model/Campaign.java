package com.auction.model;

import java.util.Date;
import java.util.List;

public class Campaign {
	private Long campaignId;
	private String campaignName;
	private String campaignDescription;
	private List<Image> imageNames;
	private List<Item> items;
	private Date validFrom;
	private Date validTo;

	public Campaign() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Campaign(Long campaignId, String campaignName, String campaignDescription, List<Item> items, Date validFrom, Date validTo) {
		super();
		this.campaignId = campaignId;
		this.campaignName = campaignName;
		this.campaignDescription = campaignDescription;
		this.items = items;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	public Long getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getCampaignDescription() {
		return campaignDescription;
	}

	public void setCampaignDescription(String campaignDescription) {
		this.campaignDescription = campaignDescription;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Image> getImageNames() {
		return imageNames;
	}

	public void setImageNames(List<Image> imageNames) {
		this.imageNames = imageNames;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campaignId == null) ? 0 : campaignId.hashCode());
		result = prime * result + ((campaignDescription == null) ? 0 : campaignDescription.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((campaignName == null) ? 0 : campaignName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campaign other = (Campaign) obj;
		if (campaignId == null) {
			if (other.campaignId != null)
				return false;
		} else if (!campaignId.equals(other.campaignId))
			return false;
		if (campaignDescription == null) {
			if (other.campaignDescription != null)
				return false;
		} else if (!campaignDescription.equals(other.campaignDescription))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (campaignName == null) {
			if (other.campaignName != null)
				return false;
		} else if (!campaignName.equals(other.campaignName))
			return false;
		return true;
	}

}
