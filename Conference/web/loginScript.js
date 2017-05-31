/**
 * Created by Waiting on 25-May-17.
 */
$(document).ready(function () {
    $('#btnsubmit').click(function () {
        $.ajax({
            type : "POST",
            url : 'Login_Servlet',
            data : {
                action : "login",
                user : $('#username').val(),
                pass : $('#password').val(),
                type : $('#memberType option:selected').val()
            },
            success : function(result){
                var res = result;
                if (res === 'SuccessAuthor')
                    window.location.href="authors.jsp";
                if (res === 'SuccessChair')
                    window.location.href="chair.jsp";
                if (res === 'SuccessReviewer')
                    window.location.href="reviewer.jsp";
                if (res === 'SuccessListener')
                    window.location.href="listeners.jsp";
                if (res === 'Invalid')
                    alert("Invalid login, try again!");
            }
        });
    });
});