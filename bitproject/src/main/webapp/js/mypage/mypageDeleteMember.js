$(function() {
	$("#delete").click(function() {
		$( "#dialog-confirm" ).dialog({
			resizable: false,
			height:200,
			width:300,
			modal: true,
			buttons: {
				"확인": function() {
					$( this ).dialog( "close" );
					$(function() {
						$.ajax("../ajax/member/delete.do?", {
							method : "POST",
							dataType : "json"
						});
					});
					location.href = "../auth/logout.do";
				},
				"취소": function() {
					$( this ).dialog( "close" );
				}
			}
		})
	});
}) 