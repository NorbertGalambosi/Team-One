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
        <script src="authorsScipt.js" type="text/javascript"></script>
    </head>

    <style>

        body{
            background-color: #F5F5F5;
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
        }

        #logout{
            color: #fff;
            background: #337ab7;
            padding: 5px;
        }
    </style>
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

    <form action="">
        <fieldset>
            <legend id="meta">Meta-information</legend>
            <p><label>Name of the proposal: </label>
                <input type="text" id="nameP"></p>
            <p><label>Keywords: </label>
                <input type="text" id="keywords"></p>
            <p><label>Topics: </label>
                <input type="text" id="topics"></p>
            <p><label>FullPaperName: </label>
                <input type="text" id="fullPaperName"></p>
            <p><label>AbstractPaperName: </label>
                <input type="text" id="abstractPaperName"></p>
            *paper names should be different
            <p><input type="button" id="submitPaper" value="submitPaper"></p>
            <form method="post" action="UploadServlet"
                  enctype="multipart/form-data">
                Select file to upload the Full Paper: <input type="file" name="file" size="60" id="fileUp"/><br/>
                <br /> <input type="button" value="Upload" name="Upload" id="uploadBtnFull" />
            </form>
            <form method="post" action="UploadServlet"
                  enctype="multipart/form-data"><br>
                Select file to upload the Abstract Paper: <input type="file" name="file" size="60" id="fileUpl"/><br/>
                <br /> <input type="button" value="Upload" name="Upload" id="uploadBtnAbs" />
            </form>
        </fieldset>
    </form>

    <div>
        <form>
            <fieldset>
                <legend id="meta">Proposals</legend>
                <p>
                    <table id="proposalTable">
                        <thead>
                        <td id="prop">My Proposals</td>
                        <td id="prop">Other Proposals</td>
                        </thead>
                        <tbody>
                        <tr>
                            <td class="mine"><select id="myProposals"><option>(Default)</option></select></td>
                            <td class="theirs"><select id="enemyProposals"><option>(Default)</option></select></td>
                        </tr>
                        <tr>
                            <td class="mine">
                <p><label>Status </label><input type="text" id="mineReviewStatus" class="disable"></p>
                <p><label>Name </label><input type="text" id="mineProposalName" class="disable"></p>
                <p><label>Keywords </label><input type="text" id="mineProposalKeywords"></p>
                <p><label>Topics </label><input type="text" id="mineProposalTopics"></p>
                <p><input type="button" value="Edit" id="mineEditProposal"></p>

                <p><label>Full paper (file name) </label><input type="text" id="mineFullFN" class="disable"></p>
                <p><label>Full paper name </label><input type="text" id="mineFullFileName" class="disable"></p>
                <p><label>New full paper </label><input type="file" id="mineProposalNewFile"></p>
                <p><input type="button" value="Upload" id="mineProposalEdit"></p>

                <p><label>Abstract paper (file name) </label><input type="text" id="mineAbstractFN" class="disable"></p>
                <p><label>Abstract paper name </label><input type="text" id="mineAbstractFileName" class="disable"></p>
                <p><label>New abstract paper </label><input type="file" id="abstractNewFile"></p>
                <p><input type="button" value="Upload" id="abstractEdit"></p>

                <p>Reviews
                    <select id="mineReviews"><option>Default</option></select></p>
                <p><label>Review result </label><input type="text" id="mineReviewResult" class="disable"></p>
                <p><label>Recommendations </label><textarea rows="4" cols="50" id="mineReviewRecommendations" class="disable"></textarea></p>
                </td>

                <td class="theirs">
                    <p><label>Name </label><input type="text" id="theirsProposalName" class="disable"></p>
                    <p><label>Keywords </label><input type="text" id="theirsProposalKeywords" class="disable"></p>
                    <p><label>Topics </label><input type="text" id="theirsProposalTopics" class="disable"></p>
                    <p><label>Authors </label><input type="text" id="theirsProposalAuthors" class="disable"></p>
                    <p><input type="button" value="Bid" id="theirsProposalBid"></p>
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
