package com.society.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.society.model.Person;
import com.society.model.Record;
import com.society.services.PersonService;
import com.society.services.RecordService;
import com.society.util.DateWrapper;

@RestController
@RequestMapping("/society")
public class HomeController {

	
	@Autowired
	PersonService personService;
	
	@Autowired
	RecordService recordService;
	
	@GetMapping("/person")
	public ResponseEntity<List<Person>> getPerson(){
		List<Person> personList=personService.getAllperson();
		return new ResponseEntity<>(personList, HttpStatus.OK);
	}
	
	@GetMapping("/person/{name}")
	public ResponseEntity<Person> getPersonByName(@PathVariable("name") String name){
		Person person=personService.getPerson(name);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}
	
	@PostMapping("/person")
	public ResponseEntity<Person> addPerson(@RequestBody Person person){
		personService.addPerson(person);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}
	
	@PutMapping("/person/{name}")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person){
		personService.updatePerson(person);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}
	
	
	@GetMapping("/person/{name}/record")
	public ResponseEntity<List<Record>> getPersonRecords(@PathVariable("name") String name){
		List<Record> records = personService.getRecords(name);
		return new ResponseEntity<>(records, HttpStatus.OK);
	}
	
	
	@GetMapping("/record")
	public ResponseEntity<List<Record>> getAllRecord(){
		List<Record> recordList=recordService.getAllrecords();
		return new ResponseEntity<>(recordList, HttpStatus.OK);
	}
	
	
	@PostMapping("/record")
	public ResponseEntity<Record> addRecord(@RequestBody Record record){
		recordService.addRecord(record);
		return new ResponseEntity<>(record, HttpStatus.OK);
	}
	
	@PutMapping("/record/{id}")
	public ResponseEntity<Record> updateRecord(@RequestBody Record record){
		recordService.updateRecord(record);
		return new ResponseEntity<>(record, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/record/date")
	public ResponseEntity<List<Record>> getRecords(@RequestBody DateWrapper datewrapper) throws ParseException{
//		String pattern = "yyyy-MM-dd";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		Date date=simpleDateFormat.parse(dateStr);
		List<Record> recordList=null;
		if(Objects.nonNull(datewrapper)&&Objects.nonNull(datewrapper.getOn()))
			recordList=recordService.getRecordsByDate(datewrapper.getOn());
		else if(Objects.nonNull(datewrapper)&&Objects.nonNull(datewrapper.getFrom())&&Objects.nonNull(datewrapper.getTo()))
			recordList=recordService.getRecordsByDate(datewrapper.getFrom(),datewrapper.getTo());
		return new ResponseEntity<>(recordList, HttpStatus.OK);
	}
}
