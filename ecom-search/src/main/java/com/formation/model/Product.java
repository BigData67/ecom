package com.formation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "products", type = "product")
public class Product {

	@Id
	private Long id;

	private Integer version;
	
	private String category;

	private String name;

	private int quantity;

	@Field(type = FieldType.Nested)
	private MonetaryAmount price;

	


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Product() {

	}

	public Product(String name, MonetaryAmount price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public MonetaryAmount getPrice() {
		return price;
	}

	public void setPrice(MonetaryAmount price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", version=" + version + ", category=" + category + ", name=" + name
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	

}
