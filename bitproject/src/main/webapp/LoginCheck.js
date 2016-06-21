/**
 * 
 */

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