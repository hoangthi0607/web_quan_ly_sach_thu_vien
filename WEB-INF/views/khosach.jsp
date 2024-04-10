<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #04AA6D;
  color: white;
}
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
}
h2{
width:100%;
}
</style>
<meta charset="UTF-8">
<title>Kho sách</title>
</head>
<body>
<div class="topnav">
<a href="index.htm">Quay về trang chủ</a>
</div>
<form action="khosach.htm">
<input name="searchInput" placeholder="Search">
<button name="btnsearch" type="submit">Search</button>
</form>
<div><a href="insertsach.htm">Chèn thêm sách</a></div>
<h2>DANH SÁCH SÁCH TRONG THƯ VIỆN</h2>
${message}
<table class="table table-hover" border=1>
<tr>
<th>MASACH</th>
<th>TENSACH</th>
<th>SOTRANG</th>
<th>NGONNGU</th>
<th>SOLUONGTON</th>
<th>MANXB</th>
<th>MATL</th>
<th></th>
</tr>
<c:forEach var="s" items="${sachs}">
<tr>
<td>${s.MASACH}</td>
<td>${s.TENSACH}</td>
<td>${s.SOTRANG}</td>
<td>${s.NGONNGU}</td>
<td>${s.SOLUONGTON}</td>
<td>${s.NHA_XB.MANXB}</td>
<td>${s.THELOAI.MATL}</td>
<td><a href="khosach/${s.MASACH}.htm?linkEdit">Edit</a>
<a href="khosach/${s.MASACH}.htm?linkDelete">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>