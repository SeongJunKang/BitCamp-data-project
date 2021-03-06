   var pno = location.href.split("=")[1];
$(function(){
   $("#sendReview").click(function() {
		if (sessionStorage.getItem("login") != "success") {
			swal("로그인 해야 이용할 수 있습니다.", " ", "warning");
			return;
		}
      $.ajax("../ajax/userreview/add.do?", {
          method : "POST",
          dataType : "json",
          data : {
            pno : pno,
            review :  $("#userreview").val()
          },
          success : function(result) {
            if (result.status == "success") {
            	location.href = "detail.html?no="+pno;
            } else if ( result.status == "failure") {
            	swal("댓글 등록에 실패했습니다.", " ", "warning")
            } else {
            	swal("댓글 등록은 하나만 가능합니다.", " ", "warning")
            }
          }
      });
   })	 
})

$(function() {
	$.ajax("../ajax/userreview/list.do?pno="+location.href.split("=")[1],{
	method : "POST",
	dataType : "json",
	success : function(result) {
			var templateData = $("#reviewrepeat").html();
			var template = Handlebars.compile(templateData);
			var html = template(result);
			$("#reviewtext").append(html);
			$(".review_update_delete").css("display","none");
			$("#review_"+result.userNo).css("display","");
			$("#review_update_"+result.userNo).click(function() {
				if ($("#review_text_"+result.userNo).attr("readonly") == "readonly") {
					$("#review_text_"+result.userNo).removeAttr("readonly");
				} else {
				      $.ajax("../ajax/userreview/update.do?", {
				          method : "POST",
				          dataType : "json",
				          data : {
				            pno : pno,
				            review :  $("#review_text_"+result.userNo).val(),
				          },
				          success : function(result) {
				            if (result.status == "failure") {
				            	swal("댓글 수정에 실패했습니다.", " ", "warning");
				            	location.href = "detail.html?no="+pno;
				            }
				          }
				      });
					$("#review_text_"+result.userNo).attr("readonly","readonly");
				}
			});
			$("#review_delete_"+result.userNo).click(function() {
				
				swal({   
					title: "댓글 삭제",   
					text: "댓글을 삭제하시겠습니까?",   
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
						      $.ajax("../ajax/userreview/delete.do?", {
						          method : "POST",
						          dataType : "json",
						          data : {
						            pno : pno
						          },
						          success : function(result) {
						            if (result.status == "failure") {
						            	swal("댓글 삭제에 실패했습니다.", " ", "warning");
						            } else {
						            	location.href = "detail.html?no="+pno;
						            }
						          }
						      });

						} 
					});
			});
		}
	})
});

