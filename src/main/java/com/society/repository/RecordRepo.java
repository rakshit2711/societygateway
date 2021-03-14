package com.society.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.society.model.Person;
import com.society.model.Record;
@Repository
public interface RecordRepo extends JpaRepository<Record, Integer> {

	List<Record> findAllByPerson(Person person);

}
