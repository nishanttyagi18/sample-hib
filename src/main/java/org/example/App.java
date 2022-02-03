package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

/**
 * Fetching data from the database
 */
        Alien nishant_data = session.get(Alien.class, 1);
        System.out.println(nishant_data);


/**
 * Object under object
 */
        Alien nishant = new Alien();

        AlienName nishant_name = new AlienName();
        nishant_name.setFname("Nishant");
        nishant_name.setLname("Tyagi");
        nishant_name.setMname("Kumar");

        nishant.setAid(3);
        nishant.setAname(nishant_name);
        nishant.setColor("Blue");

        session.save(nishant);

        tx.commit();
        session.close();
    }
}
