<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Update Job</title>
</head>
<body>
	<div>
		<form action="updateJob">
			<label>### UPDATE JOB ###</label><br/><br/>
			<label>ID: </label>
			<input type="text" name="ID" value="${job.id}" disabled="disabled" /><br/><br/>
			<label>Name: </label>
			<input type="text" name="name" value="${job.name}" /><br/><br/>
			<label>Active:</label>
			<input type="radio" name="active" value="1" checked="checked">True</input>
			<input type="radio" name="active" value="0">False</input><br/><br/>
			<input type="submit" value="Update"/><br/><br/>
		</form>
		<br/><br/>
	</div>
</body>
</html>