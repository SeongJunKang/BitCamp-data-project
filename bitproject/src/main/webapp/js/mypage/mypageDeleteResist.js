$(function() {
	$("#deleteresist").click( function() {
		$("#dialog-deletec").dialog({
			resizable: false,
			height:170,
			width:320,
			modal: true,
            show: {
                effect: "blind",
                duration: 500
              },
              hide: {
                effect: "fadeOut",
                duration: 500
              },
			buttons: {
				"확인": function() {
					$.ajax("../ajax/petsitter/delete.do", {
						method : "POST",
						success : function(result) {
							if (result.status == "success") {
								$.post("../ajax/member/upgrade.do?",{
								 	gra :  1
						         }, function(result) {
										if ( result.status == "success" ) {
											location.href ="mypage3.html";
										}
									}, "json");
							} else {
								$(function() {
									$( "#dialog-deletef" ).dialog({
										resizable: false,
										height:180,
										width:320,
										modal: true,
										show: {
											effect: "blind",
											duration: 500
										},
										hide: {
											effect: "fadeOut",
											duration: 500
										},
										buttons: {
											"확인": function() {
												$( this ).dialog( "close" );
											}
										}
									});
								});
							}
						}
					});
					$( this ).dialog( "close" );
					event.preventDefault();
				},
				"취소" : function(){
					$( this ).dialog( "close" );
				}
			}
		})

	});
})      