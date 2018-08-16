package com.higor.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name= "JOB")
public class Job {
	@Id
	@Column(name="ID")
	@GeneratedValue
	private int id ;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ACTIVE")
	private boolean active;
	
    @OneToMany( targetEntity=Task.class )
    private List<Task> tasks;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", name=" + name + ", active=" + active + ", tasks=" + tasks + "]";
	}
}
