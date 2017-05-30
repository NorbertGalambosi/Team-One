/**
 * Created by Viman Adrian on 30.05.2017.
 */

$(document).ready(function () {
    $.ajax({
        type : "GET",
        url : 'Authors_Servlet',
        data : {
            action : "populate"
        },
        success : function(result){
            var res = result;
            $("#call").val(res);
        }
    });
});

