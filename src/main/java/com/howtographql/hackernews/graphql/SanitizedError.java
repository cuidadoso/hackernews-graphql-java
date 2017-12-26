package com.howtographql.hackernews.graphql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ExceptionWhileDataFetching;
import org.jetbrains.annotations.NotNull;

/**
 * @author Alexander Pyreev
 */
public class SanitizedError extends ExceptionWhileDataFetching {
    public SanitizedError(@NotNull ExceptionWhileDataFetching inner) {
        super(inner.getException());
    }

    @Override
    @JsonIgnore
    public Throwable getException() {
        return super.getException();
    }
}
