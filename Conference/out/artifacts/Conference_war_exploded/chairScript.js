/**
 * Created by gnorb on 30-May-17.
 */

// $(document).ready(function(){
//     $.ajax({
//         type : "GET",
//         url : "Chair_Servlet",
//         data : {
//             action : "populate"
//         },
//         success : function(result){
//             console.log(result);
//         }
//     });
// });

$(document).ready(function(){
   $('#createConference').click(function(){
       if($("#active").is(':checked'))
           var active = "checked";
       else
           var active = "notchecked";
       $.ajax({
           type : 'GET',
           url : "Chair_Servlet",
           data : {
               action : "create",
               confname : $('#confname').val(),
               edt : $('#edition').val(),
               ses : $('#sesions').val(),
               interv : $('#interval').val(),
               call : $('#call').val(),
               bid : $('#bidline').val(),
               prop : $('#propline').val(),
               abstr : $('#absline').val(),
               full : $('#fullline').val(),
               revs : $('#revline').val(),
               partnr : $('#parno').val(),
               active : active
   }
       });
   });
});
