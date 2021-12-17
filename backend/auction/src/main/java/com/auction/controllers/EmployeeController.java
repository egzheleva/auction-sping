package com.auction.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auction.model.Auction;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	//private List<Auction> employees = createList();

	@GetMapping(value = "/employees", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Auction> getEmployees() {
		return null;
	}
	
	private static List<Auction> createList() {
		List<Auction> tempEmployees = new ArrayList<Auction>();
		/*Auction emp1 = new Auction();
		emp1.setName("emp1");
		emp1.setDesignation("manager");
		emp1.setEmpId("1");
		emp1.setSalary(3000);

		Auction emp2 = new Auction();
		emp2.setName("emp2");
		emp2.setDesignation("developer");
		emp2.setEmpId("2");
		emp2.setSalary(3000);
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);*/
		return tempEmployees;
	}
}
