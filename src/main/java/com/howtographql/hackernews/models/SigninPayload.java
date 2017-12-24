package com.howtographql.hackernews.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Alexander Pyreev
 */
@Document(collection="payloads")
@NoArgsConstructor
public class SigninPayload {
    @Getter
    @Setter
    private String token;
    @Getter
    @Setter
    private User user;

    public SigninPayload(final String token, final User user) {
        this.token = token;
        this.user = user;
    }
}
