package com.howtographql.hackernews;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Alexander Pyreev
 */
@Component
public class Query implements GraphQLQueryResolver {
    private final LinkRepository linkRepository;

    @Autowired
    public Query(final LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> allLinks() {
        return linkRepository.getAllLinks();
    }
}
