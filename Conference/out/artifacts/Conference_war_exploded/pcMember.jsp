<%--
  Created by IntelliJ IDEA.
  User: Florina
  Date: 23.05.2017
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PC Member</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="conferencePopulationScript.js" type="text/javascript"></script>
</head>

<style>

    h1{
        text-align: center;
        color: #63775B  ;
    }

    #conf{
        background-color: #F0FFFF;
        font-size: 17px;
        font-family: Arial;

    }

    #legend{
        font-size: 24px;
        font-family: Courier;
        text-align: center;
    }

    #meta{
        font-size: 20px;
        font-family: Courier;

    }

    p{
        font-size: 15px;
    }
</style>
<body>

<div>
    <form>
        <fieldset id="conf">
            <legend id="legend">Conference</legend>
            <label>Conference name </label><input type="text" id="conferencename">
            <label>Edition </label><input type="text" id="edition">
            <label>Sessions </label><input type="text" id="sessions">
            <label>Interval </label><input type="text" id="interval">
            <label>Call for papers </label><input type="text" id="call"><br>
            <label>Bidding deadline </label><input type="text" id="bdeadline">
            <label>Proposals deadline</label><input type="text" id="pdeadline">
            <label>Abstract deadline</label><input type="text" id="adeadline">
            <label>Full deadline</label><input type="text" id="fdeadline"><br>
            <label>Reviews deadline</label><input type="text" id="rdeadline">
            <label>Participants number </label><input type="text" id="nrp">
            <label>Active </label><input type="checkbox" id="active" value="active">
        </fieldset>
    </form>
</div>

<p><input type="button" name="bid" value="Bid"></p>
<form method="GET" action="login.jsp">
    <p><input type="button" name="logout" id="logout" value="Logout"></p>
</form>

</body>
</html>
