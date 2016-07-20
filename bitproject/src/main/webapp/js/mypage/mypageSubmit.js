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
         		swal({   
        			title: "회원 정보 변경",   
        			text: "회원 정보를 변경하였습니다.",   
        			type: "success",   
        			showCancelButton: false,   
        			confirmButtonText: "확인",   
        			closeOnConfirm: false,   
        			closeOnCancel: false 
        			}, 
        			function(isConfirm) {   
        				if (isConfirm) {  
        					location.href = "mypage3.html";
        				} 
        			});
               } else {
            	   swal("회원정보 변경 실패","회원 정보를 변경하지못했습니다", "error");
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
              		swal({   
            			title: "회원 정보 변경",   
            			text: "회원 정보를 변경하였습니다.",   
            			type: "success",   
            			showCancelButton: false,   
            			confirmButtonText: "확인",   
            			closeOnConfirm: false,   
            			closeOnCancel: false 
            			}, 
            			function(isConfirm) {   
            				if (isConfirm) {  
            					location.href = "mypage3.html";
            				} 
            			});
                   } else {
                	  swal("회원정보 변경 실패","회원 정보를 변경하지못했습니다", "error");
                    }
                  },
                  error : function() {
                	  swal("서버요청 실패입니다.", " ", "warning");
                  }
	           });
	    	    }
           }
	     });     
	     return false;     
	});