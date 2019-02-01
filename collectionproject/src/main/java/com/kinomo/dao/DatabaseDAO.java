package com.kinomo.dao;

import com.kinomo.model.User;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//implement later
public class DatabaseDAO implements DAO {


    private String user = "platform";
    private String source = "stage-platform";
    private char[] password = new char[]{'S', 'B', 'U', 'h', 'X', '8', 'K', 'm', 'p', 'c', 'r', '7', 'T'};

    public DatabaseDAO() {

        initialize();
    }


    @Override
    public void initialize() {

        MongoCredential credential = MongoCredential.createScramSha1Credential(user, source, password);

        MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .credential(credential)
                        .applyToClusterSettings(builder ->
                                builder.hosts(Arrays.asList(
                                        new ServerAddress("10.10.0.26", 27017),
                                        new ServerAddress("10.10.0.27", 27017),
                                        new ServerAddress("10.10.0.28", 27017))))
                        .build());

        MongoDatabase database = mongoClient.getDatabase("stage-platform");
        MongoCollection<Document> collection = database.getCollection("users");
        System.out.println(collection.countDocuments());
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Map<String, List<User>> getUnique() {
        return null;
    }
}
