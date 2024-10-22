package ru.flish1.atmsystem.repositories;

import org.flishl1.entity.TypeTransaction;
import org.flishl1.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TypeTransactionRepository implements IRepository<TypeTransaction, Integer>{
    private SessionFactory sessionFactory;

    public TypeTransactionRepository() {
        sessionFactory = HibernateUtil.buildSessionFactory();
    }

    @Override
    public TypeTransaction save(TypeTransaction entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public TypeTransaction update(TypeTransaction entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public void remove(TypeTransaction entity) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public TypeTransaction findById(Integer id) {
        TypeTransaction entity;
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            entity = session.get(TypeTransaction.class, id);
            session.getTransaction().commit();
        }
        return entity;
    }
}
