/**
 * Created by crys_ on 30.05.2017.
 */
$(document).ready(function () {
    $('#review').click(function () {
        alert("servus");
        $.ajax({
            type: "POST",
            url: 'ServletAddReview',
            data: {
                action : "review",
                idP : $('#idP').val(),
                idR : $('#idR').val(),
                recomandation : $('#recomandation').val(),
                qualifier : $('#qualifier').val()
            },
            success : function (result) {
                var res = result;
                if(res === 'succes')
                    alert("saved changes!");
                if (res === 'eroare')
                    alert("Invalid user, try again!");
            }
        });
    });
});
