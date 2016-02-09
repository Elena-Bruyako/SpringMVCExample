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
    <tr id="good-${goods.goodId}">
        <td class="goodId">${goods.goodId}</td>
        <td class="name">${goods.name}</td>
        <td class="price">${goods.price}</td>
        <td>
            <button type="button" class="btn btn-primary js-edit" >Edit</button>
            <button type="button" class="btn btn-primary js-delete" >Delete</button>
        </td>
    </tr>
</c:forEach>