/**
 * Created by gnorb on 30-May-17.
 */


$(document).ready(function(){
    populateSesionLists();
    pupulatePcMbsList()
    getPapers();
    getReviewers();
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

            var select2 = document.getElementById('pcOptionsSp');
            for(var i=0;i<res.length-1;i++){
                var opt = document.createElement('option');
                opt.label = res[i];
                opt.innerHTML = res[i];
                select2.appendChild(opt);
            }
        }
    });
    $.ajax({
        type : "GET",
        url : "PopulateSessionLists_Servlet",
        data : {
            action : "pcmbsL"
        },
        success : function(result){
            var res = result.split('|');
            var select1 = document.getElementById('pcOptionsL');
            for(var i=0;i<res.length-1;i++){
                var opt = document.createElement('option');
                opt.label = res[i];
                opt.innerHTML = res[i];
                select1.appendChild(opt);
            }
        }
    });
}
function getPapers(){
    $.ajax({
       type : "GET",
        url : "ChairPRs_Servlet",
        data : {
           action : "papers"
        },
        success : function (result) {
            var papersList = result.split('|');
            var select = document.getElementById('paperList');
            for(var i=0;i<papersList.length-1;i++){
                var papers = papersList[i].split(';');
                var id = papers[0];
                var propname = papers[1];
                var keys = papers[2];
                var topics = papers[3];
                var autor = papers[5];
                var opt = document.createElement('option');
                opt.label = id+":Name :"+propname+" Autor : "+autor+" Keywords : "+keys+" Topics : "+topics;
                opt.innerHTML = id+":Name :"+propname+" Autor : "+autor+" Keywords : "+keys+" Topics : "+topics;
                select.appendChild(opt);
            }
        }
    });
}
function getReviewers() {
    $.ajax({
        type : "GET",
        url : "ChairPRs_Servlet",
        data : {
            action : "reviewers"
        },
        success : function (result) {
            var reviewersList = result.split('|');
            var select = document.getElementById('revsList');
            for(var i=0;i<reviewersList.length-1;i++){
                var reviewer = reviewersList[i].split(';');
                var id = reviewer[0];
                var name = reviewer[1];
                var opt = document.createElement('option');
                opt.label = id+":Name : "+name;
                opt.innerHTML = id+":Name : "+name;
                select.appendChild(opt);
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
        var listener = $('#pcOptionsL :selected').attr('label');

        console.log(session);
        console.log(listener);
        $.ajax({
            type : "GET",
            url : "ChairAssigns_Servlet",
            data : {
                action : "listeners",
                listeners : listener,
                session : session
            },
            success : function (result) {
                if (result === "done")
                    alert("Successfuly assigned listener!");
                else
                    alert("Can't assign listener to session!");
            }
        });
    });
});
$(document).ready(function(){
    $('#addSpeakersSession').click(function(){
        var session= $('#sessionOptionsSp :selected').attr('label');
        var speaker = $('#pcOptionsSp :selected').attr('label');

        console.log(speaker);
        $.ajax({
            type : "GET",
            url : "ChairAssigns_Servlet",
            data : {
                action : "speakers",
                speaker : speaker,
                session : session
            },
            success : function (result) {
                if (result === "done")
                    alert("Successfuly assigned speaker!");
                else
                    alert("Can't assign speaker to session!");
            }
        });
    });
});
$(document).ready(function() {
    $('#btnPr2Rev').click(function () {
        var proposal= $('#paperList :selected').attr('label');
        var reviewer = $('#revsList :selected').attr('label');
        $.ajax({
            type : "GET",
            url : "ChairPRs_Servlet",
            data : {
                action : "assign",
                proposal : proposal,
                reviewer : reviewer
            },
            success : function (result) {
                if (result === "done")
                    alert("Successfuly assigned reviewer!");
                else
                    alert("Can't assign reviewer to proposal!");
            }
        });
    });
});