<%--
  Created by IntelliJ IDEA.
  User: Florina
  Date: 23.05.2017
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link type="text/css" rel="stylesheet" href="mystyle.css">
</head>
<body>
    <div id="show">
        <form action="" method="post">
            <p>
                <label>Name:</label>
                <input type="text" id="#name" name="name">
            </p>
            <p>
                <label>Affiliation:</label>
                <input type="text" name="affiliation">
            </p>
            <p>
                <label>Email:</label>
                <input type="email" name="email" placeholder="example@domain.com">
            </p>
            <p>
                <select>
                    <option value="author">Author</option>
                    <option value="listener">Listener</option>
                </select>
            </p>
            <p>
                <input type="button" name="save" value="Save"></p>
            </p>
        </form>
    </div>
</body>
</html>
