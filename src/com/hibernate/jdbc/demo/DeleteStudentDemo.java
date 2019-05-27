package com.hibernate.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			int studentId = 4;

			session.beginTransaction();

			Student myStudent = session.get(Student.class, studentId);

			session.delete(myStudent);

			System.out.println("student deleted successsfully");

			session.getTransaction().commit();

			// other deleted code process

			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			session.createQuery("delete from Student where id=3").executeUpdate();

			session.getTransaction().commit();

			System.out.println("student deleted successfully ");
		} finally {
			sessionFactory.close();
		}

	}

}
