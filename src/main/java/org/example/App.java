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

/**
 * MAPPING RELATIONS
 */

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        Laptop laptop = new Laptop();
        laptop.setId(101);
        laptop.setLname("Dell");

        Student student = new Student();
        student.setRollno(1);
        student.setName("Nishant Tyagi");
        student.setMarks(100);
        student.setLaptop(laptop);        // one to one mapping


        session.save(student);
        session.save(laptop);




        tx.commit();
        session.close();
    }
}
