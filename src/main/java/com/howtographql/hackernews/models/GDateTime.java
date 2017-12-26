package com.howtographql.hackernews.models;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * TODO Vote query is not working with parsing createdAt field
 * @author Alexander Pyreev
 */
@Component
public class GDateTime extends GraphQLScalarType {
    public GDateTime() {
        super("DateTime", "DataTime scalar", new Coercing() {
            @Override
            public String serialize(Object input) {
                //serialize the ZonedDateTime into string on the way out
                return ((ZonedDateTime) input).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            }

            @Override
            public Object parseValue(Object input) {
                return serialize(input);
            }

            @Override
            public ZonedDateTime parseLiteral(Object input) {
                //parse the string values coming in
                if(input instanceof StringValue) {
                    return ZonedDateTime.parse(((StringValue) input).getValue());
                } else {
                    return null;
                }
            }
        });
    }
}
