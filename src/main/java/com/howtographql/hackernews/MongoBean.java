package com.howtographql.hackernews;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Component;

/**
 * TODO - spring bean initialization error
 * @author Alexander Pyreev
 */
@Component
public class MongoBean {
    private final MongoTemplate mongo;
    private final ConfigProperties config;

    @Autowired
    public MongoBean(final ConfigProperties config) throws Exception {
        this.config = config;
        this.mongo = mongoTemplate();
    }

    @NotNull
    private MongoDbFactory mongoDbFactory() throws Exception {

        MongoClientURI uri = new MongoClientURI(config.getUri());

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(config.getDatabase());

        /*// Set credentials
        MongoCredential credential = MongoCredential.createCredential(config.getUsername(), config.getDatabase(), config.getPassword().toCharArray());
        ServerAddress serverAddress = new ServerAddress(config.getHost(), config.getPort());
        // Mongo Client
        MongoClient mongoClient = new MongoClient(serverAddress, Collections.singletonList(credential));*/
        // return Mongo DB Factory
        return new SimpleMongoDbFactory(mongoClient, config.getDatabase());
    }

    @NotNull
    private MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

}
