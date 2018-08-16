package com.higor.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.higor.demo.model.Job;
import com.higor.demo.model.Task;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BancoInterApiTestFinalApplicationTests {

	@Test
	public void contextLoads() {
		Job uptJob = new Job();
		uptJob.setName("JOB 08");
		uptJob.setActive(true);
		
		Task uptTask = new Task();
		uptTask.setName("Task 05");
		uptTask.setWeight(13);
		uptTask.setCompleted(true);
		uptTask.setCreatedAt(new Date());
		
		ListJob();
		ListTask();
		addJob();
		addTask();
		findJob(1);
		findTask(1);
		deleteJob(2);
		deleteTask(2);
		updateJob(1,uptJob);
		updateTask(1,uptTask);
	}
	
	@SuppressWarnings({ "unchecked", "null" })
	public void ListJob() {
		Statement st = null;
		ResultSet rs;
		
		/*List Jobs
		http://localhost:8084/jobs*/
		try {
			rs = st.executeQuery("SELECT * FROM JOB;");
			List<Job> listJob = new ArrayList<Job>();
			List<Task> listTask = new ArrayList<Task>();
			while (rs.next()) {
				Job job = new Job();
				job.setId(rs.getInt("id"));
				job.setName(rs.getString("name"));
				job.setActive(rs.getBoolean("active"));
				job.setTasks((List<Task>) rs.getObject("tasks"));
				listJob.add(job);
			}
			for (Job job : listJob) {
				System.out.println("ID    : "+job.getId());
				System.out.println("Name  : "+job.getName());
				System.out.println("Active: "+job.isActive());
				System.out.println("Tasks : "+job.getTasks());
				for (Task task : listTask) {
					System.out.println("Tasks ID       :" + task.getId());
					System.out.println("Task Name      :" + task.getName());
					System.out.println("Tasks Weight   :" + task.getWeight());
					System.out.println("Tasks Completed:" + task.isCompleted());
					System.out.println("Tasks CreatedAt:" + task.getCreatedAt());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("null")
	public void ListTask() {
		Statement st = null;
		ResultSet rs;
		
		/*List Tasks
		http://localhost:8084/tasks*/
		try {
			rs = st.executeQuery("SELECT * FROM TASK;");
			List<Task> listTask = new ArrayList<Task>();
			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setWeight(rs.getInt("weight"));
				task.setCompleted(rs.getBoolean("completed"));
				task.setCreatedAt(rs.getDate("createdAt"));
				listTask.add(task);
			}
			for (Task task2 : listTask) {
				System.out.println("ID       :" + task2.getId());
				System.out.println("Name     :" + task2.getName());
				System.out.println("Weight   :" + task2.getWeight());
				System.out.println("Completed:" + task2.isCompleted());
				System.out.println("CreatedAt:" + task2.getCreatedAt());
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unused", "null" })
	public void addJob() {
		Statement st = null;
		ResultSet rs;
		
		/*Add Job
		http://localhost:8084/jobs
	    {
	        "id": 6,
	        "name": "JOB 06",
	        "active": false,
	        "tasks": []
	    }*/
		try {
			Job addJob = new Job();
			addJob.setName("JOB 06");
			addJob.setActive(true);
			
			rs = st.executeQuery("INSERT INTO JOB(NAME, ACTIVE) VALUES ('"+ addJob.getName() + "', "+addJob.isActive()+";");
			
			System.out.println("Job add sucessfull");
			st.close();
		}catch (SQLException e) {
			System.out.println("Job not add.");
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unused", "null" })
	public void addTask() {
		Statement st = null;
		ResultSet rs;
		
		/*Add Task
		http://localhost:8084/tasks
	    {
	        "id": 2,
	        "name": "TASK 031",
	        "weight": 10,
	        "completed": true,
	        "createdAt": "2018-08-14T20:09:33.095+0000"
	    }*/
		try {
			Task addTask = new Task();
			addTask.setName("TASK 04");
			addTask.setWeight(12);
			addTask.setCompleted(true);
			addTask.setCreatedAt(new Date());
			
			rs = st.executeQuery("INSERT INTO TASK(NAME, WEIGHT, COMPLETED, CREATED_AT) "
					+ "VALUES ('"+ addTask.getName() 
					+ "', "
					+ addTask.getWeight() 
					+ ", " 
					+ addTask.isCompleted() 
					+ ", "
					+ addTask.getCreatedAt() 
					+");");
			System.out.println("Task add sucessfull");
			
			
			st.close();
		}catch (SQLException e) {
			System.out.println("Task not add.");
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unused", "null" })
	public void findJob(int id) {
		Statement st = null;
		ResultSet rs;

		/*find Job ID
		http://localhost:8084/jobs/1   */
		try {
			rs = st.executeQuery("SELECT * FROM JOB WHERE ID = " + id +";");
			
			System.out.println("Job find sucessfull");
			st.close();
		}catch (SQLException e) {
			System.out.println("Job not find.");

			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unused", "null" })
	public void findTask(int id) {
		Statement st = null;
		ResultSet rs;
		
		/*find Task ID
		http://localhost:8084/task/1    */
		try {
			rs = st.executeQuery("SELECT * FROM TASK WHERE ID = " + id +";");

			System.out.println("Task find sucessfull");
			st.close();
		}catch (SQLException e) {
			System.out.println("Task not find.");
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unused", "null" })
	public void deleteJob(int id) {
		Statement st = null;
		ResultSet rs;
		
		/*DELETE Job ID
		http://localhost:8084/jobs/1   */
		try {
			rs = st.executeQuery("DELETE FROM JOB WHERE ID = " + id +";");
			
			System.out.println("Job delete sucessfull");
			st.close();
		}catch (SQLException e) {
			System.out.println("Job not delete.");
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unused", "null" })
	public void deleteTask(int id) {
		Statement st = null;
		ResultSet rs;
		
		/*DELETE Task ID
		http://localhost:8084/task/1    */
		try {
			rs = st.executeQuery("DELETE FROM TASK WHERE ID = " + id +";");

			System.out.println("Task delete sucessfull");
			st.close();
		}catch (SQLException e) {
			System.out.println("Task not delete.");
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unused", "null" })
	public void updateJob(int id, Job updateJob) {
		Statement st = null;
		ResultSet rs;
		
		/*UPDATE Job ID
		http://localhost:8084/jobs/1   */
		try {
			rs = st.executeQuery("UPDATE JOB SET NAME = '"+ updateJob.getName() +"', ACTIVE = " + updateJob.isActive() 
								+ "WHERE ID = " 
								+ "(SELECT ID FROM JOB WHERE ID = " + id +");");
			System.out.println("Job UPDATE sucessfull");
			st.close();
		}catch (SQLException e) {
			System.out.println("Job not UPDATE.");
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unused", "null" })
	public void updateTask(int id, Task updateTask) {
		Statement st = null;
		ResultSet rs;
		
		/*UPDATE Task ID
		http://localhost:8084/task/1    */
		try {

			
			rs = st.executeQuery("UPDATE TASK SET NAME = '"+ updateTask.getName() +"', WEIGHT = " + updateTask.getWeight()
								+"', COMPLETED = " + updateTask.isCompleted() 
								+"', CREATEDAT = " + updateTask.getCreatedAt() 
								+ "WHERE ID = " 
								+ "(SELECT ID FROM TASK WHERE ID = " + id +");");

			System.out.println("Task UPDATE sucessfull");			
			st.close();
		}catch (SQLException e) {
			System.out.println("Task not UPDATE.");
			e.printStackTrace();
		}
	}
}