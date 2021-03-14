package com.society.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.society.model.Person;
import com.society.model.Record;
import com.society.repository.PersonRepo;
import com.society.util.DateUtil;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepo personRepo;
	
	@Autowired
	RecordService recordService;

	@Override
	public List<Person> getAllperson() {
		return personRepo.findAll();
	}

	@Override
	public Person getPerson(String name) {
		
		return personRepo.findByName(name);
	}

	@Override
	public Person addPerson(Person person) {
		return personRepo.save(person);
	}

	@Override
	public Person updatePerson(Person person) {
		return personRepo.save(person);
	}

	@Override
	public List<Record> getRecords(String name) {
		Person person =personRepo.findByName(name);
		
		return recordService.findByPerson(person);
	}

	@Override
	public List<Person> getPersonByDate(Date date) {
		List<Record> recordList =recordService.getRecordsByDate(date);
		List<Person> lPerson=recordList.stream().map(rec-> rec.getPerson()).collect(Collectors.toList());
		return lPerson;
	}


}
