package com.howtographql.hackernews.graphql;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.DefaultGraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexander Pyreev
 */
@Component
public class GErrorHandler extends DefaultGraphQLErrorHandler {
    @Override
    public List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
        return errors.stream()
                     .filter(e -> e instanceof ExceptionWhileDataFetching || super.isClientError(e))
                     .map(e -> e instanceof ExceptionWhileDataFetching ? new SanitizedError((ExceptionWhileDataFetching) e) : e)
                     .collect(Collectors.toList());
    }
}
