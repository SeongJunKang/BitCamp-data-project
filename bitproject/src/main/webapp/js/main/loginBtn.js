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
				$(function() {
                 $( "#dialog-login-fail" ).dialog({
                   resizable: false,
                   height:200,
                   show: {
                       effect: "blind",
                       duration: 500
                     },
                     hide: {
                       effect: "fadeOut",
                       duration: 500
                     },
                   width:400,
                   modal: true,
                   buttons: {"확인": function() {
                     $( this ).dialog( "close" );
                     }}
                 });
				});
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