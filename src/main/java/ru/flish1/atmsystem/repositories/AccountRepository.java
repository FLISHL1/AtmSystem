package ru.flish1.atmsystem.repositories;

import org.flishl1.entity.Account;
import org.flishl1.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountRepository implements IRepository<Account, Long> {
    private SessionFactory sessionFactory;

    public AccountRepository() {
        sessionFactory = HibernateUtil.buildSessionFactory();
    }

    @Override
    public Account save(Account entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public Account update(Account entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public void remove(Account entity) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public Account findById(Long id) {
        Account entity;
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            entity = session.get(Account.class, id);
            session.getTransaction().commit();
        }
        return entity;
    }
}
