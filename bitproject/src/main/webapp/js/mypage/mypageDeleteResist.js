$(function() {
	$("#deleteresist").click( function() {
		swal({   
				title: "도그워커 정보 삭제",   
				text: "정말로 도그워커 정보를 삭제하시겠습니까?",   
				type: "warning",   
				showCancelButton: true,   
				confirmButtonText: "삭제",   
				cancelButtonText: "취소",   
				closeOnConfirm: false,   
				showLoaderOnConfirm: true, 
			},function(isConfirm) {    
				if (isConfirm) { 
					setTimeout(function() {  
						$.ajax("../ajax/petsitter/delete.do", {
							method : "POST",
							success : function(result) {
								if (result.status == "success") {
									$.post("../ajax/member/upgrade.do?",{
									 	gra :  1
							         }, function(result) {
											if ( result.status == "success" ) {
												swal({   
													title: "도그워커 정보 삭제",   
													text: "등록된 도그워커 정보가 삭제되었습니다.",   
													type: "success",   
													showCancelButton: false,   
													confirmButtonText: "확인",   
													closeOnConfirm: false,   
													}, 
													function(isConfirm) {   
														if (isConfirm) {  
															location.href ="mypage3.html";
														} 
													});   
											}
										}, "json");
								} else {
									swal("도그워커 정보 삭제 실패","등록된 도그워커 정보를 삭제 실패했습니다.", "error");
								}
							}
						});
					}, 2000); 
				}
			});
	});
})      