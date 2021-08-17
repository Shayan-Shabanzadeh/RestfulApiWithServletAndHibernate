package com.example.usermanagment.dao;

import com.example.usermanagment.SessionFactory.SessionFactoryCreator;
import com.example.usermanagment.bean.Entity;
import com.example.usermanagment.bean.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class OneToManyDAOImplForUser implements OneToManyDAO {

    SessionFactory factory;

    public OneToManyDAOImplForUser() {
        this.factory = SessionFactoryCreator.getInstance().createSessionFactory();
    }

    @Override
    public Long save(Entity user) {
        Long result = null;
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
    public void delete(Long userId) {
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
    public void update(Entity user) {
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
    public List<Entity> selectAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Entity> users = new ArrayList<>();
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
    public User select(Long id) {
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


