package com.howtographql.hackernews;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Alexander Pyreev
 */
public interface LinkRepository extends MongoRepository<Link, String> {
    Link findById(final String id);

    Link findByUrl(final String url);

    List<Link> findByDescription(final String description);
}
