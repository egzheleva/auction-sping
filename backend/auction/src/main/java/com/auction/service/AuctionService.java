package com.auction.service;

import java.util.List;

import com.auction.model.Auction;

public interface AuctionService {

	void insertEmployee(Auction emp);

	void insertEmployees(List<Auction> employees);

	void getAllEmployees();

	void getEmployeeById(String empid);
}
