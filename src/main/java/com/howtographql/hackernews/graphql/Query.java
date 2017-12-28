package com.howtographql.hackernews.graphql;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.howtographql.hackernews.models.Link;
import com.howtographql.hackernews.models.LinkFilter;
import com.howtographql.hackernews.models.User;
import com.howtographql.hackernews.models.Vote;
import com.howtographql.hackernews.repository.LinkRepository;
import com.howtographql.hackernews.repository.UserRepository;
import com.howtographql.hackernews.repository.VoteRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Alexander Pyreev
 */
@Component
public class Query implements GraphQLQueryResolver {
    private final LinkRepository linkRepository;
    private final UserRepository userRepository;
    private final VoteRepository voteRepository;

    @Autowired
    public Query(final LinkRepository linkRepository,
                 final UserRepository userRepository,
                 final VoteRepository voteRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
        this.voteRepository = voteRepository;
    }

    public List<Link> allLinks(final LinkFilter filter, final Number skip, final Number first) {
        String description = filter == null ? null : filter.getDescriptionContains();
        String url = filter == null ? null : filter.getUrlContains();

        boolean isDescriptionExists = description != null && !description.isEmpty();
        boolean isUrlExists = url != null && !url.isEmpty();
        if (isDescriptionExists && !isUrlExists) {
            return linkRepository.findByDescriptionContains(description);
        } else if(!isDescriptionExists && isUrlExists) {
            return linkRepository.findByUrlContains(url);
        } else if(isDescriptionExists) {
            return linkRepository.findByUrlContainsAndDescriptionContains(url, description);
        }

        return linkRepository.findAll(getPageble(skip, first))
                             .getContent();
    }

    public List<User> allUsers(final Number skip, final Number first) {
        return userRepository.findAll(getPageble(skip, first))
                             .getContent();
    }

    public List<Vote> allVotes(final String userId, final String linkId, final Number skip, final Number first) {
        boolean isUserIdExists = userId != null && !userId.isEmpty();
        boolean isLinkIdExists = linkId != null && !linkId.isEmpty();
        if (isUserIdExists && !isLinkIdExists) {
            return voteRepository.findByUserId(userId);
        } else if(!isUserIdExists && isLinkIdExists) {
            return voteRepository.findByLinkId(linkId);
        } else if(isUserIdExists) {
            return voteRepository.findByUserIdAndLinkId(userId, linkId);
        }

        return voteRepository.findAll(getPageble(skip, first))
                             .getContent();
    }

    @NotNull
    private Pageable getPageble(final Number skip, final Number first) {
        int page = skip == null ? 0 : skip.intValue();
        int size = (first == null || first.intValue() == 0) ? Integer.MAX_VALUE : first.intValue();
        return new PageRequest(page, size);
    }
}
