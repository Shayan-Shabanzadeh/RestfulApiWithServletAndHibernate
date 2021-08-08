package com.example.usermanagment.dao;

import com.example.usermanagment.bean.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static SessionFactory sessionFactory = creatSessionFactory();

    public UserDao() {
    }

    private static SessionFactory creatSessionFactory() {
        try {
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }catch(Throwable t){
            System.err.println("Failed to creat sessionFactory object." + t);
            throw new ExceptionInInitializerError(t);        }
    }

    //insert user
    public void insertUser(User user){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    //select user by id
    public User selectUser(int id){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        User user= null;
        try {
            tx = session.beginTransaction();
            user = session.get(User.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }
    //select all users
    public List<User> selectAllUsers(){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<User> users = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            List list = session.createQuery("FROM User").list();
            for(Object o : list){
                User user = (User) o ;
                users.add(user);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }
    //update user
    public void updateUser(User user){
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    //delete user
    public void deleteUser(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
