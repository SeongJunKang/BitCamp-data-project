      $(function() {
          $.ajax("../auth/loging.do?", {
              method : "POST",
              success : function(result) {
                if ( result.status == "failure") {
                  location.href = "../main/index.html";
               }
             }
          });
       })