package com.formation.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.formation.model.Product;


import java.util.List;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, Long> {

    List<Product> findByName(String name);
    List<Product> findByCategory(String categoty);
}
