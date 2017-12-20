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
    private final UserRepository userRepository;

    @Autowired
    public Mutation(final LinkRepository linkRepository,
                    final UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    public Link createLink(final String url, final String description) {
        Link newLink = new Link(url, description);
        linkRepository.save(newLink);
        return newLink;
    }

    public User createUser(final String name, final AuthData auth) {
        User newUser = new User(name, auth.getEmail(), auth.getPassword());
        return userRepository.save(newUser);
    }
}
