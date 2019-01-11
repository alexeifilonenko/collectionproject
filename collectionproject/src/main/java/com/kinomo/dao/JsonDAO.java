package com.kinomo.dao;

import com.kinomo.model.User;

import java.util.List;
import java.util.Map;

public class JsonDAO implements DAO {

    private static List<User> users;

    public JsonDAO() {
        if (users == null) {
            initialize();
        }
    }

    @Override
    public void initialize() {

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
