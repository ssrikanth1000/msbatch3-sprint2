/**
 * 
 */
package com.sl.ms.inventorymanagement.service;

import java.util.List;

import com.sl.ms.inventorymanagement.entity.Products;

/**
 * @author Srikanth
 *
 */
public interface OrderService {
	public List<Products> listOfOrders();
	public Products addItems(Products order);
	public Products getOrders(int order);
	void deleteOrder(int orderid);

}
