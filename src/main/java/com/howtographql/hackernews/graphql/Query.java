package com.howtographql.hackernews.graphql;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.howtographql.hackernews.models.Link;
import com.howtographql.hackernews.models.User;
import com.howtographql.hackernews.repository.LinkRepository;
import com.howtographql.hackernews.repository.UserRepository;
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

    @Autowired
    public Query(final LinkRepository linkRepository,
                 final UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    public List<Link> allLinks() {
        return linkRepository.findAll();
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }
}
