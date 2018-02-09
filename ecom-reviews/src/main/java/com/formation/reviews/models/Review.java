package com.formation.reviews.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Review {
	@Id
	private String id;

	@Indexed
	private String productId;

	@Indexed
	private String userName;

	private String name;

	private String review;

	private int rating;
	
	public Review() {
		
	}

	
	public Review(String productId, String userName, String name, String review, int rating) {
		super();
		this.productId = productId;
		this.userName = userName;
		this.name = name;
		this.review = review;
		this.rating = rating;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", productId=" + productId + ", userName=" + userName + ", name=" + name
				+ ", review=" + review + ", rating=" + rating + "]";
	}
	
	
}
