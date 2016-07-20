$(function() {
	$("#savebtn").click(function() {
		if ($("#email").attr("data-state") != "ok") {
			swal("회원가입 실패", "이메일 중복확인 또는 형식을 맞춰주세요.", "error");
		} else {
			if ( $("#password").val() == "" ) {
				$("#checkText").css("display","none");
			} else {
				$("#checkText").css("display","");
			}
			if ( ($("#password").val() != "") && ($("#password").val() == $("#passwordcheck").val()) ) {
				$.post("../ajax/member/add.do", {
					name : $("#name").val(),
					email : $("#email").val(),
					password : $("#password").val(),
					tel : $("#phone1").val()+"-"+
					$("#phone2").val()+"-"+
					$("#phone3").val(),
					agc : $("#agency").val(),
					gen : $(".gender").html(),
					bth :  $( "#birthdayYear").val() +"-"+
					$("#birthdayMonth").val() +"-"+
					$("#birthdayDay").val() 
				},  function(result) {
					if (result.status == "success") {
						swal({   
							title: "회원가입 완료",   
							text: "산책할개에 오신것을 환영합니다.",   
							type: "success",   
							showCancelButton: false,   
							confirmButtonColor: "#DD6B55",   
							confirmButtonText: "확인",   
							closeOnConfirm: false,   
							closeOnCancel: false 
							}, 
							function(isConfirm) {   
								if (isConfirm) {  
									location.href= "index.html"
								}
							});
					} else {
						swal("회원가입 실패", "등록된 정보를 확인하시거나 잠시 후 다시 이용해주세요.", "error");
					}
				}, "json");
			}
		}
	});
})   