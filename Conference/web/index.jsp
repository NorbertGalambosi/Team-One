<%--
  Created by IntelliJ IDEA.
  User: Waiting
  Date: 22-May-17
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login Conference</title>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
      <link type="text/css" rel="stylesheet" href="mystyle.css">
    <!-- <script src="myscript.js" type="text/javascript"></script>-->
  </head>
  <body>
    <div id="show">
        <form action="register.jsp" method="post">
            <p>
                <label>Username:</label>
                <input type="text" name="username" id="username">
            </p>
            <p>
                <label>Password:</label>
                <input type="password" name="password" id="password">
            </p>
            <p>
                <select>
                    <option value="author">Author</option>
                    <option value="reviewer">Reviewer</option>
                    <option value="chair">Chair</option>
                    <option value="listener">Listener</option>
                </select>
            </p>
            <p>
                <input type="submit" value="Login" id="btnsubmit">
                <input type="submit" value="Register" id="btnregister">
            </p>
        </form>
    </div>
  </body>
</html>
