/**
 * Created by Viman Adrian on 02.06.2017.
 */

$(document).ready(function () {
    update();

    $('#submitPaper').click(function () {
        alert("submitPaper");
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
                if(res=="succes"){
                    alert("Adaugat cu succes");
                    update();
                }
                else{
                    alert("Eroare");
                }
            }
        });
    });

    function update() {
        alert("update");
    }
});

