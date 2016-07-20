$(document).ready(function() {
   $('.cont1').css("display", "");
   $('.cont2').css("display", "none");
   $.getJSON("../ajax/request/petrequestlist.do", function(result) {
      if (result.status == "success") {
         var templateData = $('#temp1').html();
         var template = Handlebars.compile(templateData);
         var list_length = result.list.length
         for (var i = 0; i < list_length; i++) {
            if (result.list[i].stat != "대기") {
               result.list.splice(i, i); // 리스트에서 제거하는 역할
               list_length -= 1; // 제거했으니 길이도 줄어듬
               i -= 1; // 길이가 줄어드니 다시 제자리반복.
            }
         }
         var html = template(result);
         $("#requestTable tbody").append(html);
      }
   });
   $(window).load(function() {
      $('#loading').hide();
   });

   $("#logout").click(function() {
      $(window).load(function() {
         $('#loading').hide();
      });
      location.href = "../auth/logout.do";
      event.preventDefault();
   });

   $(".signup").click(function(e) {
      $('.cont1').css("display", "none");
      $('.cont2').css("display", "");
   });

   $(".signin").click(function(e) {
      $('.cont1').css("display", "");
      $('.cont2').css("display", "none");
   });
   $("#mypage").click(function() {
      $(window).load(function() {
         $('#loading').hide();
      });
      location.href = "../mypage/mypage3.html"
      event.preventDefault();
   });
   $(".lookpet").click(function() {
      $(window).load(function() {
         $('#loading').hide();
      });
      location.href = "petsearch.html"
      event.preventDefault();
   });

   $.getJSON("../ajax/request/petrequestlist.do", function(result) {
      if ((result.status == "success") && (result.list.length != 0)) {
         $("#ex1").dialog({
            resizable : false,
            height : 400,
            width : 600,
            modal : true,
            buttons : {
               "상세보기" : function() {
                  $(this).dialog("close");
                  location.href = '../mypage/inquiry.html'
               },
               "확인" : function() {
                  $(this).dialog("close");
               }
            }
         }).parents(".ui-dialog").find(".ui-dialog-titlebar").remove();
      }
   })
});

function onclickDetail(event) {
   location.href = "detail.html?no=" + $(event.currentTarget).attr("data-pno")
   event.preventDefault();
}
function goMain(event) {
   location.href = "index.html"
   event.preventDefault();
}

function requestDetail(event) {
   event.preventDefault(); // 원래 a 태그의 행위를 막는다.
   var reqNo  = event.target.getAttribute("data-no"); 
   $.getJSON("../ajax/request/detail.do?req="+reqNo, function(result) {
      $("#reqname").html(result.mname + "<br>");
      $("#reqtel").html(result.request.m_tel + "<br>");
      $("#date").html(result.request.date + "<br>");
      $("#conts").html(result.request.conts);
      $("#answer1").html("<br>" + result.request.res);
      $("#answer2").html("<br>" + result.request.neut);
      $("#answer3").html("<br>" + result.request.anifd);
      $("#answer4").html("<br>" + result.request.manfd);
      $("#answer5").html("<br>" + result.request.bark);
      $("#answer6").html("<br>" + result.request.diz);
      $("#answer7").html("<br>" + result.request.meal);
      $("#answer8").html("<br>" + result.request.train);
      if (result.request.stat == "대기") {
         $("#inex1").dialog({
            resizable : false,
            height : 600,
            width : 500,
            modal : true,
            buttons : {
               "수락" : function() {
                  $.ajax("../ajax/request/update.do", {
                     method : "POST",
                     dataType : "json",
                     data : {
                        req : reqNo,
                        stat : "수락"
                     },
                     success : function(result) {
                        if (result.status == "success") {
                           location.href = "index.html";
                        } else {
                           swal("변경 실패입니다!", " ", "warning");
                        }
                     },
                     error : function() {
                        swal("서버 요청 실패입니다!", " ", "warning");
                     }
                  });
                  $(this).dialog("close");
               },
               "거절" : function() {
                  $.ajax("../ajax/request/update.do", {
                     method : "POST",
                     dataType : "json",
                     data : {
                        req : reqNo,
                        stat : "거절"
                     },
                     success : function(result) {
                        if (result.status == "success") {
                           location.href = "index.html";
                        } else {
                           swal("거절 실패입니다!", " ", "warning");
                        }
                     },
                     error : function() {
                        swal("서버 요청 실패입니다!", " ", "warning");
                     }
                  });
                  $(this).dialog("close");
               },
               "목록" : function() {
                  $(this).dialog("close");
               }
            }
         }).parents(".ui-dialog").find(".ui-dialog-titlebar").remove();
      } else {
         $("#inex1").dialog({
            resizable : false,
            height : 600,
            width : 500,
            modal : true,
            buttons : {
               "목록" : function() {
                  $(this).dialog("close");
               }
            }
         }).parents(".ui-dialog").find(".ui-dialog-titlebar").remove();
      }
   });
   // location.href = "requeDetail.html?req=" +
   // event.target.getAttribute("data-no");
}