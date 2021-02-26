package com.deloitte.todo.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TODO_LIST")
public class TodoList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "userName")
	private String userName;
	@Column(name = "description")
	private String description;
	@Column(name = "targetDtae")
	private Date targetDate;
	@Column(name = "updatedDate")
	private Date updatedDate;
	@Column
	private boolean complete;

	

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public TodoList() {

	}

	public TodoList(String userName, String description, Date targetDate, Date updateDate,boolean complete) {

		this.userName = userName;
		this.description = description;
		this.targetDate = targetDate;
		this.updatedDate = updateDate;
		this.complete = complete;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}