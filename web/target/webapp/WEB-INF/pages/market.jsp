<%--
  Created by IntelliJ IDEA.
  User: brunyatko
  Date: 04.02.16
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Market</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/resources/core/my-style.css">
    <link rel='stylesheet' type="text/css" href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <jsp:useBean id="allGoods" scope="request" type="java.util.List"/>
</head>
<body>

<div class="header"></div>
<div class="tableContainer">
    <div class="tableRow"></div>`
        <div class="main">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Edit/Delete</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${allGoods}" var="goods">
                    <tr>
                        <td>${goods.name}</td>
                        <td>${goods.price}</td>
                        <td>
                            <button class="btn btn-default" data-toggle="modal" data-target="#requestModal">Edit</button>
                            <a href="delete/${goods.good_id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="modal fade" id="requestModal" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="myModalLabel">Please, fill all fields</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form">
                                <div class="form-group">
                                    <label for="editName">Name</label>
                                    <input type="text" class="form-control" id="editName"
                                           placeholder="Name">
                                </div>
                                <div class="form-group">
                                    <label for="editPrice">Price</label>
                                    <input type="number" class="form-control" id="editPrice"
                                           placeholder="Price">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="update">Edit</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="sidebar">
            <h3>Form adding a new goods</h3>
            <form action="/addNewGoods" method="post">
                <label for="newName">Name goods:</label>
                <input type="text" class="form-control" id="newName" placeholder="Name">
                <br>
                <label for="newPrice">Price:</label><br>
                <input type="number" class="form-control" id="newPrice" placeholder="Price">
                <br>
                <button type="button" class="btn btn-primary" id="addNewGoods">Add</button>
            </form>
        </div>
    </div>
</div>
<div class="footer"></div>

</body>

    <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/core/my-script.js"></script>
</html>
