package com.howtographql.hackernews;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Alexander Pyreev
 */
public interface LinkRepository extends MongoRepository<Link, String> {
    Link findByUrl(String url);

    Link findByDescription(String description);
}
