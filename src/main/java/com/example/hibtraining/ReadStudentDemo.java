package com.example.hibtraining;

import com.example.hibtraining.entity.Student;
import org.hibernate.Session;

public class ReadStudentDemo {
    public static void main(String[] args) {

        Student tempStudent = new Student("Boris", "Tree", "boristree@gmail.com", 43);


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.save(tempStudent);
            session.getTransaction().commit();

            System.out.println("Saved student. Generated id:  " + tempStudent.getId());

            session.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Get complete: " + myStudent);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
