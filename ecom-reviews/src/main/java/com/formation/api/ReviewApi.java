package com.formation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formation.reviews.models.Review;
import com.formation.reviews.repositories.ReviewRepository;

@EnableEurekaClient
@RestController
public class ReviewApi{
	
	@Autowired
	private ReviewRepository repository;
	
	@GetMapping("/reviews")
	public Iterable<Review> findAll() {
		return repository.findAll();
	}

	// Get all reviews for a productid
	@GetMapping("/reviews/{productId}")
	public Iterable<Review> findByReviewId(@PathVariable("productId") String productId) {
		return repository.findByProductId(productId);
	}
	
}
