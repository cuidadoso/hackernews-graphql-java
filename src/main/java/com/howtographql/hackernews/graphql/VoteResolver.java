package com.howtographql.hackernews.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.howtographql.hackernews.models.Link;
import com.howtographql.hackernews.models.User;
import com.howtographql.hackernews.models.Vote;
import com.howtographql.hackernews.repository.LinkRepository;
import com.howtographql.hackernews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Pyreev
 */
@Component
public class VoteResolver implements GraphQLResolver<Vote> {
    private final LinkRepository linkRepository;
    private final UserRepository userRepository;

    @Autowired
    public VoteResolver(final LinkRepository linkRepository,
                        final UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    public User user(Vote vote) {
        return userRepository.findById(vote.getUserId());
    }

    public Link link(Vote vote) {
        return linkRepository.findById(vote.getLinkId());
    }
}
