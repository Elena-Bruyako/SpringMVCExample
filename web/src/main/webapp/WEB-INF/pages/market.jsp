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

<div class="tableContainer">
    <div class="tableRow">
        <div class="filter">
            <h3>Choose Price or Name:</h3>
            <form>
                <label for="priceFrom">Price from:</label>
                <input type="number" class="form-control" id="priceFrom" placeholder="Price from">
                <br>
                <label for="priceTo">Price to:</label>
                <input type="number" class="form-control" id="priceTo" placeholder="Price to">
                <br>
                <label for="selectName">Name:</label>
                <input type="text" class="form-control" id="selectName" placeholder="Name">
                <br>
                <button type="button" class="btn btn-primary" id="getByFilter">Select</button>
                <button type="button" class="btn btn-primary" id="resetFilter">Reset</button>
            </form>
        </div>
        <div class="main">
            <table id="main-table" class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Edit/Delete</th>
                    </tr>
                </thead>
                <tbody id="tableBody">
                    <jsp:include page="goodsList.jsp"/>
                </tbody>
            </table>
        </div>
        <div class="sidebar">
            <h3>Form adding a new goods</h3>
            <form id="editForm">
                <label for="newName">Name goods:</label>
                <input type="text" class="form-control" id="newName" placeholder="Name">
                <br>
                <label for="newPrice">Price:</label>
                <input type="number" class="form-control" id="newPrice" placeholder="Price">
                <input type="hidden" class="form-control" id="newGoodId" placeholder="Price">
                <br>
                <button type="button" class="btn btn-primary" id="add">Add</button>
                <button type="button" class="btn btn-primary" id="update" style="display: none">Edit</button>
                <button type="button" class="btn btn-primary" id="cancel" style="display: none">Cancel</button>
            </form>
        </div>
    </div>
</div>

</body>

    <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/core/my-script.js"></script>
</html>
