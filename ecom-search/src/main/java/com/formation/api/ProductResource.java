package com.formation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.formation.model.Product;
import com.formation.service.ProductService;

import java.net.URI;
import java.util.List;


@RestController
public class ProductResource {

    private ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @SuppressWarnings("static-access")
	@PostMapping("/product/add")
    public ResponseEntity<Product> addProduct(@RequestBody  Product newProduct) {
        Product savedProduct = productService.addProduct(newProduct);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(savedProduct.getId()).toUri();
        return ResponseEntity.ok(savedProduct).created(location).build();
    }

    @DeleteMapping("/product/{id}/delete")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/product/get-by-name/{name}")
    public ResponseEntity<List<Product>> findProductByName(@PathVariable("name") String productName) {
        List<Product> fetchedProduct = productService.getByName(productName);
        return ResponseEntity.ok(fetchedProduct);
    }
    
}
