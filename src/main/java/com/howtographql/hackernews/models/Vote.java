package com.howtographql.hackernews.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

/**
 * @author Alexander Pyreev
 */
@Document(collection="votes")
@NoArgsConstructor
public class Vote {
    @Id
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private ZonedDateTime createdAt;
    @Getter
    @Setter
    private String userId;
    @Getter
    @Setter
    private String linkId;

    public Vote(ZonedDateTime createdAt, String userId, String linkId) {
        this(null, createdAt, userId, linkId);
    }

    public Vote(String id, ZonedDateTime createdAt, String userId, String linkId) {
        this.id = id;
        this.createdAt = createdAt;
        this.userId = userId;
        this.linkId = linkId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id)
                                        .append("createdAt", createdAt)
                                        .append("userId", userId)
                                        .append("linkId", linkId)
                                        .toString();
    }
}
