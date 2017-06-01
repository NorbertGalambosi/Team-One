/**
 * Created by gnorb on 30-May-17.
 */
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
               confname : $('#conferencename').val(),
               edt : $('#edition').val(),
               ses : $('#sessions').val(),
               interv : $('#interval').val(),
               call : $('#call').val(),
               bid : $('#bdeadline').val(),
               prop : $('#pdeadline').val(),
               abstr : $('#adeadline').val(),
               full : $('#fdeadline').val(),
               revs : $('#rdeadline').val(),
               partnr : $('#nrp').val(),
               active : active
   }
       });
   });
});
