package com.example.usermanagment.dao;

import com.example.usermanagment.SessionFactory.SessionFactoryCreator;
import com.example.usermanagment.bean.Entity;
import com.example.usermanagment.bean.Roll;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class OneToManyDAOImplForRoll implements OneToManyDAO{

    SessionFactory factory;

    public OneToManyDAOImplForRoll() {
        this.factory = SessionFactoryCreator.getInstance().createSessionFactory();
    }

    @Override
    public Long save(Entity roll) {
        Long result = null;
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            result = (Long) session.save(roll);
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
    public void delete(Long entityId) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Roll roll = session.get(Roll.class, entityId);
            session.delete(roll);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Entity entity) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(entity);
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
        List<Entity> rolls = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            List list = session.createQuery("FROM Roll").list();
            for (Object o : list) {
                Roll roll = (Roll) o;
                rolls.add(roll);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rolls;
    }

    @Override
    public Roll select(Long id) {
        Session session = factory.openSession();
        Transaction tx = null;
        Roll roll = null;
        try {
            tx = session.beginTransaction();
            roll = session.get(Roll.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return roll;
    }
}
