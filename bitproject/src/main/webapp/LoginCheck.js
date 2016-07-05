/**
 * 
 */
$(function() {
	$.ajax("../auth/loging.do?", {
		method : "POST",
		success : function(result) {
			if (result.status == "success") {
				$(".not_login").css("display","none")
				$(".login").css("display","")
			} else if ( result.status == "failure") {
				$(".login").css("display","none")
				$(".not_login").css("display","")
			}
		}
	});
})
$(function() {
	 $.ajax("../auth/loging.do?", {
	    method : "POST",
	    success : function(result) {
	      if (result.status == "success") {
	    	  $("#userreview").attr("placeholder","후기를 남겨주세요.")
	    	  $("#userreview").removeAttr("readonly");
	      } else if ( result.status == "failure") {
	    	  $("#userreview").attr("placeholder","로그인 후 이용이 가능합니다.");
	    	  $("#userreview").attr("readonly","readonly");
	      }
	    }
	  });
})