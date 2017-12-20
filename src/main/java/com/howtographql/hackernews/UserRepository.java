package com.howtographql.hackernews;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Alexander Pyreev
 */
public interface UserRepository extends MongoRepository<User, String> {
    User findById(final String id);

    User findByEmail(final String email);
}
