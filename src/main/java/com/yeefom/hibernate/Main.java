package com.yeefom.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();

            session.beginTransaction();

//            addStudent(session);
//            Student retrieved = retrieveStudent(session);
//            List<Student> students = queryStudents(session);
//            updateStudent(retrieved);
//            updateStudentWithQuery(session);
            deleteStudent(session);
            deleteStudentWithQuery(session);

            session.getTransaction().commit();
        }
    }

    private static void addStudent(Session session) {
        Student student = new Student("Alex", "Ham", "aham@federalists.com");
        session.save(student);
    }

    private static Student retrieveStudent(Session session) {
        Student student = session.get(Student.class, 1);
        System.out.println(student);
        return student;
    }

    private static List<Student> queryStudents(Session session) {
        List<Student> students = session.createQuery("FROM Student WHERE Student.lastName='Ham'", Student.class)
                .getResultList();
        for (Student student : students) {
            System.out.println(student);
        }
        return students;
    }

    private static void updateStudent(Student student) {
        student.setLastName("Burr");
    }

    private static void updateStudentWithQuery(Session session) {
        session.createQuery("UPDATE Student SET email='aburr@federalists.com' WHERE lastName = 'Burr'")
                .executeUpdate();
    }

    private static void deleteStudent(Session session) {
        Student student = session.get(Student.class, 1);
        session.delete(student);
    }

    private static void deleteStudentWithQuery(Session session) {
        session.createQuery("DELETE FROM Student WHERE id = 2")
                .executeUpdate();
    }
}
