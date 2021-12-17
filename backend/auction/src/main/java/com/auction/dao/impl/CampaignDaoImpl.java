package com.auction.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.auction.dao.CampaignDao;

import com.auction.model.Campaign;
import com.auction.model.Image;
import com.auction.model.Item;

@Repository
public class CampaignDaoImpl implements CampaignDao {

/*	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}*/

	@Autowired
	private NamedParameterJdbcTemplate jdbcTmpl;
	
	
	public List<Campaign> getAllCampaigns() {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT * FROM campaign ");
		
		
		List<Campaign> campaigns = jdbcTmpl.query(sql.toString(), new ResultSetExtractor<List<Campaign>>() {
			public List<Campaign> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Campaign> campaigns = new ArrayList<Campaign>();

				while (rs.next()) {
					Campaign campaign = new Campaign();
					campaign.setCampaignId(rs.getLong("campaignId"));
					campaign.setCampaignName(rs.getString("campaignName"));
					campaign.setCampaignDescription(rs.getString("campaignDescr"));
					
					//campaign.setItems(getItemsForCampaign(campaign.getCampaignId()));
					
					List<Image> campaignImages = getImagesForCampaign(campaign.getCampaignId());
					campaign.setImageNames(campaignImages);
					
					
					campaigns.add(campaign);
				}
				return campaigns;
			}
		});
		return campaigns;
	}

	public List<Item> getItemsForCampaign(Long campaignId) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT * FROM item WHERE campaignId = ? ");
		
		List<Item> items = jdbcTmpl.query(sql.toString(), new ResultSetExtractor<List<Item>>() {
			public List<Item> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Item> items = new ArrayList<Item>();
				
				while (rs.next()) {
					Item item = new Item();
					item.setItemId(rs.getLong("id"));
					item.setItemDescription(rs.getString("description"));
					item.setItemName(rs.getString("name"));
					item.setCurrentPrice(rs.getDouble("currentPrice"));
					item.setBidderId(rs.getLong("bidderId"));
					items.add(item);
				}
				return items;
			}
		});
		
		return items;
	}
	
	
	public List<Image> getImagesForCampaign(Long campaignId) {
		StringBuilder sql = new StringBuilder();

		MapSqlParameterSource sqlParams = new MapSqlParameterSource();
		sqlParams.addValue("campaignId", campaignId);

		sql.append(" SELECT campaignId, imageName FROM campaign_image where campaignId = :campaignId ");

		List<Image> images = jdbcTmpl.query(sql.toString(), sqlParams, new ResultSetExtractor<List<Image>>() {
			public List<Image> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Image> images = new ArrayList<Image>();

				while (rs.next()) {
					Image image = new Image();
					image.setImageName(rs.getString("imageName"));
					images.add(image);
				}
				return images;
			}
		});
		return images;
	}

	public Long createNewCampaign(Campaign campaign) {
		StringBuilder sql = new StringBuilder();

		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		sql.append(" INSERT into campaign ( campaignName, campaignDescr, validFrom, validTo) ");
		sql.append(" values ( :campaignName, :campaignDescr, :validFrom, :validTo) ");
		
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue("campaignName", campaign.getCampaignName())
				.addValue("campaignDescr", campaign.getCampaignDescription())
				.addValue("validFrom", campaign.getValidFrom())
				.addValue("validTo", campaign.getValidTo());
				long nb = jdbcTmpl.update(sql.toString(), parameters, keyHolder,new String[] { "ID" });
		
		return keyHolder.getKey().longValue();
	}
	
	
	public void addImageToCampaign(Long campaignId, String imageName) {
		StringBuilder sql = new StringBuilder();

		
		sql.append(" INSERT into campaign_image ( campaignId, imageName) ");
		sql.append(" values ( :campaignId, :imageName) ");
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("campaignId", campaignId);
		paramMap.put("imageName", imageName);
		
		
		jdbcTmpl.update(sql.toString(), paramMap);
	}
	
	
}
