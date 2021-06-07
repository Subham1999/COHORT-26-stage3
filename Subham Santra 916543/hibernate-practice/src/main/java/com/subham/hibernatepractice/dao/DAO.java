package com.subham.hibernatepractice.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author Subham
 *
 *         Just implementation of default behaviors
 */
public abstract class DAO {
	StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
			.configure("hibernate.cfg.xml").build();
	Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
	SessionFactory sessionFactory = metadata.buildSessionFactory();

	protected Session getSession() {
		Session openSession = sessionFactory.openSession();
		return openSession;
	}

	public void close() {
		try {
			sessionFactory.close();
			standardServiceRegistry.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
