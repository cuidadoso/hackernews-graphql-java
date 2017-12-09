package com.howtographql.hackernews;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Pyreev
 */
@Component
public class Mutation implements GraphQLMutationResolver {
    private final LinkRepository linkRepository;

    @Autowired
    public Mutation(final LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Link createLink(final String url, final String description) {
        Link newLink = new Link(url, description);
        linkRepository.saveLink(newLink);
        return newLink;
    }
}
