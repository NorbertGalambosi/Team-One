/**
 * Created by Waiting on 25-May-17.
 */
$(document).ready(function () {
    $('#btnsubmit').click(function () {
        $.ajax({
            type : "POST",
            url : 'RegisterLogin_Servlet',
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

// $(document).ready(function () {
//     $('#btnsubmit').click(function () {
//         $.post('RegisterLogin_Servlet', { action: "login", user : $('#username').val(),pass : $('#password').val(),type : $('#memberType option:selected').val()},
//             function(returnedData){
//                 console.log(returnedData);
//             }).fail(function(){
//             console.log("error");
//         });
//     });
// });
//BOTH WAYS ARE WORKING...USE THE ONE YOU LIKE THE MOST
