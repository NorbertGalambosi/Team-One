/**
 * Created by Viman Adrian on 02.06.2017.
 */

$(document).ready(function () {

    fillMyProposals();
    fillEnemyProposals();
    var idReview = [];

    $('#submitPaper').click(function () {
        $.ajax({
            type : "POST",
            url : 'Author_Servlet',
            data : {
                action : "addProposal",
                name : $("#nameP").val(),
                keywords : $("#keywords").val(),
                topics : $("#topics").val(),
                autor : sessionStorage.getItem("user"),
                full : $("#fullPaperName").val(),
                abstract : $("#abstractPaperName").val()
            },
            success : function(result){
                var res = result;
                if(res=="succes")
                    alert("Adaugat cu succes");
                else
                    alert("Eroare");
            }
        });
        //location.reload(); //asta merge da ii urat ca nu apare alertu
        //fillMyProposals(); //asta din ceva motiv nu merge
        setTimeout(fillMyProposals, 1000);
    });

    $( "#myProposals" ).change(function() {
        $.ajax({
            type : "POST",
            url : 'Author_Servlet',
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
            }
        });
        $.ajax({
            type : "POST",
            url : 'Author_Servlet',
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
                $("#mineReviewResult").val(values[0]);
                $("#mineReviewRecommendations").val(values[1]);
            }
        });
    });
    
    $("#enemyProposals").change(function () {
        $.ajax({
            type : "POST",
            url : 'Author_Servlet',
            data : {
                action : "enemyProposalsChange",
                proposal : $('#enemyProposals option:selected').val(),
                user : sessionStorage.getItem("user")
            },
            success : function(result){
                var res = result;
                values = res.split("|");
                $("#theirsProposalName").val(values[0]);
                $("#theirsProposalKeywords").val(values[1]);
                $("#theirsProposalTopics").val(values[2]);
                $("#theirsProposalAuthors").val(values[3]);
            }
        });
    })

    $("#theirsProposalBid").click(function () {
        $.ajax({
            type : "POST",
            url : 'Author_Servlet',
            data : {
                action : "theirsProposalBid",
                proposal : $("#theirsProposalName").val(),
                user : sessionStorage.getItem("user")
            },
            success : function(result){
                var res = result;
                if(res=="succes")
                    alert("Bid cu succes");
                else
                    alert("Eroare");

            }
        });
    });

    $('#mineEditProposal').click(function () {
        $.ajax({
            type : "POST",
            url : 'Author_Servlet',
            data : {
                action : "editProposal",
                name : $("#mineProposalName").val(),
                keywords : $("#mineProposalKeywords").val(),
                topics : $("#mineProposalTopics").val(),
                autor : sessionStorage.getItem("user")
            },
            success : function(result){
                var res = result;
                if(res=="succes")
                    alert("Editat cu succes");
                else
                    alert("Eroare");
            }
        });
        //location.reload(); //asta merge da ii urat ca nu apare alertu
        //fillMyProposals(); //asta din ceva motiv nu merge
    });

    function fillMyProposals() {
        $.ajax({
            type: "POST",
            url: 'Author_Servlet',
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

    function fillEnemyProposals() {
        $.ajax({
            type: "POST",
            url: 'Author_Servlet',
            data: {
                action: "enemyProposals",
                user : sessionStorage.getItem("user")
            },
            success: function (result) {
                //alert("succes");
                var res = result;
                values = res.split("|");
                //$("#enemyProposals").empty();
                for (var i = 0; i < values.length - 1; i++) {
                    $('#enemyProposals').append($('<option>').append(values[i]));
                }
            }
        });
    }

});

$(document).ready(function () {
    $('#uploadBtnFull').click(function () {
        var fullPath = document.getElementById('fileUp').value;
        if (fullPath) {
            var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
            var filename = fullPath.substring(startIndex);
            if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
                filename = filename.substring(1);
            }
            console.log(filename);
        }
        $.ajax({
            type : "GET",
            url : "Author_Servlet",
            data : {
                action : "uploadF",
                filename : filename,
                fullName : $('#fullPaperName').val()
            },
            success : function (result) {
                var res = result;
                if (res === "success")
                    alert("Uploaded successfuly!");
                else
                    alert("Can't upload!");
            }
        });
    });
});

$(document).ready(function () {
    $('#uploadBtnAbs').click(function () {
        var fullPath = document.getElementById('fileUpl').value;
        if (fullPath) {
            var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
            var filename = fullPath.substring(startIndex);
            if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
                filename = filename.substring(1);
            }
            console.log(filename);
        }
        $.ajax({
            type : "GET",
            url : "Author_Servlet",
            data : {
                action : "uploadA",
                filename : filename,
                abstrName : $('#abstractPaperName').val()
            },
            success : function (result) {
                var res = result;
                if (res === "success")
                    alert("Uploaded successfuly!");
                else
                    alert("Can't upload!");
            }
        });
    });
});
$(document).ready(function () {
   $('#abstractEdit').click(function () {
       var fullPath = document.getElementById('abstractNewFile').value;
       if (fullPath) {
           var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
           var filename = fullPath.substring(startIndex);
           if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
               filename = filename.substring(1);
           }
           console.log(filename);
       }
       $.ajax({
          type : "GET",
           url : "Author_Servlet",
           data :{
              action : "editAbs",
               edit : $('#mineAbstractFileName').val(),
               file : filename
           },
           success : function (result) {
               var res = result.split('|');
               if (res[0] === "success"){
                   $("#mineAbstractFN").val(res[1]);
                   alert("Uploaded successfuly!");
               }
               else
                   alert("Can't upload!");
           }
       });
   });
});
$(document).ready(function () {
    $('#mineProposalEdit').click(function () {
        var fullPath = document.getElementById('mineProposalNewFile').value;
        if (fullPath) {
            var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
            var filename = fullPath.substring(startIndex);
            if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
                filename = filename.substring(1);
            }
            console.log(filename);
        }
        $.ajax({
            type : "GET",
            url : "Author_Servlet",
            data :{
                action : "editFull",
                edit : $('#mineFullFileName').val(),
                file : filename
            },
            success : function (result) {
                var res = result.split('|');
                if (res[0] === "success"){
                    $("#mineFullFN").val(res[1]);
                    alert("Uploaded successfuly!");
                }
                else
                    alert("Can't upload!");
            }
        });
    });
});