<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/12/2022
  Time: 9:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Student Management</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        table {
            text-align: center;
        }
    </style>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a href="/students?action=create"
           class="btn btn-primary btn-lg">Add</a>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li><a href="students" class="btn btn-primary btn-lg" >Menu</a></li>
            </ul>
            <form class="d-flex" action="/students" method="post">
                <input class="form-control me-2" type="text" placeholder="Search" name="searchName">
                <input type="hidden" name="action" value="searchByName">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<center>
    <h1>Student Management</h1>
    <h2>List of Student</h2>
</center>
<div align="center">

    <table border="1" cellpadding="5" class="table">
        <tr style="background-color: #d2d0d0">
            <th>Name</th>
            <th>Date Of Birth</th>
            <th>Address</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Class Room</th>
            <th>Action</th>

        </tr>
        <c:forEach var="student" items="${requestScope['listStudents']}">
            <tr>
                <td><a href="/students?action=view&id=${student.getId()}" class="btn" >${student.getStudentName()}</a></td>
                <td><c:out value="${student.getDateOfBirth()}"/></td>
                <td><c:out value="${student.getAddress()}"/></td>
                <td><c:out value="${student.getEmail()}"/></td>
                <td><c:out value="${student.getPhoneNumber()}"/></td>
                <td><c:out value="${student.getClassRoom()}"/></td>
                <td><a href="/students?action=edit&id=${student.getId()}" class="btn btn-primary">Edit</a></td>


            </tr>
        </c:forEach>
    </table>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>