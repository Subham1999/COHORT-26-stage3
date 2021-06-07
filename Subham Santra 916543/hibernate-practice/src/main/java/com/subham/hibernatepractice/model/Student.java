package com.subham.hibernatepractice.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "find_all_students", query = "from Student") })
public class Student extends Person {
	private String stream;

	public Student(int id, String name, Address address, String stream) {
		super(id, name, address);
		this.stream = stream;
	}

	public Student() {
		super();
	}

	public Student(int id, String name, Address address) {
		super(id, name, address);
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	@Override
	public String toString() {
		return "Student : " + super.toString() + ", stream = " + stream;
	}

}
