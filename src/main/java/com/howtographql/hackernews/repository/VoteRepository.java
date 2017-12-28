package com.howtographql.hackernews.repository;

import com.howtographql.hackernews.models.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Alexander Pyreev
 */
public interface VoteRepository extends MongoRepository<Vote, String> {
    List<Vote> findByUserId(final String userId);

    List<Vote> findByLinkId(final String linkId);

    List<Vote> findByUserIdAndLinkId(final String userId, final String linkId);
}
