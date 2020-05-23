package ru.job4j.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//public class DB {
//    private final SessionFactory sessionFactory;
//
//    public static final DB INSTANCE = new DB();
//
//    public DB() {
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure()
//                .build();
//        this.sessionFactory = new MetadataSources(registry)
//                .buildMetadata()
//                .buildSessionFactory();
//    }
//
//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public static DB getInstance() {
//        return INSTANCE;
//    }
//}

public class DB {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            return new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error building the factory");
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
