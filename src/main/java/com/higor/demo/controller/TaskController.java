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

import com.higor.demo.dao.TaskRepo;
import com.higor.demo.model.Task;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskRepo repo;
	
	//add task
	@PostMapping
	public Task addTask(@RequestBody Task task) {
		return repo.save(task);
	}
	
	//List Task
	@GetMapping
	public List<Task> list(){
		return (List<Task>) repo.findAll();
	}
	
	//Find Task
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Task>> findTask(@PathVariable int id) {
		Optional<Task> task = repo.findById(id);
		if(task == null) {
			return ResponseEntity.notFound().build();
		}
        return ResponseEntity.ok(task);
    }
	
	//Update Task
	@PutMapping("/{id}")
	public ResponseEntity<Optional<Task>> updateTask(@PathVariable int id, @RequestBody Optional<Task> task) {
		Optional<Task> taskOrigin = repo.findById(id);
		if(taskOrigin == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(task, taskOrigin, "id");
        return ResponseEntity.ok(taskOrigin);
    }
	
	//Delete Task
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable int id) {
		Optional<Task> task = repo.findById(id);
		if(task == null) {
			return ResponseEntity.notFound().build();
		}
		repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
