package com.brodosTest.fileoperation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor (staticName = "build")
@NoArgsConstructor
@Entity
@Table (name = "product_file_data")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "product_id")
	private long id;
	
	@Column (name = "article_no")
	private String articleNo;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "price")
	private double price;
	
	@Column (name = "stock")
	private int stock;
	
	@Column (name = "description")
	private String description;

}
