package ru.flish1.atmsystem.utils;

import org.flishl1.entity.*;
import org.flishl1.models.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {

    private static final Logger log = LoggerFactory.getLogger(HibernateUtil.class);

    public static SessionFactory buildSessionFactory(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();
        try {
            return new MetadataSources(registry)
                            .addAnnotatedClass(Account.class)
                            .addAnnotatedClass(User.class)
                            .addAnnotatedClass(AccountTransaction.class)
                            .addAnnotatedClass(Bank.class)
                            .addAnnotatedClass(Transaction.class)
                            .addAnnotatedClass(TypeTransaction.class)
                            .buildMetadata()
                            .buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we
            // had trouble building the SessionFactory so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
            log.error(e.toString());
            System.exit(1);
        }

        return null;
    }

}
