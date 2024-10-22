package ru.flish1.atmsystem.repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.flishl1.entity.User;
import org.flishl1.models.entity.Profile_;
import org.flishl1.models.entity.User_;
import org.flishl1.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserRepository implements IRepository<User, Long>{
    private final SessionFactory sessionFactory;

    public UserRepository() {
        sessionFactory = HibernateUtil.buildSessionFactory();
    }

    @Override
    public User save(User entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public User update(User entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public void remove(User entity) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
        }
    }

    public boolean remove(Long id) {
        try (Session session = sessionFactory.openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaDelete<User> criteria = cb.createCriteriaDelete(User.class);
            Root<User> user = criteria.from(User.class);
            criteria.where(cb.equal(user.get("id"), id));

            session.beginTransaction();
            session.createMutationQuery(criteria).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public User findById(Long id) {
        User entity;
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            entity = session.get(User.class, id);
            session.getTransaction().commit();
        }
        return entity;
    }

    public User findBySerialPassportAndNumberPassport(Integer seriesPassport, Integer numberPassport) {
        User user = null;
        try (Session session = sessionFactory.openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
            Root<User> user_ = criteriaQuery.from(User.class);

            criteriaQuery.select(user_).where(
                    cb.and(
                            cb.equal(user_.get(User_.profile).get(Profile_.SERIES_PASSPORT), seriesPassport),
                            cb.equal(user_.get(User_.profile).get(Profile_.NUMBER_PASSPORT), numberPassport)
                    )
            );

            session.beginTransaction();

            user = session.createQuery(criteriaQuery).getSingleResultOrNull();
            session.getTransaction().commit();
        }
        return user;
    }
}
