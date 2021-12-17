package com.auction.dao;

import java.util.List;

import com.auction.model.Auction;

public interface AuctionDao {

	void insertEmployee(Auction cus);

	void insertEmployees(List<Auction> employees);

	List<Auction> getAllEmployees();

	Auction getEmployeeById(String empId);

}
