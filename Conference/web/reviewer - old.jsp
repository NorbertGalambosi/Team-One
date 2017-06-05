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
        <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="conferencePopulationScript.js" type="text/javascript"></script>
        <script src="addReview.js" type="text/javascript"></script>
        <script src="findIdByUser.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $("#tablediv").hide();
                $("#showTable").click(function(event){
                    $.get('PopulateTable',function(responseJson) {
                        if(responseJson!=null){
                            //$("#reviewtable").find("tr:gt(0)").remove();
                            var table1 = $("#reviewtable");
                            $.each(responseJson, function(key,value) {
                                var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td>");
                                rowNew.children().eq(0).text(value['idReview']);
                                rowNew.children().eq(1).text(value['idPaper']);
                                rowNew.children().eq(2).text(value['idReviewer']);
                                rowNew.children().eq(3).text(value['recomandation']);
                                rowNew.children().eq(4).text(value['qualifier']);
                                rowNew.appendTo(table1);
                            });
                        }
                    });
                    $("#tablediv").show();
                });
            });
        </script>

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


            p{
                font-size: 15px;
            }

            .disable
            {
                pointer-events: none;
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
            <form action="" method="post" >
                <p>
                    <input type="button" value="Check your ID" id="check" >
                </p>
                <p><label>Username:</label>
                    <input type="text" id="username" name="username"></p>
            </form>
        </div>


        <h3>Press the button to visualize reviews</h3>
        <input type="button" value="Show me!" id="showTable"/>
        <div id="tablediv">
            <table cellspacing="10" id="reviewtable">
                <tr>
                    <th scope="col"></th>
                    <th scope="col">idPaper</th>
                    <th scope="col">idReviewer</th>
                    <th scope="col">recomandation</th>
                    <th scope="col">qualifier</th>
                </tr>
            </table>
        </div>




        <div>
            <form method="post">
                <h3>Give your review to the desired paper</h3>
                <label>id Paper </label><input type="text" name="pname" id="idP">
                <label>Your ID!(CHECK BUTTON ON TOP) </label><input type="text" name="pname" id="idR">
                <label>Recomandation </label><input type="text" name="review"  id="recomandation">
                <label>Qualifier </label><input type="text" name="qualfi"  id="qualifier">
                <p>
                    <input type="button" value="Submit review" id="review" >
                </p>
            </form>
        </div>


    </body>
</html>
