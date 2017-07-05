package com.hotel.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public final class HibernateUtil {
	
	private static final SessionFactory sessionFactory=buildSessionFactory();

	private static final SessionFactory buildSessionFactory() {
		
		try{
			Configuration cfg=new Configuration();
			cfg.configure();
			ServiceRegistry registry=new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
			return cfg.buildSessionFactory(registry);
		}catch(ExceptionInInitializerError e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public void shutDown(){
		sessionFactory.close();
	}
}
