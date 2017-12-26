package com.howtographql.hackernews.graphql;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.howtographql.hackernews.models.Link;
import com.howtographql.hackernews.models.User;
import com.howtographql.hackernews.models.Vote;
import com.howtographql.hackernews.repository.LinkRepository;
import com.howtographql.hackernews.repository.UserRepository;
import com.howtographql.hackernews.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Alexander Pyreev
 */
@Component
public class Query implements GraphQLQueryResolver {
    private final LinkRepository linkRepository;
    private final UserRepository userRepository;
    private final VoteRepository voteRepository;

    @Autowired
    public Query(final LinkRepository linkRepository,
                 final UserRepository userRepository,
                 final VoteRepository voteRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
        this.voteRepository = voteRepository;
    }

    public List<Link> allLinks() {
        return linkRepository.findAll();
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public List<Vote> allVotes() {
        return voteRepository.findAll();
    }

    public List<Vote> allVotesByUser(final String userId) {
        return voteRepository.findByUserId(userId);
    }

    public List<Vote> allVotesByLink(final String linkId) {
        return voteRepository.findByLinkId(linkId);
    }

    public Vote voteByUserAndByLink(final String userId, final String linkId) {
        return voteRepository.findByUserIdAndLinkId(userId, linkId);
    }

}
