$(function() {
    $("#loginbtn").click(function() {
        $.ajax("../auth/login.do?", {
            method : "POST",
            dataType : "json",
            data : {
             email : $("#inemail").val(),
             password : $("#inpassword").val()
           },success : function(result) {
             if (result.status == "success") {
          	   location.href = "index.html"
             } else if ( result.status == "failure") {
         		swal("로그인에 실패했습니다.","등록되지않은 이메일 또는 비밀번호입니다.", "error");
             }
           }
        });
    });
    $('#inpassword').keyup(function(e) {
        if (e.keyCode == 13) {
        	$("#loginbtn").click();
        }        
    });

})   