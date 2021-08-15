package com.example.usermanagment.dao;

import com.example.usermanagment.SessionFactory.SessionFactoryCreator;
import com.example.usermanagment.bean.Address;
import com.example.usermanagment.bean.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OneToManyDAOImpl implements OneToManyDAO {

    SessionFactory factory;

    public OneToManyDAOImpl() {
        this.factory = SessionFactoryCreator.getInstance().createSessionFactory();
    }

    @Override
    public Long saveUserWithOutAddress(User user) {
        Long result = null;
        user.getAddresses().clear();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            result = (Long) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void saveUserAddress(Long userId, List<Address> addresses) {
        User user = selectUser(userId);
        if(user != null){
            Session session = factory.openSession();
            Transaction tx = null;
            try{
                tx = session.beginTransaction();
                for(Address address : addresses){
                    user.getAddresses().add(address);
                    address.setUserId(userId);
                    session.save(address);
                }
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
    }

    @Override
    public void deleteUser(Long userId) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            User user = session.get(User.class, userId);
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateUser(User user) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> selectAllUsers() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<User> users = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            List list = session.createQuery("FROM User").list();
            for (Object o : list) {
                User user = (User) o;
                users.add(user);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    @Override
    public User selectUser(Long id) {
        Session session = factory.openSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.beginTransaction();
            user = session.get(User.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

}


