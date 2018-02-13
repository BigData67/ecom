package com.formation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.formation.model.MonetaryAmount;
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
    
    @GetMapping("/load")
    public void load() {
    	addProducts();
    }
    
    private void addProducts() {
        Product product1 = getFirstProduct();
        productService.addProduct(product1);

        Product product2 = getSecondProduct();
        productService.addProduct(product2);

        Product mvoie3 = getThirdProduct();
        productService.addProduct(mvoie3);

        Product product4 = getForthProduct();
        productService.addProduct(product4);
    }

    private Product getFirstProduct() {
        Product firstProduct = new Product();
        firstProduct.setId(1l);
        firstProduct.setName("Black Shirt");
        firstProduct.setQuantity(54);
        firstProduct.setCategory("Mens");
        firstProduct.setVersion(1);

        MonetaryAmount price = new MonetaryAmount(MonetaryAmount.EURO, 12.00);
        firstProduct.setPrice(price);

        return firstProduct;
    }

    private Product getSecondProduct() {
        Product firstProduct = new Product();
        firstProduct.setId(2l);
        firstProduct.setName("Red Shirt");
        firstProduct.setQuantity(18);
        firstProduct.setCategory("Womens");

        MonetaryAmount price = new MonetaryAmount(MonetaryAmount.EURO, 32.00);
        firstProduct.setPrice(price);
        firstProduct.setVersion(1);

        return firstProduct;
    }

    private Product getThirdProduct() {
        Product firstProduct = new Product();
        firstProduct.setId(3l);
        firstProduct.setName("Green Shirt");
        firstProduct.setCategory("Shirts");
        firstProduct.setQuantity(5);

        MonetaryAmount price = new MonetaryAmount(MonetaryAmount.EURO, 15.00);
        firstProduct.setPrice(price);
        firstProduct.setVersion(1);

        return firstProduct;
    }

    private Product getForthProduct() {
        Product firstProduct = new Product();
        firstProduct.setId(4l);
        firstProduct.setName("Pink Shorts");
        firstProduct.setCategory("Womens");
        firstProduct.setQuantity(1);
        firstProduct.setVersion(1);

        MonetaryAmount price = new MonetaryAmount(MonetaryAmount.EURO, 12.00);
        firstProduct.setPrice(price);

        return firstProduct;
    }
    
}
