package com.sl.ms.inventorymanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sl.ms.inventorymanagement.entity.Products;

public interface OrderItemDao  extends JpaRepository<Products, Integer>{

}
