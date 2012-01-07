package com.dimitrisli.springMySQL.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dimitrisli.springMySQL.model.Person;


public class PersonDaoImpl implements PersonDao{

	DataSource dataSource;
	
	public void createPerson(String name, String surname) {
		JdbcTemplate createPerson = new JdbcTemplate(dataSource);
		createPerson.update("INSERT INTO PERSON_RECORD (NAME,SURNAME) VALUES (?,?)",
				new Object[]{name,surname});
	}

	public List<Person> selectPerson(String name, String surname) {
		JdbcTemplate selectPerson = new JdbcTemplate(dataSource);
		return selectPerson.query("SELECT NAME,SURNAME FROM PERSON_RECORD WHERE NAME=? AND SURNAME=?",
				new Object[] {name,surname},
				new PersonRowMapper());
	}

	public List<Person> selectAll() {
		JdbcTemplate selectPerson = new JdbcTemplate(dataSource);
		return selectPerson.query("SELECT NAME,SURNAME FROM PERSON_RECORD",
				new PersonRowMapper());
	}

	public void deletePerson(String name, String surname) {
		JdbcTemplate deletePerson = new JdbcTemplate(dataSource);
		deletePerson.update("DELETE FROM PERSON_RECORD WHERE NAME=? AND SURNAME=?",
				new Object[]{name,surname});		
	}

	public void deleteAll() {
		JdbcTemplate deleteAll = new JdbcTemplate(dataSource);
		deleteAll.update("DELETE FROM PERSON_RECORD");
	}
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}

}
