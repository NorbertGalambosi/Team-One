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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="conferencePopulationScript.js" type="text/javascript"></script>
        <style>
            body{
                background-color: #ede3ff;
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

            .disable
            {
                pointer-events: none;
            }

            #leg{
                font-size: 20px;
                font-family: Courier;
                font-weight: bold;
            }

            #pp{
                font-size:17px;
            }

            p{
                text-align: center;
            }

        </style>
    </head>
    <body>

        <div>
            <form>
                <fieldset id="conf" class="disable">
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


        <div>
            <form>
                <fieldset id="pp">
                    <legend id="leg">Assigned Proposals</legend>
                    <label>Paper name </label><input type="text" name="pname">
                    <label>Review </label><input type="text" name="review">
                    <label>Recommendations </label><textarea rows="4" cols="50"></textarea>
                    <input type="submit" value="Add"/>
                </fieldset>
            </form>
        </div>


        <div>
            <form>
                <fieldset id="pp">
                    <legend id="leg">Papers</legend>
                    <label>Paper name </label><input type="text" name="pname">
                    <label>Review </label><input type="text" name="review">
                    <label>Recommendations </label><textarea rows="4" cols="50"></textarea>
                </fieldset>
            </form>
        </div>

        <form method="GET" action="login.jsp">
            <p><input type="submit" name="logout" id="logout" value="Logout"></p>
        </form>

    </body>
</html>
