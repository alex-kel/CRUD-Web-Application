<%@ page import="com.fs.javalab.webapplication.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <%@include file="/WEB-INF/parts/resource_links.jsp" %>
    <link rel="stylesheet" href="resources/css/profile.css">
</head>
<body>
<div class="col-md-offset-4 col-md-4">
    <h2>Thanks for login</h2>
    User: ${user.getLogin()} was succesfully logged in.<br>
    Hello, ${user.getFirstName()} ${user.getLastName()}, here you can update your account:
    <hr>
    <form id="update">
        <div class="form-group">
            <label for="login">Login</label>
            <input class="form-control" id="login" type="text" name="login"
                   value="<%=((User) session.getAttribute("user")).getLogin()%>"><br>
            <label for="password">Password</label>
            <input class="form-control" id="password" type="password" name="password"
                   value="<%=((User) session.getAttribute("user")).getPassword()%>"><br>
            <label for="firstName">First Name</label>
            <input class="form-control" id="firstName" type="text" name="firstName"
                   value="<%=((User) session.getAttribute("user")).getFirstName()%>"><br>
            <label for="lastName">Last Name</label>
            <input class="form-control" id="lastName" type="text" name="lastName"
                   value="<%=((User) session.getAttribute("user")).getLastName()%>"><br>
            <input class="btn btn-default" type="submit" value="Update">
        </div>
    </form>
    <form id="delete">
        <input class="btn btn-danger" type="submit" value="Delete!">
    </form>

</div>
<div class="preloader">
    <img src="resources/images/preloader.gif">
</div>
</body>
</html>
