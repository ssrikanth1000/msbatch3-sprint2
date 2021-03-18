package com.sl.ms.inventorymanagement.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sl.ms.inventorymanagement.entity.Products;
import com.sl.ms.inventorymanagement.serviceimpl.OrderServiceImpl;

@RestController
public class MyController {
	private static final Logger LOGGER = LogManager.getLogger(MyController.class);
	@Autowired
	OrderServiceImpl orderServiceImpl;
	
	
	@GetMapping("/products/getHystrix")
	public String getHystrix() {
		LOGGER.info("entery into orders");
		return "hello";
	}
	@GetMapping("/products")
	public List<Products> orders() {
		List<Products> list=orderServiceImpl.listOfOrders();
		return list;
	}
	
	@GetMapping("/products/{orderId}")
	public Products getOrders(@PathVariable String orderId) {
		return orderServiceImpl.getOrders(Integer.parseInt(orderId));
	}
	
	@PostMapping(path="/products",consumes="application/json")
	public Products addOrders(@RequestBody Products orders) {
		return orderServiceImpl.addItems(orders);
	}
	@DeleteMapping(path = "/products/{order_id}")
	public String deleteOrder(@PathVariable(name = "order_id") int orderid) {
		orderServiceImpl.deleteOrder(orderid);
		return "deleted order successfully";
	}
}
