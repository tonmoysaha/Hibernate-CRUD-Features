package com.hibernate.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			int studentId = 5;

			session.beginTransaction();

			Student myStudent = session.get(Student.class, studentId);

			myStudent.setEmail("ma@gmail.com");

			System.out.println("updating student");

			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}

}
