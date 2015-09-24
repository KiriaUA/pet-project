package com.starikov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EntryPoint {
    public static void main(String[] args) {
        User user = new User();
        user.setUserId(1);
        user.setUserName("Kyryll");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(user);
        session.getTransaction().commit();
    }
}
