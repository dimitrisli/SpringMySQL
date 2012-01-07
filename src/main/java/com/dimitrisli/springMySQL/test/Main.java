package com.dimitrisli.springMySQL.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dimitrisli.springMySQL.dao.PersonDaoImpl;
import com.dimitrisli.springMySQL.model.Person;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/beanLocations.xml");
		PersonDaoImpl personDao = (PersonDaoImpl) context.getBean("personDao"); 
		
		System.out.println("Adding data...");
		personDao.createPerson("dimitris","liapis");
		personDao.createPerson("michalis","liapis");
		personDao.createPerson("kostas","liapis");
		personDao.createPerson("stella","georgiou");
		
		System.out.println("Retrieving data..");
		for(Person currentPerson : personDao.selectAll()){
			System.out.println("From DB: name="+currentPerson.getName()+", surname="+currentPerson.getSurname());
		}
		
		System.out.println("Deleting record dimitris and viewing...");
		personDao.deletePerson("dimitris", "liapis");
		for(Person currentPerson : personDao.selectAll()){
			System.out.println("From DB: name="+currentPerson.getName()+", surname="+currentPerson.getSurname());
		}
		
		System.out.println("Adding a new record and viewing...");
		personDao.createPerson("testName", "testSurname");
		for(Person currentPerson : personDao.selectAll()){
			System.out.println("From DB: name="+currentPerson.getName()+", surname="+currentPerson.getSurname());
		}
		
		System.out.println("Deleting everything and viewing...");
		personDao.deleteAll();
		for(Person currentPerson : personDao.selectAll()){
			System.out.println("From DB: name="+currentPerson.getName()+", surname="+currentPerson.getSurname());
		}
		
	}
}
