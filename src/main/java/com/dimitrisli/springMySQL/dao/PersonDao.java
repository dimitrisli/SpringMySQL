package com.dimitrisli.springMySQL.dao;

import java.util.List;

import com.dimitrisli.springMySQL.model.Person;


public abstract interface PersonDao {

	public abstract void createPerson(String name, String surname);
	public abstract List<Person> selectPerson(String name, String surname);
	public abstract List<Person> selectAll();
	public abstract void deletePerson(String name, String surname);
	public abstract void deleteAll();
}
