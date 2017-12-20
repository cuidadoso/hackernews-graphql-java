package com.howtographql.hackernews;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alexander Pyreev
 */
@NoArgsConstructor
public class AuthData {
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;

    public AuthData(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
