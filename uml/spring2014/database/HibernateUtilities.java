package uml.spring2014.database;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtilities {
	
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistryBuilder serviceRegistry;
	
	static
	{  
		try
		{
			Configuration configuration = new Configuration().configure();
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			sessionFactory = configuration.buildSessionFactory((ServiceRegistry) serviceRegistry);
			
		}
		catch (HibernateException exception)
		{
			System.out.println("Problem creating session factory");
		}
	}
public static SessionFactory getSessionFactory()
{
	return sessionFactory;
}
}
