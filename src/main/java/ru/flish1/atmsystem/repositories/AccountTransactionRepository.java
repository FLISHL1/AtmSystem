package ru.flish1.atmsystem.repositories;

import org.flishl1.entity.AccountTransaction;
import org.flishl1.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountTransactionRepository implements IRepository<AccountTransaction, Long>{
    private SessionFactory sessionFactory;

    public AccountTransactionRepository() {
        sessionFactory = HibernateUtil.buildSessionFactory();
    }

    @Override
    public AccountTransaction save(AccountTransaction entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public AccountTransaction update(AccountTransaction entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public void remove(AccountTransaction entity) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public AccountTransaction findById(Long id) {
        AccountTransaction entity;
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            entity = session.get(AccountTransaction.class, id);
            session.getTransaction().commit();
        }
        return entity;
    }
}
