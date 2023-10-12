package com.telusko.entity;

import java.util.Date;

import javax.persistence.*;

@Entity(name = "springers")
public class Springers {

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date	date;
	
	@Temporal(TemporalType.TIME) //mapping the datatype of column defined in sql
	@Column(name = "time")
	private Date	time;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateTime")
	private Date	DateTime;
	
	@Lob                             // binary large objects
	@Column(name = "image")
	private byte[] image;             // for storing image in database
	
	@Lob
	@Column(name = "characters")
	private char[] characters;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public char[] getCharacter() {
		return characters;
	}

	public void setCharacter(char[] character) {
		this.characters = character;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getDateTime() {
		return DateTime;
	}

	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}
	
	
}
