<%--
  Created by IntelliJ IDEA.
  User: brunyatko
  Date: 09.02.16
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${allGoods}" var="goods">
    <tr id="good-${goods.good_id}">
        <td class="good_id">${goods.good_id}</td>
        <td class="name">${goods.name}</td>
        <td class="price">${goods.price}</td>
        <td>
            <button class="btn btn-default edit" data-toggle="modal" data-target="#requestModal">Edit</button>
            <button type="button" class="btn btn-default" id="delete">Delete</button>
            <%--<a href="delete/${goods.good_id}">Delete</a>--%>
        </td>
    </tr>
</c:forEach>