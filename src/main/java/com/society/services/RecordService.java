package com.society.services;

import java.util.Date;
import java.util.List;

import com.society.model.Person;
import com.society.model.Record;

public interface RecordService {
	public List<Record> getAllrecords();
	
	public Record addRecord(Record rec);
	
	
	public Record updateRecord(Record rec);
	
	List<Record> findByPerson(Person person);

	List<Record> getRecordsByDate(Date from, Date to);
	
	List<Record> getRecordsByDate(Date on);

}
