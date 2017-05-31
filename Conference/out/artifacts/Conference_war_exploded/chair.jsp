<%--
  Created by IntelliJ IDEA.
  User: Florina
  Date: 23.05.2017
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Chair</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<<<<<<< HEAD
        <script src="chairScript.js" type="text/javascript"></script>
=======
        <script src="conferencePopulationScript.js" type="text/javascript"></script>
>>>>>>> 2f8f5a899243433c774d556cfed83cab700d3830
    </head>
    <body>

        <div>
            <form>
                <fieldset>
                    <legend>Conference</legend>
<<<<<<< HEAD
                    <label>Conference name </label><input type="text" name="conferencename" id="confname">
                    <label>Edition </label><input type="text" name="edition" id="edition">
                    <label>Sessions </label><input type="text" name="sessions" id="sesions">
                    <label>Interval </label><input type="text" name="interval" id="interval">
                    <label>Call for papers </label><input type="text" name="call" id="call"><br>
                    <label>Bidding deadline </label><input type="text" name="bdeadline" id="bidline">
                    <label>Proposals deadline</label><input type="text" name="pdeadline" id="propline">
                    <label>Abstract deadline</label><input type="text" name="adeadline" id="absline">
                    <label>Full deadline</label><input type="text" name="fdeadline" id="fullline">
                    <label>Reviews deadline</label><input type="text" name="rdeadline" id="revline">
                    <label>Participants number </label><input type="text" name="nrp" id="parno">
                    <label>Active </label><input type="checkbox" name="active" value="active" id="active">
=======
                    <label>Conference name </label><input type="text" id="conferencename">
                    <label>Edition </label><input type="text" id="edition">
                    <label>Sessions </label><input type="text" id="sessions">
                    <label>Interval </label><input type="text" id="interval">
                    <label>Call for papers </label><input type="text" id="call"><br>
                    <label>Bidding deadline </label><input type="text" id="bdeadline">
                    <label>Proposals deadline</label><input type="text" id="pdeadline">
                    <label>Abstract deadline</label><input type="text" id="adeadline">
                    <label>Full deadline</label><input type="text" id="fdeadline">
                    <label>Reviews deadline</label><input type="text" id="rdeadline">
                    <label>Participants number </label><input type="text" id="nrp">
                    <label>Active </label><input type="checkbox" id="active" value="active">
>>>>>>> 2f8f5a899243433c774d556cfed83cab700d3830
                </fieldset>
                <input type="button" id="createConference" name="Create" value="Create">
            </form>
        </div>

        <div>
            <form>
                <h3>Papers</h3>
                <label>Authors </label><input type="text" name="authors">
                <label>Paper name </label><input type="text" name="pname">
                <label>Keywords </label><input type="text" name="keywords">
                <label>Topics </label><input type="text" name="topics">
            </form>
        </div>

        <div>
            <form>
                Select reviewers for papers. Please select 2, 3 or 4 reviewers for each paper.
                <p><label>Papers</label>
                    <select multiple>
                        <option></option>
                    </select></p>
                <p>
                    <label>Reviewers</label>
                    <select multiple>
                        <option></option>
                    </select>
                </p>
            </form>
        </div>

        <div>
            <form>
                Select session chair for session.
                <p><label>Session</label>
                    <select>
                        <option></option>
                    </select>
                </p>
                <p><label>Program Committee</label>
                    <select>
                        <option></option>
                    </select>
                </p>
            </form>
        </div>


    </body>
</html>
