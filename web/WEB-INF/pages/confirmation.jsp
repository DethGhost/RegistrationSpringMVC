<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Name: ${UserConfirm.name}
<br />
Login: ${UserConfirm.login}
<br />
Password: ${UserConfirm.password}
<br />
<form action="confirm" method="post">
    <button>Confirm</button>
</form>
</body>
</html>
