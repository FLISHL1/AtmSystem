package ru.flish1.atmsystem.repositories;

import org.flishl1.entity.Bank;
import org.flishl1.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BankRepository implements IRepository<Bank, Integer>{
    private SessionFactory sessionFactory;

    public BankRepository() {
        sessionFactory = HibernateUtil.buildSessionFactory();
    }

    @Override
    public Bank save(Bank entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public Bank update(Bank entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public void remove(Bank entity) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public Bank findById(Integer id) {
        Bank entity;
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            entity = session.get(Bank.class, id);
            session.getTransaction().commit();
        }
        return entity;
    }
}
