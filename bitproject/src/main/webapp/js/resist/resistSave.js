$(function() {
   $("#savebtn").click(function() {
      if ($("#checknick").attr("data-state") == "no") {
         swal("닉네임 체크를 클릭해주세요.", " ", "warning");
      } else {
          var checklist="";
            $("input[name=box]:checked").each(function() {
              checklist += $(this).val()+",";
            });
          checklist = checklist.substring(0,checklist.length-1);
          var radian = 0;
          if ($("#radian").val() != "") {
            radian = $("#radian").val();
          }

          $.post("../ajax/petsitter/add.do", {
              nick : $("#nickname").val(),
              amt :$("#price").val(),        
              ktalk : $("#kakao").val(),
              region : $("#region").val(),
              bank : $("#bank").val(),
              bknm: $("#holder").val(),
              acc : $("#account").val(),
              ser : checklist,
              inqur : $("#inqur1").val() + "시 ~ "
                     +$("#inqur2").val()+ "시",
              pet :  $( "#animal").val(),
              addr_1 :$("#addr1").val(),
              addr_2 :$("#addr2").val(),
              addr_3 :$("#addr3").val(),
              rad : radian,
              lat : $("#lat").val(),
              lnt : $("#lnt").val(),
              intro :$("#intro").val(),
              hospital : $("#hospital").val()
            }, function(result) {
              if (result.status == "success") {
                  $.post("../ajax/member/upgrade.do?", {
                      gra :  2
                    }, function(result) {
                      if (result.status == "success") {
                    	  swal({   
      						title: "도그워커 등록 완료",   
      						text: "산책할개에 도그워커로 오신것을 환영합니다.",   
      						type: "success",   
      						showCancelButton: false,   
      						confirmButtonColor: "#DD6B55",   
      						confirmButtonText: "확인",   
      						closeOnConfirm: false,   
      						closeOnCancel: false 
      						}, 
      						function(isConfirm) {   
      							if (isConfirm) {  
      								location.href = "../main/index.html";
      							}
      						});
                       } else {
                         swal("등록 실패입니다.", " ", "warning");
                       }
                  }, "json");
              } else {
                swal("등록 실패입니다.", " ", "warning");
              }
            }, "json");

      }
   });
})