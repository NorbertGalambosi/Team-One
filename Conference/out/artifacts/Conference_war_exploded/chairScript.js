/**
 * Created by gnorb on 30-May-17.
 */


$(document).ready(function(){
    populateSesionLists();
});
function populateSesionLists(){
    $.ajax({
        type : "GET",
        url : "PopulateSessionLists_Servlet",
        data : {
            action : "sessions"
        },
        success : function(result){
            var res = result.split('|');

            var select = document.getElementById('sessionOptions');
            for(var i=0;i<res.length-1;i++){
                var opt = document.createElement('option');
                opt.label = res[i];
                opt.innerHTML = res[i];
                select.appendChild(opt);
            }

            var select1 = document.getElementById('sessionOptionsL');
            for(var i=0;i<res.length-1;i++){
                var opt = document.createElement('option');
                opt.label = res[i];
                opt.innerHTML = res[i];
                select1.appendChild(opt);
            }

            var select2 = document.getElementById('sessionOptionsSp');
            for(var i=0;i<res.length-1;i++){
                var opt = document.createElement('option');
                opt.label = res[i];
                opt.innerHTML = res[i];
                select2.appendChild(opt);
            }
        }
    });
    pupulatePcMbsList()
}
function pupulatePcMbsList(){
    $.ajax({
        type : "GET",
        url : "PopulateSessionLists_Servlet",
        data : {
            action : "pcmbs"
        },
        success : function(result){
            var res = result.split('|');
            var select = document.getElementById('pcOptions');
            for(var i=0;i<res.length-1;i++){
                var opt = document.createElement('option');
                opt.label = res[i];
                opt.innerHTML = res[i];
                select.appendChild(opt);
            }

            var select1 = document.getElementById('pcOptionsL');
            for(var i=0;i<res.length-1;i++){
                var opt = document.createElement('option');
                opt.label = res[i];
                opt.innerHTML = res[i];
                select1.appendChild(opt);
            }

            var select2 = document.getElementById('pcOptionsSp');
            for(var i=0;i<res.length-1;i++){
                var opt = document.createElement('option');
                opt.label = res[i];
                opt.innerHTML = res[i];
                select2.appendChild(opt);
            }
        }
    });
}


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
$(document).ready(function() {
    $('#updateConference').click(function () {
        if ($("#active").is(':checked'))
            var active = "checked";
        else
            var active = "notchecked";
        $.ajax({
            type: 'GET',
            url: "Chair_Servlet",
            data: {
                action: "update",
                confname: $('#conferencename').val(),
                edt: $('#edition').val(),
                ses: $('#sessions').val(),
                interv: $('#interval').val(),
                call: $('#call').val(),
                bid: $('#bdeadline').val(),
                prop: $('#pdeadline').val(),
                abstr: $('#adeadline').val(),
                full: $('#fdeadline').val(),
                revs: $('#rdeadline').val(),
                partnr: $('#nrp').val(),
                active: active
            }
        });
    });
});

$(document).ready(function(){
   $('#addChairToSession').click(function(){
       var session= $('#sessionOptions :selected').attr('label');
       var chair= $('#pcOptions :selected').attr('label');
       console.log(session);
       console.log(chair);
       $.ajax({
          type : "GET",
          url : "ChairAssigns_Servlet",
          data : {
              action : "chair",
              chair : chair,
              session : session
          },
           success : function (result) {
               if (result === "done")
                   alert("Successfuly assigned chair!");
               else
                   alert("Can't assign chair to session!");
           }
      });
   });
});
$(document).ready(function(){
    $('#addListenersToSession').click(function(){
        var session= $('#sessionOptionsL :selected').attr('label');
        var listeners = "";
        $("#pcOptionsL :selected").each(function(){
            listeners = listeners+($(this).attr('label'))+"|";
        });

        console.log(session);
        console.log(listeners);
        $.ajax({
            type : "GET",
            url : "ChairAssigns_Servlet",
            data : {
                action : "listeners",
                listeners : listeners,
                session : session
            },
            success : function (result) {
                if (result === "done")
                    alert("Successfuly assigned listeners!");
                else
                    alert("Can't assign listeners to session!");
            }
        });
    });
});