package com.formation.api;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.model.Product;

import java.util.Map;


@RestController
public class ElasticResource {
	
	

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @GetMapping("/elastic/details")
    public ResponseEntity<Map<String, String>> getElasticInformation() {

        Client client = elasticsearchOperations.getClient();
        Map<String, String> asMap = client.settings().getAsMap();
        return ResponseEntity.ok(asMap);
    }

    @PutMapping("/elastic/clear-indices")
    public void clearIndices() {
        elasticsearchTemplate.deleteIndex(Product.class);
        elasticsearchTemplate.createIndex(Product.class);
        elasticsearchTemplate.putMapping(Product.class);
        elasticsearchTemplate.refresh(Product.class);
    }
}
