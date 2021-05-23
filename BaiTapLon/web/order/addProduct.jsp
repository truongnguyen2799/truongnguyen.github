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
        <title>Thêm mới</title>
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
                    <form action="/BaiTapLon/AddOrderProduct" method="post">
                        <caption>
                            <h2>Thêm mới</h2>
                        </caption>
                        <fieldset class="form-group">
                            <label>Hình ảnh</label> 
                            <input type="text" class="form-control" name="img" >
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Tên sản phẩm</label> 
                            <input type="text" class="form-control" name="name" >
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Giá bán</label> 
                            <input type="text" class="form-control" name="price" >
                        </fieldset> 
                        <fieldset class="form-group">
                            <label>Tồn kho</label> 
                            <input type="text" class="form-control" name="number" >
                        </fieldset>
                        <button type="submit" class="btn btn-success">Lưu</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
