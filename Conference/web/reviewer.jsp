<%--
  Created by IntelliJ IDEA.
  User: Florina
  Date: 26.05.2017
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Reviewer</title>
    </head>
    <body>

        <div>
            <form>
                <fieldset>
                    <legend>Conference</legend>
                    <label>Conference name </label><input type="text" name="conferencename">
                    <label>Edition </label><input type="text" name="edition">
                    <label>Sessions </label><input type="text" name="sessions">
                    <label>Interval </label><input type="text" name="interval">
                    <label>Call for papers </label><input type="text" name="call"><br>
                    <label>Bidding deadline </label><input type="text" name="bdeadline">
                    <label>Proposals deadline</label><input type="text" name="pdeadline">
                    <label>Abstract deadline</label><input type="text" name="adeadline">
                    <label>Full deadline</label><input type="text" name="fdeadline">
                    <label>Reviews deadline</label><input type="text" name="rdeadline">
                    <label>Participants number </label><input type="text" name="nrp">
                    <label>Active </label><input type="checkbox" name="active" value="active">
                </fieldset>
            </form>
        </div>

        <div>
            <form>
                <h3>Papers</h3>
                <label>Paper name </label><input type="text" name="pname">
                <label>Review </label><input type="text" name="review">
                <label>Recommendations </label><textarea rows="4" cols="50"></textarea>
            </form>
        </div>

    </body>
</html>
