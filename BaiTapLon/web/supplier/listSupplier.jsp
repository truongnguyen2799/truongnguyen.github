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
        <title>Danh  sách nhà cung cấp</title>
    </head>
    <body>

         <jsp:include page="/header.jsp"></jsp:include>
            <div class="row">

                <div class="container">
                <c:if test="${not empty mess}">
                    <p style="color: red">${mess}</p>
                </c:if>
                <h3 class="text-center">Danh sách nhà cung cấp</h3>
                <hr>
                <div class="container text-right" >
                    <div>  <a href="supplier/addSupplier.jsp" class="btn btn-success" >Thêm mới</a></div>
                </div>             
                <p class="text-danger">${results}</p>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tên nhà cung cấp</th>
                            <th>Địa chỉ</th>
                            <th>Số địa thoại</th>
                            <th>Hành động</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="supplier" items="${listSupplier}">
                            <tr>
                                <td><c:out value="${supplier.id}" /></td>
                                <td><c:out value="${supplier.name}" /></td>
                                <td><c:out value="${supplier.address}" /></td>
                                <td><c:out value="${supplier.phone}" /></td>
                                <td>
                                    <a href="#">Sửa</a>
                                    <a href="#" onclick="return confirm('Bạn muốn xóa?');">Xóa</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
