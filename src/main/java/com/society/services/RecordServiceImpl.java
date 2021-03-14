package com.society.services;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.society.model.Person;
import com.society.model.Record;
import com.society.repository.RecordRepo;
import com.society.util.DateUtil;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	RecordRepo recordRepo;
	
	@Autowired
	PersonService personService;
	
	@Override
	public List<Record> findByPerson(Person person) {
		
		return recordRepo.findAllByPerson(person);
	}

	@Override
	public List<Record> getRecordsByDate(Date date) {
		List<Record> recordsList=recordRepo.findAll();
		return recordsList.stream().filter(rec->
			DateUtil.getZeroTimeDate(rec.getTimeVisited()).equals(DateUtil.getZeroTimeDate(date))).collect(Collectors.toList());
	}

	@Override
	public List<Record> getAllrecords() {
		return recordRepo.findAll();
	}

	@Override
	public Record addRecord(Record rec) {
		Person person=rec.getPerson();
		if(Objects.isNull(personService.getPerson(person.getName()))){
			rec.setPerson(personService.addPerson(person));
		}else {
			rec.setPerson(personService.getPerson(person.getName()));
		}
		return recordRepo.save(rec);
	}

	@Override
	public Record updateRecord(Record rec) {
		return recordRepo.save(rec);
	}

	@Override
	public List<Record> getRecordsByDate(Date from, Date to) {
		List<Record> recordsList=recordRepo.findAll();
		return recordsList.stream().filter(rec->
			rec.getTimeVisited().compareTo(from)>=0&&
			rec.getTimeVisited().compareTo(to)<0
				).collect(Collectors.toList());
	}
	
	


}
