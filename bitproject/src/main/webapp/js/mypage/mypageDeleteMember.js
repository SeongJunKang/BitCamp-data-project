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
			closeOnCancel: false 
			}, 
			function(isConfirm) {   
				if (isConfirm) {  
					$.ajax("../ajax/member/delete.do?", {
						method : "POST",
						dataType : "json"
					});
					swal("회원 정보가 삭제되었습니다.", "success");   
					location.href = "../auth/logout.do";
				} else {
					swal("회원 정보 삭제에 실패하였습니다.", "error");   
				} 
			});

	});
}) 