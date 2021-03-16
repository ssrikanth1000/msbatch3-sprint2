package com.sl.ms.inventorymanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.ms.inventorymanagement.dao.OrderItemDao;
import com.sl.ms.inventorymanagement.entity.Products;
import com.sl.ms.inventorymanagement.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderItemDao orderItemDao;
	@Override
	public List<Products> listOfOrders() {
		List<Products> list =orderItemDao.findAll();
		System.out.println("list,,.."+list);
		return list;
	}
	@Override
	public Products addItems(Products order) {
		orderItemDao.save(order);
		return order;
		
	}
	@Override
	public Products getOrders(int order) {
		return orderItemDao.getOne(order);
	}
	@Override
	public void deleteOrder(int orderid) {
		Products order= orderItemDao.getOne(orderid);
		orderItemDao.delete(order);
		
	}

}
