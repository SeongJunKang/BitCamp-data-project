$(function() {
	$("#delete").click(function() {
		swal({   
			title: "회원탈퇴",   
			text: "정말로 회원 탈퇴하시겠습니까? 데이터가 복구되지 않습니다.",   
			type: "warning",   
			showCancelButton: true,   
			confirmButtonColor: "#DD6B55",   
			confirmButtonText: "삭제",   
			cancelButtonText: "취소",   
			closeOnConfirm: false,   
			closeOnCancel: true 
			}, 
			function(isConfirm) {   
				if (isConfirm) {  
					$.ajax("../ajax/member/delete.do?", {
						method : "POST",
						dataType : "json"
					});
					swal({   
						title: "회원 탈퇴",   
						text: "회원 정보가 삭제되었습니다.",   
						type: "success",   
						showCancelButton: false,   
						confirmButtonColor: "#DD6B55",   
						confirmButtonText: "확인",   
						closeOnConfirm: false,   
						closeOnCancel: false 
						}, 
						function(isConfirm) {   
							if (isConfirm) {  
								location.href = "../auth/logout.do";
							}
						});
				} 
			});

	});
}) 