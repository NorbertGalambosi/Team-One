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

