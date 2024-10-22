package ru.flish1.atmsystem.repositories;

import org.flishl1.entity.Transaction;
import org.flishl1.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TransactionRepository implements IRepository<Transaction, Long>{
    private SessionFactory sessionFactory;

    public TransactionRepository() {
        sessionFactory = HibernateUtil.buildSessionFactory();
    }

    @Override
    public Transaction save(Transaction entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public Transaction update(Transaction entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public void remove(Transaction entity) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public Transaction findById(Long id) {
        Transaction entity;
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            entity = session.get(Transaction.class, id);
            session.getTransaction().commit();
        }
        return entity;
    }
}
