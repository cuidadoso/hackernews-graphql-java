package com.howtographql.hackernews.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.howtographql.hackernews.models.SigninPayload;
import com.howtographql.hackernews.models.User;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Pyreev
 */
@Component
public class SigninResolver implements GraphQLResolver<SigninPayload> {
    public User user(SigninPayload payload) {
        return payload.getUser();
    }
}
