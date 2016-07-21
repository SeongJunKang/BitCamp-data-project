/**
 * 
 */
  var pno = location.href.split("=")[1];  // 현재 보는 펫시터 번호
    $(document).ready(function(){
      $('#date').bootstrapMaterialDatePicker
      ({
        time: false,
        clearButton: true
      });
      $('#time').bootstrapMaterialDatePicker
      ({
        date: false,
        shortTime: false,
        format: 'HH:mm'
      });
      $('#date-format').bootstrapMaterialDatePicker
      ({
        format: 'YYYY MMMM DD dddd- HH:mm'
      });
   
      $.getJSON("../ajax/petsitter/detail.do?no="+pno, 
        function(result) {
          if ( result.status =="success") {
              $("#price").html(result.amt);
          }
      });
      $(function() {
	   	  $("#admit").click(function() {
	   		  
	   		swal({   
				title: "산책대행 신청",   
				text: "산책대행을 신청하시겠습니까 ?",   
				type: "warning",   
				showCancelButton: true,   
				confirmButtonText: "신청",   
				cancelButtonText: "취소",   
				closeOnConfirm: false,   
				closeOnCancel: true 
				}, 
				function(isConfirm) {   
					if (isConfirm) {  
				          $.post("../ajax/request/add.do", {
				              pno : pno,
				              date : $('#date-format').val(),
				              conts : $('#requirement').val(),
				              res : $("input[type=radio][name=resist]:checked").val(),
				              neut : $("input[type=radio][name=neutralize]:checked").val(),
				              anifd : $("input[type=radio][name=anifriendly]:checked").val(),
				              manfd : $("input[type=radio][name=humanfriendly]:checked").val(),
				              bark : $("input[type=radio][name=bark]:checked").val(),
				              diz : $("input[type=radio][name=disease]:checked").val(),
				              meal : $('#mealtime').val(),
				              train : $('#training').val()
				              }, function(result) {
				                if (result.status == "success") {
									swal({   
										title: "산책대행 신청 성공",   
										text: "도그워커가 곧 연락할 것입니다.",   
										type: "success",   
										showCancelButton: false,   
										confirmButtonText: "확인",   
										closeOnConfirm: false,   
										closeOnCancel: false 
										}, 
										function(isConfirm) {   
											if (isConfirm) {  
												location.href = "../main/index.html";
											}
										});
				                } else if (result.status == "failure") {
				             	   swal("산책대행 신청 실패", "모든 항목에 입력을 해주세요.", "error");
				                } else if (result.status == "same") {
				                   swal("본인에게 산책대행을 신청할 수 없습니다.", " ", "error");
				                }
				              }, "json");
					}
				});
        });
      });
		$("#login").click = function() {
			location.href = "../mypage/mypage.html"
			event.preventDefault();
		}
    });