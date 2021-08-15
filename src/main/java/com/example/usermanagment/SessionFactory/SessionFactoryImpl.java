package com.example.usermanagment.SessionFactory;

import org.hibernate.cfg.Configuration;

public class SessionFactoryImpl implements SessionFactory{
    @Override
    public org.hibernate.SessionFactory createSessionFactory() {
        try {
          return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }catch(Throwable t){
            System.err.println("Failed to creat sessionFactory object." + t);
            throw new ExceptionInInitializerError(t);
        }
    }
}
