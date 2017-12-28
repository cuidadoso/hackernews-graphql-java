package com.howtographql.hackernews.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alexander Pyreev
 */
@NoArgsConstructor
public class LinkFilter {
    @Getter
    @Setter
    @JsonProperty("description_contains")
    private String descriptionContains;
    @Getter
    @Setter
    @JsonProperty("url_contains")
    private String urlContains;
}
