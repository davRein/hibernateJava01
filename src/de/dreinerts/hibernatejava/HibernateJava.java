package de.dreinerts.hibernatejava;

import java.util.List;
import java.util.Properties;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


public class HibernateJava {

	
	public static SessionFactory buildSessionFactory() {
		SessionFactory sf = null;

		if (sf == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml configuration file
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/testdb");
				settings.put(Environment.USER, "dreinerts");
				settings.put(Environment.PASS, "mnidr1982!");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

				//settings.put(Environment.SHOW_SQL, "true");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Addresses.class);

				ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

				sf = configuration.buildSessionFactory(sr);
				
				System.out.println("Successfully connected to the database\n");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed connecting to the database");
			}
		}
		return sf;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = buildSessionFactory().openSession();
		session.beginTransaction();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Addresses> criteria = cb.createQuery(Addresses.class);
		criteria.from(Addresses.class);
		
		List<Addresses> addresses = session.createQuery(criteria).getResultList();
		
		for (Addresses list : addresses) {
			System.out.println("Lastname: " + list.getStrLastname() + " | Firstname: " + list.getStrFirstname());
		}
	}
	
	
}
