package com.auction.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.auction.dao.ItemDao;
import com.auction.model.Auction;
import com.auction.model.Item;
import com.auction.model.Image;

@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTmpl;

	public List<Item> getItemsForCampaign(Long campaignId) {
		StringBuilder sql = new StringBuilder();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("campaignId", campaignId);

		sql.append(" SELECT * FROM item where campaignId = :campaignId ");

		List<Item> items = jdbcTmpl.query(sql.toString(), params, new ResultSetExtractor<List<Item>>() {
			public List<Item> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Item> items = new ArrayList<Item>();

				while (rs.next()) {
					Item item = new Item();
					item.setItemId(rs.getLong("id"));
					item.setCampaignId(rs.getLong("campaignId"));
					item.setBidderId(rs.getLong("bidderId"));
					item.setCurrentPrice(rs.getDouble("currentPrice"));
					item.setItemName(rs.getString("name"));
					item.setItemDescription(rs.getString("description"));

					List<Image> itemImages = getImagesForItem(item.getItemId());
					item.setImageNames(itemImages);
					items.add(item);

				}
				return items;
			}
		});
		return items;
	}

	public List<Image> getImagesForItem(Long itemId) {

		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource sqlParams = new MapSqlParameterSource();
		sqlParams.addValue("itemId", itemId);

		sql.append(" SELECT itemId, imageName FROM item_image where itemId = :itemId ");

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

	public Item getItemById(Long itemId) {
		StringBuilder sql = new StringBuilder();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("itemId", itemId);

		sql.append(" SELECT * FROM item where id = :itemId ");

		Item item = jdbcTmpl.query(sql.toString(), params, new ResultSetExtractor<Item>() {
			public Item extractData(ResultSet rs) throws SQLException, DataAccessException {
				Item item = new Item();

				while (rs.next()) {
					item.setItemId(rs.getLong("id"));
					item.setCampaignId(rs.getLong("campaignId"));
					item.setBidderId(rs.getLong("bidderId"));
					item.setCurrentPrice(rs.getDouble("currentPrice"));
					item.setItemName(rs.getString("name"));
					item.setItemDescription(rs.getString("description"));

					List<Image> itemImages = getImagesForItem(item.getItemId());
					item.setImageNames(itemImages);
				}
				return item;
			}
		});
		return item;
	}

	public void submitBid(Item item) {
		//TODO Take the User here and it's userId in order to update the user's bidded items
		StringBuilder sql = new StringBuilder();
		sql.append(" update item ");
		sql.append(" set currentPrice = :newPrice, ");
		sql.append(" bidderId = 1 "); // TODO remove this harcoded thing
		sql.append(" where id = :itemId    ");

		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("newPrice", item.getNewPrice());
		paramMap.addValue("itemId", item.getItemId());

		jdbcTmpl.update(sql.toString(), paramMap);
	}

	public List<Item> getUserItems(Long userId) {
		StringBuilder sql = new StringBuilder();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);

		sql.append(" SELECT * FROM item where bidderId = :userId ");

		List<Item> items = jdbcTmpl.query(sql.toString(), params, new ResultSetExtractor<List<Item>>() {
			public List<Item> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Item> items = new ArrayList<Item>();

				while (rs.next()) {
					Item item = new Item();
					item.setItemId(rs.getLong("id"));
					item.setCampaignId(rs.getLong("campaignId"));
					item.setBidderId(rs.getLong("bidderId"));
					item.setCurrentPrice(rs.getDouble("currentPrice"));
					item.setItemName(rs.getString("name"));
					item.setItemDescription(rs.getString("description"));

					List<Image> itemImages = getImagesForItem(item.getItemId());
					item.setImageNames(itemImages);
					items.add(item);

				}
				return items;
			}
		});
		return items;
	}
}
