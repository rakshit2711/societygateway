package com.society.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the record database table.
 * 
 */
@Entity
@NamedQuery(name="Record.findAll", query="SELECT r FROM Record r")
public class Record implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rid;

	private String entryexit;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timeVisited;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="pid")
	private Person person;

	public Record() {
	}

	public int getRid() {
		return this.rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getEntryexit() {
		return this.entryexit;
	}

	public void setEntryexit(String entryexit) {
		this.entryexit = entryexit;
	}

	public Date getTimeVisited() {
		return this.timeVisited;
	}

	public void setTimeVisited(Date timeVisited) {
		this.timeVisited = timeVisited;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}