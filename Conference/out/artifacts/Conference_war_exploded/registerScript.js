/**
 * Created by crys_ on 30.05.2017.
 */
$(document).ready(function () {
    $('#btnregister').click(function () {
        if ($('#check1').is(':checked'))
        {
            $.ajax({
                type: "POST",
                url: 'Register_Servlet',
                data: {
                    action: "register",
                    id: $('#id').val(),
                    nume: $('#name').val(),
                    affiliation: $('#affiliation').val(),
                    email: $('#email').val(),
                    webpage: $('#webpage').val(),
                    username: $('#username').val(),
                    password: $('#password').val(),
                    type: $('#registerType option:selected').val()
                },
                success: function (result) {
                    var res = result;
                    alert(res);
                    if (res === 'SuccessAuthor')
                        window.location.href = "authors.jsp";
                    if (res === 'SuccessListener')
                        window.location.href = "listeners.jsp";
                    if (res === 'Invalid')
                        alert("Invalid login, try again!");
                }
            });
        }
        else alert("Pay before creating a new account!");
    });
});
