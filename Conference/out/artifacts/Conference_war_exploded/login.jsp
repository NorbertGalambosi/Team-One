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
      <script src="loginScript.js" type="text/javascript"></script>
      <style>
          #align{
              child-align: bottom;
          }
      </style>
  </head>
  <body>
    <div id="align">
        <form action="register.jsp" method="post" >
            <p>
                <label>Username:</label>
                <input type="text" name="username" id="username">
            </p>
            <p>
                <label>Password:</label>
                <input type="password" name="password" id="password">
            </p>
            <p>
                <select id="memberType">
                    <option value="Author">Author</option>
                    <option value="Reviewer">Reviewer</option>
                    <option value="Chair">Chair</option>
                    <option value="Listener">Listener</option>
                </select>
            </p>
            <p>
                <input type="button" value="Login" id="btnsubmit" name="btnsubmit">
            </p>
        </form>
        <form action="register.jsp" >
            <input type="submit" value="Register" id="btnregister">
        </form>
    </div>

  </body>
</html>
