/**
 * Created by crys_ on 30.05.2017.
 */
$(document).ready(function () {
    $('#check').click(function () {
        alert("servus");
            $.ajax({
                type: "POST",
                url: 'ServletFindPCMemberId',
                data: {
                    action : "check",
                    user : $('#username').val()
                },
                success : function (result) {
                    var res = result;
                    if(res>0)
                        alert("Your id is: " + res);
                    if (res === 'eroare')
                        alert("Invalid user, try again!");
    }
});
    });
});
