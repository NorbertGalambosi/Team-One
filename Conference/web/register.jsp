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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <title>Register</title>
        <link type="text/css" rel="stylesheet" href="mystyle.css">
        <script src="registerScript.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="show">
            <form action="" method="post">
                <p><label>Id:</label>
                    <input type="number" id="id" name="id"></p>
                <p><label>Name:</label>
                    <input type="text" id="name" name="name"></p>
                <p><label>Affiliation:</label>
                    <input type="text" name="affiliation" id="affiliation"></p>
                <p><label>Email:</label>
                    <input type="text" name="email" placeholder="example@domain.com" id="email"></p>
                <p><label>Webpage:</label>
                    <input type="text" name="webpage" id="webpage"></p>
                <p><label>Username:</label>
                    <input type="text" id="username" name="username"></p>
                <p><label>Password:</label>
                    <input type="text" id="password" name="password"></p>

                <p><select id="registerType">
                        <option value="Author">Author</option>
                        <option value="Listener">Listener</option>
                    </select></p>
                <p><input type="checkbox" name="pay" value="pay" id="check1">Pay for register</p>
                <p>
                    <input type="button" value="register" id="btnregister" name="btnregister">
                </p>
            </form>
            <form method="GET" action="login.jsp">
                <p><input type="button" name="Back" id="back" value="Back"></p>
            </form>
        </div>
    </body>
</html>
