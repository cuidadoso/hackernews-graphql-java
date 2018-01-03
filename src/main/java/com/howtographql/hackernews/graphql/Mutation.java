package com.howtographql.hackernews.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.howtographql.hackernews.models.*;
import com.howtographql.hackernews.repository.LinkRepository;
import com.howtographql.hackernews.repository.UserRepository;
import com.howtographql.hackernews.repository.VoteRepository;
import graphql.GraphQLException;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Alexander Pyreev
 */
@Component
public class Mutation implements GraphQLMutationResolver {
    private final LinkRepository linkRepository;
    private final UserRepository userRepository;
    private final VoteRepository voteRepository;

    @Autowired
    public Mutation(final LinkRepository linkRepository,
                    final UserRepository userRepository,
                    final VoteRepository voteRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
        this.voteRepository = voteRepository;
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

    public Vote createVote(String linkId, String userId) {
        LocalDateTime now = LocalDateTime.now();
        return voteRepository.save(new Vote(now, userId, linkId));
    }
}
