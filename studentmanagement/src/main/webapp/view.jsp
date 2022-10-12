<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/12/2022
  Time: 8:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body,table {
            text-align: center;
        }
        img {
            width: 200px;
            height: 200px;
        }
        h1,h3 {
            color: red;

        }
    </style>
</head>
<body>
<h1>Student Information</h1>
<p>
    <a href="/students" class="btn btn-primary">Back to student list</a>
</p>
<div class="container">
    <form>
        <fieldset>
            <table class="table">
                <tr>
                    <td>name : </td>
                    <td>${requestScope["student"].getStudentName()}</td>
                </tr>
                <tr>
                    <td>Date Of Birth: </td>
                    <td>${requestScope["student"].getDateOfBirth()}</td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td>${requestScope["student"].getAddress()}</td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td>${requestScope["student"].getEmail()}</td>
                </tr>
                <tr>
                    <td>Phone Number: </td>
                    <td>${requestScope["student"].getPhoneNumber()}</td>
                </tr>
                <tr>
                    <td>Class Room: </td>
                    <td>${requestScope["student"].getClassRoom()}</td>
                </tr>

                <tr>
                    <td><a href="/students?action=edit&id=${requestScope["student"].getId()}" class="btn btn-info">Edit</a></td>
                    <td>
                        <!-- Trigger the modal with a button -->
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal">Delete</button>

                        <!-- Modal -->
                        <div class="modal fade" id="myModal" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title">ARE YOU SURE?</h4>
                                    </div>

                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        <a href="/students?action=delete&id=${requestScope["student"].getId()}" type="button" class="btn btn-default">Delete</a>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </td>
                </tr>

            </table>
        </fieldset>
    </form>

</div>

</body>
</html>
