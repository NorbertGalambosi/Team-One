/**
 * Created by Viman Adrian on 04.06.2017.
 */
$(document).ready(function () {

    fillMyProposals();
    var idReview = [];


    $( "#myProposals" ).change(function() {
        $.ajax({
            type : "POST",
            url : 'Reviewer_Servlet',
            data : {
                action : "proposalChange",
                proposal : $('#myProposals option:selected').val(),
                user : sessionStorage.getItem("user")
            },
            success : function(result){
                var res = result;
                values = res.split("|");
                $("#mineProposalName").val(values[0]);
                $("#mineProposalKeywords").val(values[1]);
                $("#mineProposalTopics").val(values[2]);
                $("#mineFullFileName").val(values[3]);
                $("#mineFullFN").val(values[4]);
                $("#mineAbstractFileName").val(values[5]);
                $("#mineAbstractFN").val(values[6]);
                $("#mineReviewStatus").val(values[7]);
                $("#mineProposalAuthors").val(values[8]);
            }
        });
        fillReviews();
        fillMyReview()
        /*
        $.ajax({
            type : "POST",
            url : 'Reviewer_Servlet',
            data : {
                action : "proposalChange2",
                proposal : $('#myProposals option:selected').val(),
                user : sessionStorage.getItem("user")
            },
            success : function(result){
                var res = result;
                //alert(res);
                values = res.split("|");
                $("#mineReviews").empty();
                $("#mineReviews").append($('<option>').append("(Default)"));
                for (var i = 0; i < values.length-1; i++) {
                    //alert(values[i]);
                    values2 = values[i].split("*");
                    $('#mineReviews').append($('<option>').append(values2[0]));
                    idReview[i+1] = values2[1];
                    //alert(idReview[i]);
                }
            }
        });
        */
    });


    $( "#mineReviews" ).change(function() {
        //alert(idReview[$("#mineReviews").prop('selectedIndex')]);
        $.ajax({
            type : "POST",
            url : 'Author_Servlet',
            data : {
                action : "reviewChange",
                review : idReview[$("#mineReviews").prop('selectedIndex')],
                user : sessionStorage.getItem("user")
            },
            success : function(result){
                var res = result;
                values = res.split("|");
                $("#otherReviewResult").val(values[0]);
                $("#otherReviewRecommendations").val(values[1]);
            }
        });
    });


    $("#mineSubmitReview").click(function () {
        $.ajax({
            type : "POST",
            url : 'Reviewer_Servlet',
            data : {
                action : "mineSubmitReview",
                proposal : $("#mineProposalName").val(),
                qualifier : $("#mineReviewQualifier").val(),
                recom : $("#mineReviewRecommendations").val(),
                user : sessionStorage.getItem("user")
            },
            success : function(result){
                var res = result;
                if(res=="succes")
                    alert("Review salvat cu succes");
                else
                    alert("Eroare");

            }
        });
        clearDetails();
        setTimeout(fillMyProposals, 1000);
    });

    function clearDetails(){
        $("#mineProposalName").val("");
        $("#mineProposalKeywords").val("");
        $("#mineProposalTopics").val("");
        $("#mineFullFileName").val("");
        $("#mineFullFN").val("");
        $("#mineAbstractFileName").val("");
        $("#mineAbstractFN").val("");
        $("#mineReviewStatus").val("");
        $("#mineProposalAuthors").val("");
        $("#mineReviewQualifier").val("");
        $("#mineReviewRecommendations").val("");
    }

    function fillMyProposals() {
        //alert("fill");
        $.ajax({
            type: "POST",
            url: 'Reviewer_Servlet',
            data: {
                action: "myProposals",
                user : sessionStorage.getItem("user")
            },
            success: function (result) {
                //alert("succes");
                var res = result;
                values = res.split("|");
                $("#myProposals").empty();
                $("#myProposals").append($('<option>').append("(Default)"));
                for (var i = 0; i < values.length - 1; i++) {
                    $('#myProposals').append($('<option>').append(values[i]));
                }
            }
        });
    }

    function fillReviews(){
        $.ajax({
            type : "POST",
            url : 'Reviewer_Servlet',
            data : {
                action : "proposalChange2",
                proposal : $('#myProposals option:selected').val(),
                user : sessionStorage.getItem("user")
            },
            success : function(result){
                var res = result;
                //alert(res);
                values = res.split("|");
                $("#mineReviews").empty();
                $("#mineReviews").append($('<option>').append("(Default)"));
                for (var i = 0; i < values.length-1; i++) {
                    //alert(values[i]);
                    values2 = values[i].split("*");
                    $('#mineReviews').append($('<option>').append(values2[0]));
                    idReview[i+1] = values2[1];
                    //alert(idReview[i]);
                }
            }
        });
    }

    function fillMyReview(){
        $.ajax({
            type : "POST",
            url : 'Reviewer_Servlet',
            data : {
                action : "fillMyReview",
                proposal : $('#myProposals option:selected').val(),
                user : sessionStorage.getItem("user")
            },
            success : function(result){
                var res = result;
                //alert(res);
                values = res.split("|");
                $("#mineReviewQualifier").val(values[0]);
                $("#mineReviewRecommendations").val(values[1]);

            }
        });
    }

    $('#mineAbstractDownload').click(function () {
        alert("Download successful");
    });

    $('#mineFullDownload').click(function () {
        alert("Download successful");
    });

});
