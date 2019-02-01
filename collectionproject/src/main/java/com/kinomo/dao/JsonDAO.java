package com.kinomo.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.kinomo.model.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

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
        for(User user : users) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getCity());
        }
        return users;
    }

    @Override
    public Map<String, List<User>> getUnique() {
        Map<String, List<User>> map = new HashMap<String, List<User>>();
        //HashSet<String> cities = new HashSet<>();

        for(User user : users) {
            String city = user.getCity();
            List<User> userList = map.containsKey(city)? map.get(city): new ArrayList<>();
            userList.add(user);
            map.put(city, userList);


        }
       return map;
    }
}
