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
                <h3 class="text-center">Danh sách mặt hàng</h3>
                <hr>
                <div class="container text-right" >
                    <div>  <a href="product/addProduct.jsp" class="btn btn-success" >Thêm mới</a></div>
                </div>             
                <p class="text-danger">${results}</p>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Hình ảnh</th>
                            <th>Tên mặt hàng</th>
                            <th>Giá bán</th>
                            <th>Tồn kho</th>
                            <th>Hành động</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${listBook}">
                            <tr>
                                <td><c:out value="${book.id}" /></td>
                                <td data-label="Hình ảnh" style="text-align: center;">
                                    <img style="width: 50px;height: 50px; border-radius: 100%; 
                                         object-fit: cover;" src="${book.img}" alt=""></td>
                                <td><c:out value="${book.name}" /></td>
                                <td><c:out value="${book.price}" /></td>
                                <td><c:out value="${book.number}" /></td>
                                <td>
                                    <a href="LoadOrder?bid=<c:out value='${book.id}'/>&sid=<c:out value='${sid}'/>">Chọn</a></td>
                                </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
