package com.higor.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "PARENT_JOB")
public class ParentJob {
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private int id ;

	@Column(name="IDJOBPRIMARY" )
	private int idJobPrimary;
	
	@Column(name="IDJOBSECUNDARY" )
	private int idJobSecundary;

	public int getIdJobPrimary() {
		return idJobPrimary;
	}

	public void setIdJobPrimary(int idJobPrimary) {
		this.idJobPrimary = idJobPrimary;
	}

	public int getIdJobSecundary() {
		return idJobSecundary;
	}

	public void setIdJobSecundary(int idJobSecundary) {
		this.idJobSecundary = idJobSecundary;
	}

	@Override
	public String toString() {
		return "ParentJob [idJobPrimary=" + idJobPrimary + ", idJobSecundary=" + idJobSecundary + "]";
	}
}
