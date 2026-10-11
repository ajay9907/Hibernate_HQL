package Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

public class UpdateData {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();

		Transaction tr = s.beginTransaction();

		String hql = "update Student set city = :city where id = :id";

		MutationQuery m = s.createMutationQuery(hql);
		m.setParameter("city", "Hydrabad");
		m.setParameter("id", 1050);

		m.executeUpdate();

		tr.commit();
		s.close();
		System.out.println("Updated data ...!");

	}

}
