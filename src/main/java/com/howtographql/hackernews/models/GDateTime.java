package com.howtographql.hackernews.models;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Alexander Pyreev
 */
@Component
public class GDateTime extends GraphQLScalarType {
    public GDateTime() {
        super("DateTime", "DataTime scalar", new Coercing() {
            @Override
            public String serialize(Object input) {
                //serialize the LocalDateTime into string on the way out
                return ((LocalDateTime) input).format(DateTimeFormatter.ISO_DATE_TIME);
            }

            @Override
            public Object parseValue(Object input) {
                return serialize(input);
            }

            @Override
            public LocalDateTime parseLiteral(Object input) {
                //parse the string values coming in
                if(input instanceof StringValue) {
                    return LocalDateTime.parse(((StringValue) input).getValue());
                } else {
                    return null;
                }
            }
        });
    }
}
