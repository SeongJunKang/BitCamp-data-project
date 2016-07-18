$(function() {
	$("#savebtn").click(function() {
		if ($("#email").attr("data-state") != "ok") {
			$(function() {
                $( "#dialog-check-email" ).dialog({
                  resizable: false,
                  height:180,
                  width:300,
                  show: {
                      effect: "blind",
                      duration: 500
                    },
                    hide: {
                      effect: "fadeOut",
                      duration: 500
                    },
                  modal: true,
                  buttons: {"확인": function() {
                    $( this ).dialog( "close" );
                    }}
                });
			});
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
						$(function() {
	                     $( "#dialog-signup-success" ).dialog({
	                       resizable: false,
	                       height:150,
	                       width:400,
	                       show: {
	                           effect: "blind",
	                           duration: 500
	                         },
	                         hide: {
	                           effect: "fadeOut",
	                           duration: 500
	                         },
	                       modal: true,
	                       buttons: {"확인": function() {
	                         $( this ).dialog( "close" );
	                         }},
	                       close : function() {
	                    	   location.href= "index.html"
	                       }
	                     });
						});
					} else {
	                 $(function() {
	                     $( "#dialog-signup-fail" ).dialog({
	                       resizable: false,
	                       height:180,
	                       width:300,
	                       show: {
	                           effect: "blind",
	                           duration: 500
	                         },
	                         hide: {
	                           effect: "fadeOut",
	                           duration: 500
	                         },
	                       modal: true,
	                       buttons: {"확인": function() {
	                         $( this ).dialog( "close" );
	                         }}
	                     });
	                   });
					}
				}, "json");
			}
		}
	});
})   