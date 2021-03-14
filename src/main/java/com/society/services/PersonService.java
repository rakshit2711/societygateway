package com.society.services;

import java.util.Date;
import java.util.List;

import com.society.model.Person;
import com.society.model.Record;

public interface PersonService {
	public List<Person> getAllperson();
	
	public Person getPerson(String name);
	
	public Person addPerson(Person person);
	
	public Person updatePerson(Person person);
	
	public List<Record> getRecords(String name);
	
	public List<Person> getPersonByDate(Date date);
 }
