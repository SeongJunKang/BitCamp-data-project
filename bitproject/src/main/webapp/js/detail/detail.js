$(document).ready(function() {
	$("#walkrange").css("display", "none");
	$(".map_wrap").css("display", "none");
	$("#mypage").click(function() {
		location.href = "../mypage/mypage3.html"
	});
	$("#logout").click(function() {
		location.href = "../auth/logout.do";
	});
	$(window).load(function() {
		$('#loading').hide();
	});
	$.ajax("../auth/getMemberNo.do?", {
		method : "POST",
		success : function(result) {
			if (result.status == "success") {
				sessionStorage.setItem("mno", result.mno);
			}
		}
	});
	$.ajax("../ajax/request/accrue.do?", {
		method : "POST",
		dataType : "json",
		data : {
			pno : location.href.split("=")[1]
		},
		success : function(result) {
			if (result.status == "success") {
				$("#accrue").text("누적신청 : "+result.accrue);
			}
		}
	});
	
	$.ajax("../ajax/upphoto/list.do", {
		method : "POST",
		dataType : "json",
		data : {
			pno : location.href.split("=")[1]
		},
		success : function(result) {
			if (result.list.length > 0) {
		         var templateData = $( "#reviewImg").html();
		         var template = Handlebars .compile(templateData);
		         var html = template(result);
		         $("#gallery").append(html);
			} else {
				$("#walkpicture").css("display","none");
			}
		}
	});

	$("#login").click(function() {
		location.href = "../main/index.html#clients"
	});
});

function goMain(event) {
	location.href = "index.html"
}
function gotoRequest(event) {
	if (sessionStorage.getItem("login") == "success") {
		var pno = location.href.split("=")[1];
		location.href = "../request/request.html?no=" + pno;
	} else {
		swal("로그인 해야 이용할 수 있습니다.", " ", "warning");
	}
}
