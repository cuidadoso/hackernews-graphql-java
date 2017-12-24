package com.howtographql.hackernews.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Alexander Pyreev
 */
@Document(collection="links")
@NoArgsConstructor
public class Link {
    @Id
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String url;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String userId;

    public Link(String id, String url, String description, String userId) {
        this.id = id;
        this.url = url;
        this.description = description;
        this.userId = userId;
    }

    public Link(String url, String description, String userId) {
        this(null, url, description, userId);
    }

    public Link(String url, String description) {
        this(url, description, null);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id)
                                        .append("url", url)
                                        .append("description", description)
                                        .append("userId", userId)
                                        .toString();
    }
}
