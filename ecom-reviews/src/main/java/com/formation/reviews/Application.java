package com.formation.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.formation.reviews.models.Review;
import com.formation.reviews.repositories.ReviewRepository;


@SpringBootApplication
@EnableMongoRepositories
public class Application extends RepositoryRestMvcConfiguration implements CommandLineRunner {
	
	@Autowired
	private ReviewRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		// save a couple of customers
		repository.save(new Review("1", "user1", "name1", "rewiew1", 5));
		repository.save(new Review("2", "user1", "name1", "rewiew2", 2));
		repository.save(new Review("3", "user2", "name2", "rewiew3", 3));
		repository.save(new Review("4", "user3", "name3", "rewiew4", 5));
		repository.save(new Review("2", "user2", "name2", "rewiew5", 4));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Review review : repository.findAll()) {
			System.out.println(review);
		}
		System.out.println();
		System.out.println("-------------------------------");
		
		System.out.println(repository.findByProductId("1"));
		
	}

}
