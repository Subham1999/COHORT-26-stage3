package com.subham.hibernatepractice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.subham.hibernatepractice.model.Product;

public class ProductDAO extends DAO {

	public boolean add(Product product) {
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();

			session.save(product);

			try {
				transaction.commit();
				session.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return false;
			}

			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAll() {
		Session session = getSession();

		Query<Product> namedQuery = session.getNamedQuery("find_all");

		List<Product> list = namedQuery.list();
		System.out.println(list);
		return list;
	}
}