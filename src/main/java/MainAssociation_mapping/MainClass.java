package MainAssociation_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.association_mapping.Laptop;
import com.association_mapping.Person;

public class MainClass {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Person.class);
		cfg.addAnnotatedClass(Laptop.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		// inserting

		Laptop l = new Laptop();
		l.setId(1001);
		l.setLname("Asus");

		Person p = new Person();
		p.setName("Ajay");
		p.setCity("PCMC");

		ss.persist(l);
		ss.persist(p);

		System.out.println("Inserting ...!");

		tr.commit();
		ss.close();
	}

}
