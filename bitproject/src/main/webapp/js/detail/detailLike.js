$(function(){
	var pno = location.href.split("=")[1]; 
	
        $.getJSON("../ajax/likes/byno.do?pno="+pno, 
          function( result) {
            if ( result.status =="success") {
                $(".heart").css("background-position", "right");
                $(".heart").attr("data-state", "after");
            }
        });
        
    	$(".heart").on('animationend', function(){
    		if (sessionStorage.getItem("login")) {
    			var state = $(".heart").attr("data-state");
            if (state == "before") {
              $(".heart").css("background-position", "right");
              $(".heart").attr("data-state", "after");
              $("#like").html($("#like").html() * 1 + 1);
              $.ajax("../ajax/likes/add.do?", {
                method : "POST",
                dataType : "json",
                data : {
                  pno : pno
                }});
              $(this).toggleClass('is_animating');
            } else {
            	$(".heart").css("background-position", "left");
        	  $(".heart").attr("data-state", "before");
              $("#like").html($("#like").html() * 1 - 1); 
              $.ajax("../ajax/likes/delete.do?", {
                method : "POST",
                dataType : "json",
                data : {
                  pno : pno
                }});
              $(this).toggleClass('is_ranimating');
            }
            $.ajax("../ajax/petsitter/like.do?", {
                method : "POST",
                dataType : "json",
                data : {
                  pno : pno,
                  likes : $("#like").html() 
                }});
          }
  		});
    	$(".heart").on('click touchstart', function(){
    		if (sessionStorage.getItem("login")) {
    			var state = $(".heart").attr("data-state");
    			if (state == "before") {
    				$(this).toggleClass('is_animating');
    			} else {
    				$(this).toggleClass('is_ranimating');
    			}
    		}else {    		
                swal("로그인 해야 이용할 수 있습니다.", " ", "warning");
            }
  		});

})