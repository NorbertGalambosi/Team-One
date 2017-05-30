/**
 * Created by Florina on 23.05.2017.
 */
$(document).ready(function () {
    $('#btnregister').click(function(){

            $("#register").css({"width": "$(window).outerWidth()",
            "height":"100vh"})
            $("#register").slideDown("slow");
            $("#login").addClass("disable");
            }
        );
    }
);