package com.higor.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.higor.demo.model.Job;

public interface JobRepo extends JpaRepository<Job, Integer> {

	void saveAndFlush(Optional<Job> job);
}
