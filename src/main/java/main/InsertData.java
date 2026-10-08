package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import Entity.Student;

public class InsertData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "insert into Student(id,age,city,name)values(:id,:age,:city,:name)";
		MutationQuery mq = ss.createMutationQuery(hqlQuery);
		mq.setParameter("id", 1020);

		mq.setParameter("age", 22);

		mq.setParameter("city", "Pune");

		mq.setParameter("name", "Arohi");

//		ss.persist(mq);

		mq.executeUpdate();

		System.out.println("Inserted Succesfully");
		tr.commit();
		ss.close();
	}
}
