package com.example.hibtraining;

import com.example.hibtraining.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();

            //query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();
            //display students
            for (Student thisStudent :
                    theStudents) {
                System.out.println(thisStudent);
            }
            // query students : lastName = 'Tree'
            theStudents = session.createQuery("from Student s where s.lastName = 'Tree'").getResultList();
            for(Student thisStudent : theStudents){
                System.out.println("\n\nStudents who have last name Tree: " + thisStudent);
            }

            theStudents = session.createQuery("from Student s where" + " s.lastName = 'Tree' OR s.firstName = 'Anna'").getResultList();
            for(Student thisStudent : theStudents){
                System.out.println("\n\nStudents who have last name Tree or first name Anna: " + thisStudent);
            }

            theStudents = session.createQuery("from Student s where " + "s.email LIKE '%gmail.com'").getResultList();
            for(Student thisStudent : theStudents){
                System.out.println("\n\nStudents whose email ends with gmail.com " + thisStudent);
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
