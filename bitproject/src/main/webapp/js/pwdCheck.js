     function pwdCheck() {
    	   var upw = $("#password").val();
         var regex_pwd = /^[A-Za-z0-9]{4,10}$/i;
         var chk_num = upw.search(/[0-9]/i); 
         var chk_eng = upw.search(/[A-Za-z]/i);
         if ( regex_pwd.test(upw)) {
            if ( upw != $("#passwordcheck").val() ) {
              $("#checkText").html("비밀번호가 일치하지 않습니다.")
              $("#checkText").css("color","red");
            } else {
              if(chk_num < 0 || chk_eng < 0) {
                $("#checkText").html("영문,숫자 혼합 4~10자로 만들어야합니다.")
                $("#checkText").css("color","red");
              } else {
                $("#checkText").html("비밀번호가 일치합니다.")
                $("#checkText").css("color","green");
              }
            }
         } else {
            $("#checkText").html("영문,숫자 혼합 4~10자로 만들어야합니다.")
            $("#checkText").css("color","red");
         } 
       }