package com.auction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.auction.model.Auction;
import com.auction.service.AuctionService;


@SpringBootApplication
public class AuctionApplication {

	@Autowired
	AuctionService auctionService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AuctionApplication.class, args);
		AuctionService employeeService = context.getBean(AuctionService.class);

		Auction emp = new Auction();
		emp.setEmpId("emp");
		emp.setName("emp");

		Auction emp1 = new Auction();
		emp1.setEmpId("emp1");
		emp1.setName("emp1");

		Auction emp2 = new Auction();
		emp2.setEmpId("emp2");
		emp2.setName("emp2");

		employeeService.insertEmployee(emp);

		List<Auction> employees = new ArrayList<Auction>();
		employees.add(emp1);
		employees.add(emp2);
		employeeService.insertEmployees(employees);

		employeeService.getAllEmployees();

		employeeService.getEmployeeById(emp1.getEmpId());

	}

}
