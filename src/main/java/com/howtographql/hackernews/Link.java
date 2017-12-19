package com.howtographql.hackernews;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Alexander Pyreev
 */
@Document(collection="links")
public class Link {
    @Id
    private final String id;
    private final String url;
    private final String description;

    public Link(final String id, final String url, final String description) {
        this.id = id;
        this.url = url;
        this.description = description;
    }

    public Link(String url, String description) {
        this(null, url, description);
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id)
                                        .append("url", url)
                                        .append("description", description)
                                        .toString();
    }
}
