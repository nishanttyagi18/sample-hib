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

        laptop.getStudent().add(student);
        student.getLaptop().add(laptop);

        /**
         *  Reference is created in Laptop table
         *  But it can't be created in Student because student has roll no as primary key
         */

        session.save(student);
        session.save(laptop);

        tx.commit();
        session.close();
    }
}
