package com.example.hibtraining;

import com.example.hibtraining.entity.Student;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        Student student2 = new Student("Anna", "Upe", "anna@gmail.com",30);
        Student student3 = new Student("Karlis", "Ozols", "karlis@gmail.com",15);
        Student student4 = new Student("Rudite", "Liela", "rudite@inbox.com",67);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.save(student2);
            session.save(student3);
            session.save(student4);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
