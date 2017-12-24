package com.howtographql.hackernews.graphql;

import com.howtographql.hackernews.models.User;
import com.howtographql.hackernews.repository.UserRepository;
import graphql.servlet.GraphQLContext;
import graphql.servlet.GraphQLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @author Alexander Pyreev
 */
@Component
public class CustomContextBuilder implements GraphQLContextBuilder {

    private final UserRepository userRepository;

    @Autowired
    public CustomContextBuilder(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public GraphQLContext build(Optional<HttpServletRequest> request, Optional<HttpServletResponse> resp) {
        /*User user = request.map(req -> req.getHeader("Authorization"))
                           .filter(id -> !id.isEmpty())
                           .map(id -> id.replace("Bearer ", ""))
                           .map(userRepository::findById)
                           .orElse(null);*/
        // TODO update from hardcoded to use Spring Security
        User user = userRepository.findByEmail("alexander_s@front.ru");
        return new AuthContext(user, request, resp);
    }
}
