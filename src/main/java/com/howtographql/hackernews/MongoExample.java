package com.howtographql.hackernews;

import com.howtographql.hackernews.models.Link;
import com.howtographql.hackernews.models.User;
import com.howtographql.hackernews.repository.LinkRepository;
import com.howtographql.hackernews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Pyreev
 */
@Component
public class MongoExample implements CommandLineRunner {
    private final LinkRepository linkRepository;
    private final UserRepository userRepository;

    @Autowired
    public MongoExample(final LinkRepository repository,
                        final UserRepository userRepository) {
        this.linkRepository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(final String... args) {
        linkRepository.deleteAll();

        // save a couple of links
        linkRepository.save(new Link("http://howtographql.com", "First"));
        linkRepository.save(new Link("http://graphql.org/learn/", "Second"));

        // save one user
        userRepository.save(new User("Alejandro", "alexander_s@front.ru", "12345"));

        // save link by user
        String userId = userRepository.findByEmail("alexander_s@front.ru")
                                      .getId();
        linkRepository.save(new Link("rambler.ru", "First link by user", userId));

        // fetch all links
        System.out.println("Links found with findAll():");
        System.out.println("-------------------------------");
        for (Link link : linkRepository.findAll()) {
            System.out.println(link);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByUrl('http://howtographql.com'):");
        System.out.println("--------------------------------");
        System.out.println(linkRepository.findByUrl("http://howtographql.com")
                                         .get(0));

        System.out.println("Customers found with findByDescription('Second'):");
        System.out.println("--------------------------------");
        for (Link link : linkRepository.findByDescription("Second")) {
            System.out.println(link);
        }
    }
}
