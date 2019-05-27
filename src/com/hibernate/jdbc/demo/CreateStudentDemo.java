package com.hibernate.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		try {
			Student student = new Student();
			student.setFristName("opi");
			student.setLastName("saha");
			student.setEmail("opi@gmail.com");

			session.beginTransaction();

			session.save(student);

			session.getTransaction().commit();
		} finally {
			sessionFactory.close();

		}

	}

}
