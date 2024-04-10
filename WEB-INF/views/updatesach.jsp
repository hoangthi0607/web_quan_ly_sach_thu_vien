<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<style>
.topnav {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
  width:100%;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="topnav">
<a href="khosach.htm">Quay về</a>
</div>
${message}
<form:form action="updatesach.htm" modelAttribute="sach" >
<div>
<label>MASACH</label>
<form:input path="MASACH"/>
</div>
<div>
<label>TENSACH</label>
<form:input path="TENSACH"/>
</div>
<div>
<label>SOTRANG</label>
<form:input path="SOTRANG"/>
</div>
<div>
<label>NGONNGU</label>
<form:input path="NGONNGU"/>
</div>
<div>
<label>SOLUONGTON</label>
<form:input path="SOLUONGTON"/>
</div>
<div>
<label>NHAXUATBAN</label>
<form:input path="NHA_XB.MANXB"/>
</div>
<div>
<label>THELOAI</label>
<form:input path="THELOAI.MATL"/>
</div>
<div>
<button class="btn btn-default">Update</button>
</div>
</form:form>
</body>
</html>