package com.subham.hibernatepractice.application;

import java.util.List;

import com.subham.hibernatepractice.dao.PersonDAO;
import com.subham.hibernatepractice.dao.ProductDAO;
import com.subham.hibernatepractice.model.Address;
import com.subham.hibernatepractice.model.Person;
import com.subham.hibernatepractice.model.Product;
import com.subham.hibernatepractice.model.Student;

public class Main {
	public static void main(String[] args) {
//		productTest();
		personTest();
	}

	@SuppressWarnings("unused")
	private static void personTest() {
		
		// Create new Addresses for FUTURE
		List<Address> addresses = List.of(new Address("M.G. Road", "Kolkata", "West Bengal", "71113"),
				new Address("S.B. Chandra Road", "Kolkata", "West Bengal", "711303"),
				new Address("S.N. Banerjee Road", "Kalikapur", "West Bengal", "711500"),
				new Address("V.P. Road", "Madhyamgram", "West Bengal", "711800"));

		// Create new person for TEST
		// Two Persons in list
		// 1. Student 	-> SUBHAM
		// 2. Person	-> MUKUL
		List<Person> persons = List.of(
				new Student(0, "Subham Santra", addresses.get(0), "Computer Sciend and Engineering"),
				new Person(0, "Mukul Santra", addresses.get(2)));

		// Add friends of SUBHAM
		persons.get(0).getFriendNames().add("Souvik Santra");
		persons.get(0).getFriendNames().add("Soumyadeep Guin");
		persons.get(0).getFriendNames().add("Soumalya Pan");

		// Add friends of MUKUL
		persons.get(1).getFriendNames().add("Ram Santra");
		persons.get(1).getFriendNames().add("Shyam Santra");

		// Create PERSON DAO
		PersonDAO personDAO = new PersonDAO();

		// Add to database
		persons.forEach(personDAO::add);

		List<Person> storedPersons = personDAO.getAll();

		// print
		space();
		storedPersons.forEach(System.out::println);
		space();

		// close all resources
		personDAO.close();
	}

	/**
	 * Give few new lines in console for spacing
	 */
	private static void space() {
		System.out.println();
		System.out.println();
		System.out.println();
	}

	/**
	 * Add product list to database and check if it returns same
	 */
	@SuppressWarnings("unused")
	private static void productTest() {
		List<Product> products = List.of(new Product(1, "product name 1", "description 1", 1000),
				new Product(2, "product name 2", "description 2", 2000),
				new Product(3, "product name 3", "description 3", 3000),
				new Product(4, "product name 4", "description 4", 4000),
				new Product(5, "product name 5", "description 5", 5000));

		// CREATE ProductDAO
		ProductDAO productDAO = new ProductDAO();

		// Add to database
		products.forEach(productDAO::add);

		// Fetch from Database
		List<Product> list = productDAO.getAll();
		// Print on console
		list.forEach(System.err::println);

		// close all resources
		productDAO.close();
	}
}
