package com.sl.ms.inventorymanagement;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sl.ms.inventorymanagement.entity.Products;
import com.sl.ms.inventorymanagement.serviceimpl.OrderServiceImpl;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
class InventoryManagementApplicationTests {
	@MockBean
	OrderServiceImpl orderServiceImpl;
	@Test
	void contextLoads() {
	}
	@Test
	public void getUsers() {
		List<Products> list =new ArrayList<Products>();
		Mockito.when(orderServiceImpl.listOfOrders()).thenReturn(list);
		assertEquals(0,list.size());
	}
	
	@Test
	public void deleteOrder() {
		orderServiceImpl.deleteOrder(0);
	}
	@Test
	public void addOrders() {
		Products order =new Products();
		order.setName("item1");
		Mockito.when(orderServiceImpl.addItems(order)).thenReturn(order);
		assertEquals("item1",order.getName());
	}
}
