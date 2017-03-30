<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Category</title>
</head>
<body>
	<p>manage product category</p>
	<hr>
	
	<%-- ${categoryList}  to display the all the object for the testing purpose--%>
	
	<from action="manage_category_create" method="post">
	
	<input type="text" name="id">
	<input type="text" name="name">
	<input type="text" name="description">
	<input type="submit" name="create">
	</from>
	
	<table>
	<thead>
	
	
	  <tr>
	  <td>Id</td>
	  <td>name</td>
	  <td>description</td>
	  </tr>
	  <c:forEach var="category" items="${categoryList}">
	  <tr>
	  <td> ${category.id } &nbsp; &nbsp;</td>
	  <td> ${category.name }&nbsp; &nbsp;</td>
	  <td>${cayegory.description}&nbsp; &nbsp;</td>
	    
	  <td>  <a href="manage_category_edit">Edit</a>|<a href="manage_category_delete">Delete</a></td>
	      
	</tr>
	</c:forEach>
	</thead>
	</table>
</body>
</html>
