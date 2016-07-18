     function checkEmail() {
         var regex_email =  /[a-z0-9]{2,}@[a-z0-9-]{2,}.[a-z0-9]{2,}/i;
           if ( regex_email.test($("#email").val()) ) {
               $.ajax("../ajax/member/checkemail.do?", {
                   method : "POST",
                   dataType : "json",
                   data : {
                    email : $("#email").val()
                  },success : function(result) {
                    if (result.status == "success") {
                      $("#checkresult").html("사용가능합니다.");
                      $("#checkresult").css("color","green");
                      $("#email").attr("data-state","ok");
                    } else if ( result.status == "failure") {
                    	$("#email").attr("data-state","no");
                      $("#checkresult").html("중복된 아이디로 사용불가능합니다.")
                      $("#checkresult").css("color","red");
                    }
                  }
               });
           } else {
        	   $("#email").attr("data-state","no");
             $("#checkresult").html("이메일 형식이여야 합니다..")
             $("#checkresult").css("color","red");
           }
       }