package com.formation.reviews.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.formation.reviews.models.Review;

public interface ReviewRepository extends PagingAndSortingRepository<Review, String> {

	Iterable<Review> findByProductId(@Param("productId") String productId);
}
