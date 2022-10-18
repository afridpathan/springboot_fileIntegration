package com.brodosTest.fileoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brodosTest.fileoperation.entity.Product;
import com.brodosTest.fileoperation.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping ("/processFile")
	public String processFile () throws Exception {
		return productService.processFile ();
		
	}
	
	@GetMapping("/getProducts")
	public Product getProducts (@RequestBody Product product) throws Exception {
		return productService.getProducts(product);
	}
	
	@GetMapping("/getProductsByPrice")
	public List<Product> getProductsByPrice (@RequestBody Product product) throws Exception {
		return productService.getProductsByPrice(product);
	}
}
