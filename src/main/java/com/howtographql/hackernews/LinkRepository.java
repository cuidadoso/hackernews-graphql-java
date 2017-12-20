package com.howtographql.hackernews;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Alexander Pyreev
 */
public interface LinkRepository extends MongoRepository<Link, String> {
    Link findByUrl(String url);

    List<Link> findByDescription(String description);
}
