<%--
  Created by IntelliJ IDEA.
  User: Viman Adrian
  Date: 04.06.2017
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reviewer</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="conferencePopulationScript.js" type="text/javascript"></script>
    <script src="reviewerScript.js" type="text/javascript"></script>
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

    #meta{
        font-size: 20px;
        font-family: Courier;
        font-weight: bold;
    }

    p{
        font-size: 15px;
    }

    .disable
    {
        pointer-events: none;
    }

    #prop{
        font-family: Georgia;
        font-size: 18px;
    }

    table,td{
        border: solid 1px;
    }

    #log{
        text-align: center;
    }</style>
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
        <td>
            <p>
                <p>
                    <table id="proposalTable">
                        <thead>
                            <td id="prop">Asigned Proposals</td>
                            <td id="rev">My review</td>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="mine"><select id="myProposals"><option>(Default)</option></select></td>
                            </tr>
                            <tr>
                                <td class="mine">
                                    <p><label>Status </label><input type="text" id="mineReviewStatus" class="disable"></p>
                                    <p><label>Authors </label><input type="text" id="mineProposalAuthors" class="disable"></p>
                                    <p><label>Name </label><input type="text" id="mineProposalName" class="disable"></p>
                                    <p><label>Keywords </label><input type="text" id="mineProposalKeywords" class="disable"></p>
                                    <p><label>Topics </label><input type="text" id="mineProposalTopics" class="disable"></p>

                                    <p><label>Full paper name </label><input type="text" id="mineFullFileName" class="disable"></p>
                                    <p><label>Full paper (file name) </label><input type="text" id="mineFullFN" class="disable"></p>

                                    <p><input type="button" value="Download" id="mineFullDownload"></p>

                                    <p><label>Abstract paper name </label><input type="text" id="mineAbstractFileName" class="disable"></p>
                                    <p><label>Abstract paper (file name) </label><input type="text" id="mineAbstractFN" class="disable"></p>

                                    <p><input type="button" value="Download" id="mineAbstractDownload"></p>

                                    <p>Reviews
                                        <select id="mineReviews"><option>Default</option></select></p>
                                    <p><label>Review result </label><input type="text" id="otherReviewResult" class="disable"></p>
                                    <p><label>Recommendations </label><textarea rows="4" cols="50" id="otherReviewRecommendations"></textarea></p>
                                </td>
                                <td class="mineReview">
                                    <p><label>Qualifier </label><input type="text" id="mineReviewQualifier"></p>
                                    <p><label>Recommendations </label><textarea rows="4" cols="50" id="mineReviewRecommendations"></textarea></p>
                                    <p><input type="button" value="Submit review" id="mineSubmitReview"></p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </p>
            </fieldset>
        </form>
    </div>

    <form method="GET" action="login.jsp" id="log">
        <p><input type="submit" name="logout" id="logout" value="Logout"></p>
    </form>
</body>
</html>
