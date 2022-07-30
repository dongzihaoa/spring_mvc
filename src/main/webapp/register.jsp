<%--
  Created by IntelliJ IDEA.
  User: Hello Baby
  Date: 2022/7/29
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>

    <!-- bootstrap.bundle.min.js 用于弹窗、提示、下拉菜单，包含了 popper.min.js -->
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>

    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <title></title>

</head>
<body>
<div class="container mt-3">
    <h2>注册</h2>
    <form action="user/register" method="post">
        <div class="mb-3 mt-3">
            <label for="name" class="form-label">用户名:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">密码:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        </div>
        <div class="mb-3 mt-3">
            <label for="text01" class="form-label">List:</label>
            <input type="text" class="form-control" id="text01" placeholder="Enter List" name="list[1].cName">
        </div>
        <div class="mb-3 mt-3">
            <label for="text02" class="form-label">Map:</label>
            <input type="text" class="form-control" id="text02" placeholder="Enter Map" name="map['myCar'].cName">
        </div>

        <div class="mb-3 mt-3">
            <label for="date" class="form-label">Map:</label>
            <input type="datetime-local" class="form-control" id="date" placeholder="Enter Map" name="birthDay">
        </div>
        <div class="form-check mb-3">
            <label class="form-check-label">
                <input class="form-check-input" type="checkbox" name="remember"> Remember me
            </label>
        </div>
        <button type="submit" class="btn btn-primary" id="">注册</button>
    </form>
</div>

</body>
</html>
