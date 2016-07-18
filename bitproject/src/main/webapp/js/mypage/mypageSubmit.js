/**
 * 
 */
  $("#savebtn").click(function(event){    
	     //disable the default form submission
	     event.preventDefault();      
	     var fd = new FormData($("#frm")[0]);  
	     $.ajax({
	       url: "../ajax/member/upload.do?",
	       type: "POST",
	       data: fd,
	       async: false,
	       cache: false,
	       contentType: false,
	       processData: false,
	       success:  function(result) {
	    	   if (sessionStorage.getItem("gra") == 1) {
	    		   sessionStorage.removeItem("gra");
             if (result.status == "success") {
                     $( "#dialog-confirm2" ).dialog({
                       resizable: false,
                       height:180,
                       width:300,
                       show: {
                           effect: "blind",
                           duration: 500
                         },
                         hide: {
                           effect: "fadeOut",
                           duration: 500
                         },
                       modal: true,
                       buttons: {"확인": function() {
                         $( this ).dialog( "close" );
                         location.href = "mypage3.html"
                         }}
                     });
               } else {
                    $( "#dialog-confirm3" ).dialog({
                      resizable: false,
                      height:180,
                      width:300,
                      show: {
                          effect: "blind",
                          duration: 500
                        },
                        hide: {
                          effect: "fadeOut",
                          duration: 500
                        },
                      modal: true,
                      buttons: {"확인": function() {$( this ).dialog( "close" );}
                      }
                    });
                }
	    	   } else if (sessionStorage.getItem("gra") == 2) {
	    		   sessionStorage.removeItem("gra");
	           $.ajax({
	             url: "../ajax/petsitter/upload.do?",
	             type: "POST",
	             data: fd,
	             async: false,
	             cache: false,
	             contentType: false,
	             processData: false,
	             success : function(result) {
                 if (result.status == "success") {
                     $(function() {
                         $( "#dialog-confirm2" ).dialog({
                           resizable: false,
                           height:180,
                           width:300,
                           show: {
                               effect: "blind",
                               duration: 500
                             },
                             hide: {
                               effect: "fadeOut",
                               duration: 500
                             },
                           modal: true,
                           buttons: {"확인": function() {
                        	   $( this ).dialog( "close" );
                        	   location.href = "mypage3.html"
                        	   }}
                         });
                       });
                   } else {
                     $(function() {
                        $( "#dialog-confirm3" ).dialog({
                          resizable: false,
                          height:180,
                          width:300,
                          show: {
                              effect: "blind",
                              duration: 500
                            },
                            hide: {
                              effect: "fadeOut",
                              duration: 500
                            },
                          modal: true,
                          buttons: {"확인": function() {$( this ).dialog( "close" );}
                          }
                        });
                      });
                    }
                  },
                  error : function() {
                    window.alert("서버요청 실패입니다.");
                  }
	           });
	    	    }
           }
	     });     
	     return false;     
	});