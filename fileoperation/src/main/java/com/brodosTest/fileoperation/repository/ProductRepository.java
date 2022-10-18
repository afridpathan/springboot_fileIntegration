package com.brodosTest.fileoperation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brodosTest.fileoperation.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findByName(String name);
	Product findByArticleNo (String articleNo);
	
	Product findByNameAndArticleNo (String name, String articleNo);
	
	List<Product> findByPriceGreaterThanEqual (double price);
}
