package com.howtographql.hackernews;

import com.howtographql.hackernews.models.Link;
import com.howtographql.hackernews.repository.LinkRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author Alexander Pyreev
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LinkRepositoryTest {
    @Autowired
    private LinkRepository repository;

    @Before
    public void setUp() {
        Link link1 = new Link("http://howtographql.com", "First");
        Link link2 = new Link("http://graphql.org/learn/", "Second");
        assertNull(link1.getId());
        assertNull(link2.getId());
        repository.save(link1);
        repository.save(link2);
        assertNotNull(link1);
        assertNotNull(link2);
    }

    @Test
    public void testFetchData() {
        Link linkA = repository.findByDescription("First")
                               .get(0);
        assertNotNull(linkA);
        assertEquals("http://howtographql.com", linkA.getUrl());
        List<Link> links = repository.findAll();
        assertEquals(2, links.size());
    }

    @Test
    public void testDataUpdate() {
        Link linkB = repository.findByDescription("First")
                               .get(0);
        linkB.setUrl("http://howtographql.ru");
        repository.save(linkB);
        Link linkC = repository.findByDescription("First")
                               .get(0);
        assertNotNull(linkC);
        assertEquals("http://howtographql.ru", linkC.getUrl());
    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }
}
