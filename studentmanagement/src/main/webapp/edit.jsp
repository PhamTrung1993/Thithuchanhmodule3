<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/12/2022
  Time: 8:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>Student Management</title>

</head>
<body>

<center>
    <h1>Edit Student</h1>
    <h2>
        <a href="/students?action=students" class="">Back List Student</a>
    </h2>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
</center>

<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">

            <c:if test="${student != null}">
                <input type="hidden" name="id" value="<c:out value='${student.id}' />"/>
            </c:if>
            <tr>
                <th>Name :</th>
                <td>
                    <input type="text" name="name" size="50"
                           value="${requestScope["student"].getStudentName()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Date Of Birth :</th>
                <td>
                    <input type="text" name="dateOfBirth" size="150"
                           value="${requestScope["student"].getDateOfBirth()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Address :</th>
                <td>
                    <input type="text" name="address" size="150"
                           value="${requestScope["student"].getAddress()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Email :</th>
                <td>
                    <input type="text" name="email" size="150"
                           value="${requestScope["student"].getEmail()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Phone Number :</th>
                <td>
                    <input type="text" name="phoneNumber" size="150"
                           value="${requestScope["student"].getPhoneNumber()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Class Room :</th>
                <td>
                    <select name="classRoomID" id="classRoomID">
                        <option value="">${requestScope["student"].getClassRoom()}</option>
                        <option value="1">Class A</option>
                        <option value="2">Class B</option>
                        <option value="3">Class C</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" class="my-1 btn btn-success btn-block"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>