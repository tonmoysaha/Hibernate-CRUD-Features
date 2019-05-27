package com.hibernate.jdbc.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.entity.Student;

public class queryingStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();

			List<Student> student = session.createQuery("from Student").getResultList();

			displayStudent(student);
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}

	}

	private static void displayStudent(List<Student> student) {
		for (Student student2 : student) {
			System.out.println(student2.getEmail());
		}
	}

}
