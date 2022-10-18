package com.brodosTest.fileoperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brodosTest.fileoperation.entity.Product;
import com.brodosTest.fileoperation.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public String processFile() throws Exception {

		List<Product> products = CSVHelper.csvToProducts();
		if (products != null)
		{
		productRepository.saveAll(products);
		}
		return "File Processed Successfully";
	}

	public Product getProducts(Product product) throws Exception {
		if (product.getName() != null && product.getArticleNo() != null) {
			return productRepository.findByNameAndArticleNo(product.getName(), product.getArticleNo());
		}
		else if (product.getName() != null ) {
			return productRepository.findByName(product.getName());
		}
		else if (product.getArticleNo() != null) {
			return productRepository.findByArticleNo(product.getArticleNo());
		}
		else
		{
			return null;
		}

	}
	
	public List<Product> getProductsByPrice(Product product) throws Exception {
			return productRepository.findByPriceGreaterThanEqual(product.getPrice());

	}

}
