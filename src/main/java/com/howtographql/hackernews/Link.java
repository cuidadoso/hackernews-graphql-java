package com.howtographql.hackernews;

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

    public Link(final String id, final String url, final String description) {
        this.id = id;
        this.url = url;
        this.description = description;
    }

    public Link(String url, String description) {
        this(null, url, description);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id)
                                        .append("url", url)
                                        .append("description", description)
                                        .toString();
    }
}
