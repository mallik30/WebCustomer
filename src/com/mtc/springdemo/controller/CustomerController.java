package com.mtc.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtc.springdemo.dao.CustomerDAO;
import com.mtc.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject the customere dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customer from the dao
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		//add the cusotomers to the spring mvc model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
}
