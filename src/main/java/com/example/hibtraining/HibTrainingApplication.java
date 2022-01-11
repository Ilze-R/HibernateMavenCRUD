package com.example.hibtraining;

import com.example.hibtraining.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibTrainingApplication.class, args);

        Student student1 = new Student("Janis", "Liepa", "janis@gmail.com",20);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.save(student1);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

