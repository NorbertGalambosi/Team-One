/**
 * Created by Viman Adrian on 02.06.2017.
 */

$(document).ready(function () {

    fillMyProposals();
    fillEnemyProposals();

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
                    values = res.split("|");
                    $("#mineReviews").empty();
                    for (var i = 0; i < values.length - 1; i++) {
                        $('#mineReviews').append($('<option>').append(values[i]));
                    }
                }
            });
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
                $("#enemyProposals").empty();
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