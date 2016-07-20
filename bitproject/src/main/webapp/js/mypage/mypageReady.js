/**
 * 
 */

function goMain(event) {
   location.href = "../main/index.html"
   event.preventDefault();
}
$('#keyword').keyup(function(e) {
   if (e.keyCode == 13) {
      searchPlaces();
   }
});
$(document).ready(function() {
	
	$("#complete").css("display","none");
   $(".grade1").css("display", "none");
   $(".grade2").css("display", "none");
   $("#logout").click(function() {
      location.href = "../auth/logout.do";
      event.preventDefault();
   });
   $("#inquiry").click(function() {
      location.href = "inquiry.html";
      event.preventDefault();
   });
   $("#changeName").click(function() {
      if ($("#name").attr("readonly")) {
         $("#name").removeAttr("readonly");
      } else {
         $("#name").attr("readonly", "readonly");
      }
   });

   $("#resist").click(function(event) {
	   $.getJSON("../ajax/member/detail.do?", function(result) {
		      if (result.eauth == "인증") {
		    	  location.href = "../resist/resist.html";
		      } else {
		    	  swal("이메일 인증","도그워커에 등록하려면 이메일 인증해야 합니다..", "error");
		      }
		   });
	   location.href = "../resist/resist.html";
      event.preventDefault();
   });
     $("#emailrequest").click (function() {
         $("#emailrequest").text("다시 보내기");
       $.getJSON("../email/auth.do", function(result) {
          $("#emailAuthSpan").text(result.status);
       });
     });
});