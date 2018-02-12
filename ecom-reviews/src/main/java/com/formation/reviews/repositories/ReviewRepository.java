package com.formation.reviews.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.formation.reviews.models.Review;

public interface ReviewRepository extends PagingAndSortingRepository<Review, String> {

	Iterable<Review> findByProductId(String productId);
}
