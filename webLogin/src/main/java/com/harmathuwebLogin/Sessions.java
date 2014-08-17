package com.harmathuwebLogin;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import java.util.Calendar;
import java.util.UUID;

//import org.joda.time.DateTime;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;

@Entity
public class Sessions {

	@Id
	@Column(unique = true)
	private String sessionId;

	@ManyToOne(cascade = CascadeType.ALL)
	private Users users;

	private Calendar startDate;

	private Calendar latestDate;

	public Sessions() {
		super();
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getLatestDate() {
		return latestDate;
	}

	public Sessions(Users users, Calendar startDate, Calendar latestDate) {
		super();
		this.users = users;
		this.startDate = startDate;
		this.latestDate = latestDate;
		this.generateSesssionId();
	}

	public void setLatestDate(Calendar latestDate) {
		this.latestDate = latestDate;
	}

	@HandleBeforeSave
	public void generateSesssionId() {
		UUID idOne = UUID.randomUUID();
		UUID idTwo = UUID.randomUUID();
		this.setSessionId(idOne.toString() + idTwo.toString());
	}
}
