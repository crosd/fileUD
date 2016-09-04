<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath}/resources/css/jquery_dataTables.css">
<script src="${ pageContext.request.contextPath}/resources/js/jquery.js"></script>


<script src="${ pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</head>
<body>
<div class ="col-md-6 col-md-offset-4 panel panel-default" style="margin-top:10%;">
	<div class="panel-heading">
	<h2 >File Upload:</h2>
	</div  >
	<div class="panel-body">
	<form action="upload" method="post" enctype="multipart/form-data">
		file to upload:<input  name ="file" type="file"class="btn btn-default" /><br/>
		<input type="submit" value ="upload" class="btn btn-default"/>
	</form>
	
	<br><br>
	<label>${successMsg}</label>
	<br>
	
	<br>
	<c:if test="${fileName ne null }">
	<a href ="${pageContext.request.contextPath}/download?file=${fileName}"><span class="glyphicon glyphicon-download" aria-hidden="true"></span>DownLoad File</a>
	</c:if>
	</div>
	</div>
</body>
</html>