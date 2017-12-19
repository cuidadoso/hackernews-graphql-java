package com.howtographql.hackernews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Application /*implements CommandLineRunner*/ {

	private final LinkRepository repository;

	@Autowired
	public Application(final LinkRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		this.repository.deleteAll();

		// save a couple of customers
		this.repository.save(new Link("http://howtographql.com", "First"));
		this.repository.save(new Link("http://graphql.org/learn/", "Second"));

		// fetch all customers
		System.out.println("Links found with findAll():");
		System.out.println("-------------------------------");
		for (Link link : this.repository.findAll()) {
			System.out.println(link);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByUrl('http://howtographql.com'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByUrl("http://howtographql.com"));

		System.out.println("Customers found with findByDescription('Second'):");
		System.out.println("--------------------------------");
		for (Link link : this.repository.findByDescription("Second")) {
			System.out.println(link);
		}
	}*/
}
