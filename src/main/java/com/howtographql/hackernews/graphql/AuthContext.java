package com.howtographql.hackernews.graphql;

import com.howtographql.hackernews.models.User;
import graphql.servlet.GraphQLContext;
import lombok.Getter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @author Alexander Pyreev
 */
public class AuthContext extends GraphQLContext {
    @Getter
    private final User user;

    public AuthContext(User user, Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
        super(request, response);
        this.user = user;
    }
}
