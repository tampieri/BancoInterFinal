package com.higor.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.higor.demo.model.Job;

public interface JobRepo extends JpaRepository<Job, Integer> {

	//void updateJob(int id, Job job);
	
	
	

	/*List<Job> findByName(String name);
	
	List<Job> findByIdGreaterThan(int id);
	
	@Query("from Job where tech=?1 order by name")
	List<Job> findByNameSorted(String name);*/
}
