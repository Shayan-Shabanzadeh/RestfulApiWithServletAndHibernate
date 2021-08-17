package com.example.usermanagment.dao;

public class OneToManyDAOFactory {
    public static OneToManyDAO getInstanceForUserDAO() {
        return new OneToManyDAOImplForUser();
    }
    public static OneToManyDAO getInstanceForRollDAO() {
        return new OneToManyDAOImplForRoll();
    }

}
