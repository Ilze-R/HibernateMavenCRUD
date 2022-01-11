package com.example.hibtraining;

import com.example.hibtraining.entity.Student;
import org.hibernate.Session;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        // Student tempStudent = new Student("Boris", "Tree", "boristree@gmail.com", 43);


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            long studentId = 1L;


            session.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating student ... ");
            myStudent.setFirstName("Valters");

            session.getTransaction().commit();

            //NEW CODE

            session.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            //update email for a  students
            System.out.println("Update email for all students ... ");
            session.createQuery("update Student set email = 'boom@inbox.lv'").executeUpdate();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
