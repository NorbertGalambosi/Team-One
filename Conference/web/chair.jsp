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
    <script src="chairScript.js" type="text/javascript"></script>
    <script src="conferencePopulationScript.js" type="text/javascript"></script>

    <style>

        body{
            background-color: #ede3ff;
        }

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
            font-style: italic;
            font-weight: bold;
        }

        p{
            font-size: 15px;
        }
        
        #log{
            text-align: center;
        }

        #sel{
            font-size:17px;
            font-family: "Comic Sans MS";

        }

    </style>

</head>
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
            <label>Full paper deadline</label><input type="text" id="fdeadline"><br>
            <label>Reviews deadline</label><input type="text" id="rdeadline">
            <label>Participants number </label><input type="text" id="nrp">
            <label>Active </label><input type="checkbox" id="active" value="active">
        </fieldset>
        <br>
        <p>To create a conference, click here:
            <input type="button" id="createConference" name="Create" value="Create"></p>
        <p>To update any details of the conference press the button :
            <input type="button" id="updateConference" name="Update" value="Update">
        </p>
    </form>
</div>

<div>
<fieldset>
    <form>
        <p id="sel">>>Select reviewers for proposals. Please select 2, 3 or 4 reviewers for each proposal.</p>
        <p><label>Proposals</label>
            <select id="paperList">
                <option></option>
            </select>

            <label>Reviewers</label>
            <select id="revsList">
                <option></option>
            </select>
            <input type="button" name="Assign Proposals to Reviewers" value="Assign Proposals to Reviewers" id="btnPr2Rev">
        </p>
    </form>

    <form>
        <p id="sel">>>Select session chair for session.</p>
        <p><label>Session</label>
            <select id="sessionOptions">

            </select>

            <label>Program Committee</label>
            <select id="pcOptions">

            </select>
        </p>
        <input type="button" id="addChairToSession" name="Assign Chair" value="Assign Chair">
    </form>

    <form>
        <p id="sel">>>Select session listeners for session.</p>
        <p><label>Session</label>
            <select id="sessionOptionsL"></select>
            <label>Program Committee</label>
            <select id="pcOptionsL"></select>
        </p>
        <input type="button" id="addListenersToSession" name="Assign Listeners" value="Assign Listeners">
    </form>

    <form>
        <p id="sel">>>Select session speakers for session.</p>
        <p><label>Session</label>
            <select id="sessionOptionsSp">

            </select>

            <label>Program Committee</label>
            <select id="pcOptionsSp">

            </select>
        </p>
        <input type="button" id="addSpeakersSession" name="Assign Speakers" value="Assign Speakers">
    </form>
</fieldset>
</div>

<form method="GET" action="login.jsp" id="log">
    <p><input type="submit" name="logout" id="logout" value="Logout"></p>
</form>


</body>
</html>