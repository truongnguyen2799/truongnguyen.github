<%-- 
    Document   : header
    Created on : May 7, 2021, 1:46:38 PM
    Author     : ADMIN
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <style>
            #header{
                background: black;
            }
            .navbar-dark .navbar-nav .nav-link {
                color: white;
            }
            .search{
                margin-top: 5px;
            }
            .button{
                background: green;
            }
        </style>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-md navbar-dark"
                 id="header">
                <div>
                    <a href="admin.jsp" class="navbar-brand">Home</a>
                </div>

                <ul class="navbar-nav" id="header">
                    <li><a href="<c:url value="/ListProduct"/>" class="nav-link">Mặt hàng  </a></li>             
                    <li><a href="<c:url value="/ListSupplier"/>"  class="nav-link">Nhà cung cấp  </a></li>
                    <li><a href="<c:url value="/ListOrder"/>"  class="nav-link">Đơn nhập hàng</a></li>
                    <li style="margin-left: 150px"><form action="SearchProduct" method="post">
                            <div class="search">
                                <input type="text" name="search"  placeholder="Tìm kiếm">
                                <button type="submit" class="button">Tìm kiếm</button>
                                <select name="book" id="book">
                                    <option value="name">Theo tên</option>
                                    <option value="price">Theo giá</option>
                                    <option value="number">Theo số lượng</option>
                                </select>
                            </div>
                        </form></li>
                    <li style="margin-left: 230px"><a href="<c:url value="/ListOrder"/>"  class="nav-link">Chao ${acc.username}</a></li>
                </ul>
            </nav>
        </header> 
        <br>
    </body>
</html>
