package com.higor.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.higor.demo.dao.JobRepo;
import com.higor.demo.model.Job;

@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	JobRepo repo;
	
	//add job
	@PostMapping
	public Job addJob(@RequestBody Job job) {
		return repo.save(job);
	}
	
	//List jobs
	@GetMapping
	public List<Job> list(){
		return (List<Job>) repo.findAll();
	}
	
	//Find job
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Job>> findJob(@PathVariable int id) {
		Optional<Job> job = repo.findById(id);
		if(job == null) {
			return ResponseEntity.notFound().build();
		}
        return ResponseEntity.ok(job);
    }
	
	//Update Job
	@PutMapping("/{id}")
	public ResponseEntity<Optional<Job>> updateJob(@PathVariable int id, @RequestBody Optional<Job> job) {
		Optional<Job> jobOrigin = repo.findById(id);
		if(jobOrigin == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(job, jobOrigin, "id");
        return ResponseEntity.ok(job);
    }
	
	//Delete Task
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteJob(@PathVariable int id) {
		Optional<Job> job = repo.findById(id);
		if(job == null) {
			return ResponseEntity.notFound().build();
		}
		repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
