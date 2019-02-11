package com.kinomo;

import com.kinomo.dao.DAO;
import com.kinomo.dao.DAOFactory;
import com.kinomo.dao.DAOFactory.DAOKeys;
import com.kinomo.model.User;

import java.io.IOException;
import java.util.List;


public class Runner {

    public static void main(String[] args) throws IOException {
        DAO dao = DAOFactory.get(DAOKeys.DATABASE);
        System.out.println();
        System.out.println(dao.getById("59049586c7efe1567cf17470"));
        System.out.println();
        List<User> users = dao.getAll();
        users.forEach(user -> System.out.println(user.getFirstName() + " " + user.getLastName()));

        // dao.getById("1");
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




