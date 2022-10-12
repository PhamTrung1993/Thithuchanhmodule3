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
    <title>Librarian Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<center>
    <h1>Add New Student</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <h2>
        <a href="/students?action=students" class="btn btn-primary">Back to students list</a>
    </h2>
    <h2 style="color: blue">Add New Student</h2>
</center>

<div align="center">
    <form method="post">
        <table border="1" cellpadding="5" class="table">
            <tr>
                <th>Name:</th>
            </tr>
            <tr>
                <td>
                    <input type="text" name="name" id="name" size="150"/>
                </td>
            </tr>
            <tr>
            <th>Date Of Birth:</th>
            </tr>
            <tr><td>
                <input type="date" name="dateOfBirth" id="dateOfBirth" placeholder="yyyy-MM-dd" size="150"/>
            </td></tr>
        </tr>
            <tr>
                <th>Address:</th>
            </tr>
            <tr>
                <td>
                    <input type="text" name="address" id="address" size="150"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
            </tr>
            <tr>
                <td>
                    <input type="text" name="email" id="email" size="150"/>
                </td>
            </tr>
            <tr>
                <th>Phone Number:</th>
            </tr>
            <tr>
                <td>
                <input type="text" name="phoneNumber" id="phoneNumber" size="150"/>
                </td>
            </tr>

            <tr>
                <th>Class Room</th>
            </tr>
            <td>
                    <select name="classRoomID" id="classRoomID" >
                        <option value="" >Open this class Menu</option>
                        <option value="1">Class A</option>
                        <option value="2">Class B</option>
                        <option value="3">Class C</option>
<%--                        <c:forEach items="${requestScope['listClass']}" var="class">--%>
<%--                            <option value="${class.getId()}">${class.getClassName()}</option>--%>
<%--                        </c:forEach>--%>
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
</body>
</html>