<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add Job</title>
</head>
<body>
	<div>
		<form action="addJob">
			<label>### NEW JOB ###</label><br/><br/>
			<label>Name: </label>
			<input type="text" name="name" /><br/>
			<label>Active:</label>
			<input type="radio" name="active" value="1" checked="checked">True</input>
			<input type="radio" name="active" value="0">False</input><br/>
			<input type="submit" value="Add"/><br/>
		</form>
		<br/><br/>
	</div>
	<div>
		<form action="updateJob">
			<label>### UPDATE JOB ###</label><br/><br/>
			<label>Id: </label>
			<input type="text" name="id"/><br/><br/>
			<input type="submit" value="Update"/>
		</form>
		<br/><br/>
	</div>
	<div>
		<form action="findJob">
			<label>### SEARCH JOB ###</label><br/><br/>
			<label>Id: </label>
			<input type="text" name="id"/><br/><br/>
			<input type="submit" value="Search"/>
		</form>
		<br/><br/>
	</div>
	<div>
		<form action="deleteJob">
			<label>### DELETE JOB ###</label><br/><br/>
			<label>Id: </label>
			<input type="text" name="id"/><br/><br/>
			<input type="submit" value="Delete"/><br/><br/>
		</form>
	</div>
	<div>
		<form action="list">
			<label>### LIST JOBS ###</label><br />
			<input type="submit" value="Loading..."/>
		</form>
	</div>
	<div>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Active</th>
			</tr>
			<tr>
				<th>${job.id}</th>
				<th>${job.name}</th>
				<th>${job.active}</th>
			</tr>
		</table>
	</div>
</body>
</html>