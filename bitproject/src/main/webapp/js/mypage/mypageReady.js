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
   $(".grade1").css("display", "none");
   $(".grade2").css("display", "none");
   $("#dialog-confirm").css("display", "none");
   $("#dialog-confirm2").css("display", "none");
   $("#dialog-confirm3").css("display", "none");
   $("#dialog-deletef").css("display", "none");
   $("#dialog-deletec").css("display", "none");
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