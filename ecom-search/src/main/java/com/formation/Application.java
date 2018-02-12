package com.formation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.formation.model.MonetaryAmount;
import com.formation.model.Product;
import com.formation.service.ProductService;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner{

    private static final Logger logger = LoggerFactory.getLogger(Application.class);


    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        addProducts();

        List<Product> dabanggNamedQuery = productService.getByName("Black Shirt");
        logger.info("Content of dabangg name book {}", dabanggNamedQuery);

        List<Product> produitByCategory = productService.findByCategory("Womens");
        logger.info("Content of dabangg name book {}", produitByCategory);

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
