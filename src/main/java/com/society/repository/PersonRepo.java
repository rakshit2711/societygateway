package com.society.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.society.model.Person;
@Repository
public interface PersonRepo extends JpaRepository<Person , Integer> {

	Person findByName(String name);

}
