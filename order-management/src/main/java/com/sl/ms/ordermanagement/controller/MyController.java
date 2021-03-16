package com.sl.ms.ordermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sl.ms.ordermanagement.entity.Orders;
import com.sl.ms.ordermanagement.serviceimpl.OrderServiceImpl;

@RestController
public class MyController {
	
	@Autowired
	OrderServiceImpl orderServiceImpl;
	@GetMapping("/orders")
	public String orders() {
		orderServiceImpl.listOfOrders();
		return "orders";
	}
	
	@GetMapping("/orders/{orderId}")
	public Orders getOrders(@PathVariable String orderId) {
		return orderServiceImpl.getOrders(Integer.parseInt(orderId));
	}
	
	@PostMapping(path="/orders",consumes="application/json")
	public Orders addOrders(@RequestBody Orders orders) {
		return orderServiceImpl.addItems(orders);
	}
	@DeleteMapping(path = "/orders/{order_id}")
	public String deleteOrder(@PathVariable(name = "order_id") int orderid) {
		orderServiceImpl.deleteOrder(orderid);
		return "deleted order successfully";
	}
}
