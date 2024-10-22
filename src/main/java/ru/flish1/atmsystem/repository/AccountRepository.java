package ru.flish1.atmsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.flish1.atmsystem.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
//
//    public Account save(Account entity) {
//        try (Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            session.persist(entity);
//            session.getTransaction().commit();
//        }
//        return entity;
//    }
//
//    public Account update(Account entity) {
//        try (Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            session.merge(entity);
//            session.getTransaction().commit();
//        }
//        return entity;
//    }
//
//    public void remove(Account entity) {
//        try (Session session = sessionFactory.openSession()){
//            session.beginTransaction();
//            session.remove(entity);
//            session.getTransaction().commit();
//        }
//    }
//
//    public Account getById(Long id) {
//        Account entity;
//        try (Session session = sessionFactory.openSession()){
//            session.beginTransaction();
//            entity = session.get(Account.class, id);
//            session.getTransaction().commit();
//        }
//        return entity;
//    }
}
