<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add Task</title>
</head>
<body>
	<div>
		<form action="addTask">
			<label>### NEW TASK ###</label><br/><br/>
			<label>Name: </label>
			<input type="text" name="name" /><br/><br/>
			<label>Weight: </label>
			<input type="text" name="weight" /><br/><br/>
			<label>Completed:</label>
			<input type="radio" name="completed" value="1" checked="checked">True</input>
			<input type="radio" name="completed" value="0">False</input><br/><br/>
			<label>createdAt: </label>
			<input type="text" name="createdAt" /><br/><br/>
			<input type="submit" value="Add"/><br/>
		</form>
		<br/><br/>
	</div>
	<div>
		<form action="updateTask">
			<label>### UPDATE TASK ###</label><br/><br/>
			<label>Id: </label>
			<input type="text" name="id"/><br/><br/>
			<input type="submit" value="Update"/>
		</form>
		<br/><br/>
	</div>
	<div>
		<form action="findTask">
			<label>### SEARCH TASK ###</label><br/><br/>
			<label>Id: </label>
			<input type="text" name="id"/><br/><br/>
			<input type="submit" value="Search"/>
		</form>
		<br/><br/>
	</div>
	<div>
		<form action="deleteTask">
			<label>### DELETE TASK ###</label><br/><br/>
			<label>Id: </label>
			<input type="text" name="id"/><br/><br/>
			<input type="submit" value="Delete"/><br/><br/>
		</form>
	</div>
	<div>
		<form action="list">
			<label>### LIST TASKS ###</label><br />
			<input type="submit" value="Loading..."/>
		</form>
	</div>
	<div>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Weight</th>
				<th>Completed</th>
				<th>CreatedAt</th>
			</tr>
			<tr>
				<th>${task.id}</th>
				<th>${task.name}</th>
				<th>${task.weight}</th>
				<th>${task.completed}</th>
				<th>${task.createdAt}</th>
			</tr>
		</table>
	</div>
</body>
</html>