package com.auction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auction.dao.AuctionDao;
import com.auction.model.Auction;
import com.auction.service.AuctionService;

@Service
public class AuctionServiceImpl implements AuctionService {

	@Autowired
	AuctionDao employeeDao;

	public void insertEmployee(Auction employee) {
		employeeDao.insertEmployee(employee);
	}

	public void insertEmployees(List<Auction> employees) {
		employeeDao.insertEmployees(employees);
	}

	public void getAllEmployees() {
		List<Auction> employees = employeeDao.getAllEmployees();
		for (Auction employee : employees) {
			System.out.println(employee.toString());
		}
	}

	public void getEmployeeById(String empId) {
		Auction employee = employeeDao.getEmployeeById(empId);
		System.out.println(employee);
	}

}
