$(function() {
   $.ajax("../auth/getMemberNo.do?", {
      method : "POST",
      async : false,
      success : function(result) {
         if (result.status == "success") {
            sessionStorage.setItem("mno", result.mno);
         }
      }
   });
   $.getJSON("../ajax/member/detail.do?", function(result) {
      $("#agc").val(result.agc).attr("selected", "selected");
      sessionStorage.setItem("gra", result.gra);
      if (result.eauth == "인증") {
           $("#emailrequest").css("display","none");
            $("#complete").css("display","");
      }
      if (result.gra == 2) {
         $(".grade2").css("display", "");
         $(".grade1").css("display", "none");
         $.getJSON("../ajax/petsitter/petmypage.do?", function(result2) {
            $("#nickname").val(result2.nick);
            $("#price").val(result2.amt);
            $("#kakao").val(result2.ktalk);
            $("#bank").val(result2.bank);
            $("#holder").val(result2.bknm);
            $("#account").val(result2.acc);
            $("#bank").val(result2.bank);
            $("#region").val(result2.reg);
            $("#hospital").val(result2.hospital);
            $("#animal").val(result2.pet);
            $("#addr1").val(result2.addr_1);
            $("#addr2").val(result2.addr_2);
            $("#intro").val(result2.intro);
            var inqur = result2.inqur.split("~");
            var inqur1 = inqur[0].split("시");
            var inqur2 = inqur[1].split("시");
            $("#inqur1").val(inqur1[0]);
            $("#inqur2").val(inqur2[0]);
            if (result2.ser)
            	var service = result2.ser.split(",");
            for ( var i in service) {
               if ($("#box1").val() == service[i]) {
                  $("#box1").prop("checked", true)
               } else if ($("#box2").val() == service[i]) {
                  $("#box2").prop("checked", true)
               } else if ($("#box3").val() == service[i]) {
                  $("#box3").prop("checked", true)
               } else if ($("#box4").val() == service[i]) {
                  $("#box4").prop("checked", true)
               } else if ($("#box5").val() == service[i]) {
                  $("#box5").prop("checked", true)
               }
            }
            $("#lat").val(result2.lat);
            $("#lnt").val(result2.lnt);
            sessionStorage.setItem("lat", result2.lat);
            sessionStorage.setItem("lnt", result2.lnt);
            sessionStorage.setItem("rad", result2.rad);
         })
      } else {
         $(".grade1").css("display", "");
         $(".grade2").css("display", "none");
      }
      $("#name").attr("value", result.name);
      $("#email").attr("value", result.email);
      var phoneNum = result.tel.split('-');
      $("#phone1").val(phoneNum[0]);
      $("#phone2").val(phoneNum[1]);
      $("#phone3").val(phoneNum[2]);
      if (!result.prof)
         result.prof = "img/default_img.jpg";
      $(".img-wrapper").css('background',
            'url(' + "../" + result.prof + ') no-repeat center center')
            .css('background-size', 'cover');
   });

});