package com.howtographql.hackernews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Pyreev
 */
// @Component
public class MongoExample implements CommandLineRunner {
    private final LinkRepository repository;

    @Autowired
    public MongoExample(final LinkRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(final String... args) throws Exception {
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Link("http://howtographql.com", "First"));
        repository.save(new Link("http://graphql.org/learn/", "Second"));

        // fetch all customers
        System.out.println("Links found with findAll():");
        System.out.println("-------------------------------");
        for (Link link : repository.findAll()) {
            System.out.println(link);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByUrl('http://howtographql.com'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByUrl("http://howtographql.com"));

        System.out.println("Customers found with findByDescription('Second'):");
        System.out.println("--------------------------------");
        for (Link link : repository.findByDescription("Second")) {
            System.out.println(link);
        }
    }
}
