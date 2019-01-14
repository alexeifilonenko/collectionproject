package com.kinomo.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.kinomo.model.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

public class JsonDAO implements DAO {

    private List<User> users;

    public JsonDAO() {
        if (users == null) {
            initialize();
        }
    }

    @Override
    public void initialize() {
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader("src/main/resources/users.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        users = gson.fromJson(reader, new TypeToken<List<User>>(){}.getType());
    }

    @Override
    public User getById(int id) {
        for(User user : users) {
            if (id == user.getId()) {
                System.out.println(user.getFirstName() + " " + user.getLastName());
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public Map<String, List<User>> getUnique() {
        return null;
    }
}
