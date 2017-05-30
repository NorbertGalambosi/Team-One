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
    </head>
    <script>
        function alert() {
            alert("File uploaded.")
        }
    </script>
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

                <form action="" method="post" enctype="multipart/form-data">
                    Select file to upload:
                    <input type="file" name="uploadA" id="uploadA">
                    <input type="file" name="uploadF" id="uploadF">
                    <input type="submit" value="Upload Files" name="submit" onclick="alert">
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
