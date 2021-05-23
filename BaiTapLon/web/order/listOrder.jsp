<%-- 
    Document   : index
    Created on : Apr 1, 2021, 3:59:34 PM
    Author     : ADMIN
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lí mặt hàng</title>
    </head>
    <body>

           <jsp:include page="/header.jsp"></jsp:include>

            <div class="row">

                <div class="container">
                <c:if test="${not empty mess}">
                    <div class="alert alert-primary" role="alert">
                        ${mess}
                    </div>
                </c:if>
                <h3 class="text-center">Danh sách đơn hàng</h3>
                <hr>
                <div class="container text-right" >
                    <div> <a href="/BaiTapLon/ListOrderSupplier" class="btn btn-success" >Thêm mới</a></div>
                </div>             
                <p class="text-danger">${results}</p>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tên mặt hàng</th>
                            <th>Nhà cung cấp</th>
                            <th>Tổng tiền</th>
                            <th>Hành động</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="o" items="${list}">
                            <tr>
                                <td><c:out value="${o.id}" /></td>
                                <td><c:out value="${o.book.name}" /></td>
                                <td><c:out value="${o.supplier.name}" /></td>
                                <td><c:out value="${o.total}" /></td>
                                <td>
                                    <a href="ViewOrder?oid=<c:out value='${o.id}'/>">Xem chi tiết</a>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
