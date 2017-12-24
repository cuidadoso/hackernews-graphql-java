package com.howtographql.hackernews.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.howtographql.hackernews.models.AuthData;
import com.howtographql.hackernews.models.Link;
import com.howtographql.hackernews.models.SigninPayload;
import com.howtographql.hackernews.models.User;
import com.howtographql.hackernews.repository.LinkRepository;
import com.howtographql.hackernews.repository.UserRepository;
import graphql.GraphQLException;
import graphql.schema.DataFetchingEnvironment;
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

    public Link createLink(final String url, final String description, DataFetchingEnvironment env) {
        AuthContext context = env.getContext();
        Link newLink = new Link(url, description, context.getUser().getId());
        return linkRepository.save(newLink);
    }

    public User createUser(final String name, final AuthData auth) {
        User newUser = new User(name, auth.getEmail(), auth.getPassword());
        return userRepository.save(newUser);
    }

    public SigninPayload signinUser(AuthData auth) throws IllegalAccessException {
        User user = userRepository.findByEmail(auth.getEmail());
        if (user.getPassword().equals(auth.getPassword())) {
            return new SigninPayload(user.getId(), user);
        }
        throw new GraphQLException("Invalid credentials");
    }
}
