package com.example.hibtraining;

import com.example.hibtraining.entity.Student;
import org.hibernate.Session;

public class DeleteStudentDemo {
    public static void main(String[] args) {

        // Student tempStudent = new Student("Boris", "Tree", "boristree@gmail.com", 43);


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            long studentId = 1L;

            session.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            //System.out.println("Deleting student: " + myStudent);
            //session.delete(myStudent);

            //delete student id=2
            System.out.println("Deleting student with id=2 ");
            session.createQuery("delete from Student where id=2").executeUpdate(); //executeUpdate also for deleting

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
