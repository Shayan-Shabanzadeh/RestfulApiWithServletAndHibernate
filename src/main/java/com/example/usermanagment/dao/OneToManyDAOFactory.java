package com.example.usermanagment.dao;

public class OneToManyDAOFactory {
    public static OneToManyDAO getInstance() {
        return new OneToManyDAOImpl();
    }
}
