package com.higor.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.higor.demo.model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {


}
