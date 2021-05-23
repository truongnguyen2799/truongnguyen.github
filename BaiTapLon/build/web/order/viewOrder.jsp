<%-- 
    Document   : edit
    Created on : Apr 1, 2021, 11:56:01 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sủa sản phẩm</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="/header.jsp"></jsp:include>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <form action="ListOrder" method="post">
                            <caption>
                                <h2>Xem chi tiết</h2>
                            </caption>
                            <fieldset class="form-group">
                                <label>Id</label> 
                                <input type="text" class="form-control" name="id" value="${o.id}" readonly="true">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Tên mặt hàng</label> 
                            <input type="text" class="form-control" name="nameBook" value="${o.book.name}" readonly="true">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Nhà cung cấp</label> 
                            <input type="text" class="form-control" name="nameSupplier" value="${o.supplier.name}" readonly="true">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Giá bán</label> 
                            <input type="text" class="form-control" name="price"  value="${o.price}" readonly="true">
                        </fieldset> 
                         <fieldset class="form-group">
                            <label>Số lượng</label> 
                            <input type="text" class="form-control" name="price"  value="${o.number}" readonly="true">
                        </fieldset> 
                         <fieldset class="form-group">
                            <label>Tổng tiền</label> 
                            <input type="text" class="form-control" name="price"  value="${o.total}" readonly="true" >
                        </fieldset> 
                        <button type="submit" class="btn btn-success">Thoát</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
