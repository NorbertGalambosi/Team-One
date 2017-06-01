<%--
  Created by IntelliJ IDEA.
  User: Florina
  Date: 23.05.2017
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Author</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="conferencePopulationScript.js" type="text/javascript"></script>
    </head>
    <body>

        <div>
            <form>
                <fieldset>
                    <legend>Conference</legend>
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
                </fieldset>
            </form>
        </div>

        <form action="">
            <fieldset>
                <legend>Meta-information</legend>
                <p><label>Name of the proposal: </label>
                    <input type="text" name="nameP"></p>
                <p><label>Keywords: </label>
                    <input type="text" name="keywords"></p>
                <p><label>Topics: </label>
                    <input type="text" name="topics"></p>
                <p><label>*List of authors:</label>
                    <input type="text" name="listA"> *The list of authors is not mandatory.</p>
                Select file to upload:
                <form id="upload-form" class="upload-box" action="/AuthorUpload_Servlet" method="post" enctype="multipart/form-data" >
                    <input type="file" id="file" name="file"/>
                    <span id="upload-error" class="error">${uploadError}</span>
                    <input type="submit" id="upload-button" value="upload"/>
                </form>

            </fieldset>
        </form>

        <div>
            <form>
                <h1>My Papers</h1>
                    <p><label>Name </label><input type="text" name="nameP">
                        <label>Keywords </label><input type="text" name="keywords">
                        <label>Topics </label><input type="text" name="topics">
                        <label>Authors </label><input type="text" name="authors">
                        <label>Edit </label><input type="file" name="edit">
                        <input type="button" name="details" value="Details" onclick="getElementById('details').slideDown('slow')">
                    </p>
            </form>
        </div>

        <div>
            <form id="details">
                <label>Status </label><input type="text" name="status">
                <label>Review result </label><input type="text" name="reviewresult">
                <label>Recommendations </label><textarea rows="4" cols="50"></textarea>
            </form>
        </div>

        <p><input type="button" name="bid" value="Bid"></p>
        <form method="GET" action="login.jsp">
        <p><input type="button" name="logout" id="logout" value="Logout"></p>
        </form>

    </body>
</html>
