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

	@GetMapping(value = "/employees", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Auction> getEmployees() {
		return null;
	}

}
