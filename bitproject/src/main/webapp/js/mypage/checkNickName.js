$(function() {
	$("#checknick").click(function() {
		if($("#checknick").attr("data-state") == "no") {
			$.ajax("../ajax/petsitter/checknick.do?", {
				method : "POST",
				dataType : "json",
				data : {
					nick : $("#nickname").val()
				},success : function(result) {
					if (result.status == "success") {
						$("#nickstate").text("사용가능한 닉네임 입니다.");
						$("#nickstate").css("color","green");
						$("#checknick").attr("data-state","ok");
						$("#nickname").attr("readonly","readonly");
						$("#checknick").text("닉네임 변경");
					} else if ( result.status == "failure") {
						$("#nickname").removeAttr("readonly");
						$("#nickstate").text("다른 사람이 이미 사용중입니다.");
						$("#nickstate").css("color","red");
						$("#checknick").attr("data-state","no");
						$("#checknick").text("중복 체크");
					}
				}
			});
		} else {
			$("#nickname").removeAttr("readonly");
			$("#checknick").text("중복체크");
			$("#checknick").attr("data-state","no");
		}
	})
	
})