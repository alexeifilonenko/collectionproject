package com.kinomo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.kinomo.dao.DAO;
import com.kinomo.dao.DAOFactory;
import com.kinomo.dao.DAOFactory.DAOKeys;
import com.kinomo.model.User;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Runner {

    public static void main(String[] args) throws IOException {
        DAO dao = DAOFactory.get(DAOKeys.DATABASE);

        /*dao.getById(1);
        dao.getById(4);
        System.out.println();
        dao.getAll();
        System.out.println();
        System.out.println(dao.getUnique());
        System.out.println();

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("src/main/resources/users.json"));
        List<User> users = gson.fromJson(reader, new TypeToken<List<User>>(){}.getType());
            for(User user : users) {
                System.out.println(user.getId());
            }*/




        }




    }




