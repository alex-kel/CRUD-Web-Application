<html>
<head>
    <%@include file="/WEB-INF/parts/resource_links.jsp" %>
    <link rel="stylesheet" href="resources/css/index.css">
</head>
<body>
<div class="login-form">
    <h2>Sign in</h2>

    <form action="login" method="post">
        <div class="form-group">
            <label for="login">Login</label>
            <input class="form-control" id="login" type="text" name="login"/><br>
            <label for="password">Password</label>
            <input class="form-control" id="password" type="password" name="password"/><br>
            <input class="btn btn-default" type="submit" value="Login">
        </div>
    </form>
</div>
</body>
</html>