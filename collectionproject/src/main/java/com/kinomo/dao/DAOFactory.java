package com.kinomo.dao;

public class DAOFactory {

    public static DAO get(DAOKeys daoKey) {
        DAO dao = null;

        switch (daoKey) {
            case JSON:
                dao = new JsonDAO();
                break;
            case DATABASE:
                dao = new DatabaseDAO();
                break;
            default:
                dao = new JsonDAO();
                break;
        }

        return dao;
    }

    public enum DAOKeys {
        JSON,
        DATABASE
    }

}
