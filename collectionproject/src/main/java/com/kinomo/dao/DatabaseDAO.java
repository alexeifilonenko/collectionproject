package com.kinomo.dao;

import com.kinomo.model.User;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.collections4.IteratorUtils;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;

//implement later
public class DatabaseDAO implements DAO {

    private User user1;

    private MongoCollection<User> collection;
    private String user = "platform";
    private String source = "stage-platform";
    private char[] password = new char[]{'S', 'B', 'U', 'h', 'X', '8', 'K', 'm', 'p', 'c', 'r', '7', 'T'};

    public DatabaseDAO() {

        initialize();
    }


    @Override
    public void initialize() {

        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoCredential credential = MongoCredential.createScramSha1Credential(user, source, password);

        MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .credential(credential)
                        .codecRegistry(pojoCodecRegistry)
                        .applyToClusterSettings(builder ->
                                builder.hosts(Arrays.asList(
                                        new ServerAddress("10.10.0.26", 27017),
                                        new ServerAddress("10.10.0.27", 27017),
                                        new ServerAddress("10.10.0.28", 27017))))
                        .build());

        MongoDatabase database = mongoClient.getDatabase("stage-platform");
        collection = database.getCollection("users", User.class);

        /*User user1 = collection.find(eq("_id", "590081fd218b450c1e102cf0")).first();


        System.out.println(user1.getFirstName() + " " + user1.getLastName());*/
    }

    @Override
    public User getById(String id) {
        return collection.find(eq("_id", id)).first();
    }

    @Override
    public List<User> getAll() {
        return IteratorUtils.toList(collection.find().iterator());
    }

    @Override
    public Map<String, List<User>> getUnique() {
        return null;
    }
}
