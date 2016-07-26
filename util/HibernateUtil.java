package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {

		try {
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Enitial SessionFactory creation failed" + e);
			throw new ExceptionInInitializerError(e);
		}
	}


	public static void close() {
		sessionFactory.close();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
