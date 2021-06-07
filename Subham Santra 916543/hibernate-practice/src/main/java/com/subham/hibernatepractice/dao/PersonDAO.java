package com.subham.hibernatepractice.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.subham.hibernatepractice.model.Person;
import com.subham.hibernatepractice.model.Student;

public class PersonDAO extends DAO {
	public boolean add(Person person) {
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();

			session.save(person);

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
	public List<Person> getAll() {
		Session session = getSession();
		List<Person> list = new ArrayList<Person>();

		Query<Person> namedQuery1 = session.getNamedQuery("find_all_persons");
//		Query<Person> namedQuery2 = session.getNamedQuery("find_all_students");

		// add persons
		// and students
		
		list.addAll(namedQuery1.list());
//		list.addAll(namedQuery2.list());
		
		return list;
	}
}
