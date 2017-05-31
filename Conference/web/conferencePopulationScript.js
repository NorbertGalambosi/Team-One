/**
 * Created by Viman Adrian on 30.05.2017
 */

$(document).ready(function () {
    $.ajax({
        type : "GET",
        url : 'Authors_Servlet',
        data : {
            action : "populate",
            req : "name"
        },
        success : function(result){
            var res = result;
            $("#conferencename").val(res);
        }
    });
    $.ajax({
        type : "GET",
        url : 'Authors_Servlet',
        data : {
            action : "populate",
            req : "edition"
        },
        success : function(result){
            var res = result;
            $("#edition").val(res);
        }
    });
    $.ajax({
        type : "GET",
        url : 'Authors_Servlet',
        data : {
            action : "populate",
            req : "session"
        },
        success : function(result){
            var res = result;
            $("#sessions").val(res);
        }
    });
    $.ajax({
        type : "GET",
        url : 'Authors_Servlet',
        data : {
            action : "populate",
            req : "interval"
        },
        success : function(result){
            var res = result;
            $("#interval").val(res);
        }
    });
    $.ajax({
        type : "GET",
        url : 'Authors_Servlet',
        data : {
            action : "populate",
            req : "call"
        },
        success : function(result){
            var res = result;
            $("#call").val(res);
        }
    });
    $.ajax({
        type : "GET",
        url : 'Authors_Servlet',
        data : {
            action : "populate",
            req : "bdeadline"
        },
        success : function(result){
            var res = result;
            $("#bdeadline").val(res);
        }
    });
    $.ajax({
        type : "GET",
        url : 'Authors_Servlet',
        data : {
            action : "populate",
            req : "pdeadline"
        },
        success : function(result){
            var res = result;
            $("#pdeadline").val(res);
        }
    });
    $.ajax({
        type : "GET",
        url : 'Authors_Servlet',
        data : {
            action : "populate",
            req : "adeadline"
        },
        success : function(result){
            var res = result;
            $("#adeadline").val(res);
        }
    });
    $.ajax({
        type : "GET",
        url : 'Authors_Servlet',
        data : {
            action : "populate",
            req : "fdeadline"
        },
        success : function(result){
            var res = result;
            $("#fdeadline").val(res);
        }
    });
    $.ajax({
        type : "GET",
        url : 'Authors_Servlet',
        data : {
            action : "populate",
            req : "rdeadline"
        },
        success : function(result){
            var res = result;
            $("#rdeadline").val(res);
        }
    });
    $.ajax({
        type : "GET",
        url : 'Authors_Servlet',
        data : {
            action : "populate",
            req : "nrp"
        },
        success : function(result){
            var res = result;
            $("#nrp").val(res);
        }
    });
    $.ajax({
        type : "GET",
        url : 'Authors_Servlet',
        data : {
            action : "populate",
            req : "active"
        },
        success : function(result){
            var res = result;
            if(res=="activ")
                $("#active").prop('checked', true);
        }
    });
});

