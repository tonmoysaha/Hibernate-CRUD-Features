package com.hibernate.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			Student student = new Student("dropode", "saha", "maloveyou@gmail.com");

			session.beginTransaction();

			session.save(student);

			session.getTransaction().commit();

			System.out.println("the id: " + student.getId());

			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			Student theStudent = session.get(Student.class, student.getId());
			System.out.println(theStudent);
			System.out.println(theStudent.getFristName() + theStudent.getEmail());

			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}

	}

}
