package com.starikov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntryPoint {
    public static void main(String[] args) {

        final DBFrom dbFrom = new DBFrom();
        JFrame frame = new JFrame("DBFrom");
        frame.setContentPane(dbFrom.getPanel1());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



        final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        dbFrom.getAddToDatabaseButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                user.setUserName(dbFrom.getTextArea1().getText());
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
                session.close();
            }
        });
    }
}
