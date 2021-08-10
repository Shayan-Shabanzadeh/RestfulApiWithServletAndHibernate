package com.example.usermanagment.SessionFactory;

public class SessionFactoryCreator {
    public static SessionFactory getInstance(){
        return new SessionFactoryImpl();
    }
}
