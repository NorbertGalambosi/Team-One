/**
 * Created by Waiting on 25-May-17.
 */
// $(document).ready(function () {
//     $('#btnsubmit').click(function () {
//         $.ajax({
//             type : "POST",
//             url : 'RegisterLogin_Servlet',
//             data : {
//                 action : "login",
//                 user : $('#username').val(),
//                 pass : $('#password').val(),
//                 type : $('#memberType option:selected').val()
//             }
//         });
//     });
// });
$(document).ready(function () {
    $('#btnsubmit').click(function () {
        $.post('RegisterLogin_Servlet', { action: "login", user : $('#username').val(),pass : $('#password').val(),type : $('#memberType option:selected').val()},
            function(returnedData){
                console.log(returnedData);
            }).fail(function(){
            console.log("error");
        });
    });
});
