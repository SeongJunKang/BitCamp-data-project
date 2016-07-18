$(function(){
	var pno = location.href.split("=")[1]; 
        $.getJSON("../ajax/likes/byno.do?pno="+pno, 
          function( result) {
            if ( result.status =="success") {
                heart.setAttribute("src", "../img/detail/web_heart_animation2.png");
                heart.setAttribute("data-state", "after");
            }
        });
        var heart = document.getElementById("heart");
        heart.onclick = function() {
          if (!sessionStorage.getItem("login")) {
              window.alert("로그인 해야 이용할 수 있습니다.");
          } else {
            var state = heart.getAttribute("data-state");
            if (state == "before") {
              heart.setAttribute("src", "../img/detail/web_heart_animation2.png");
              heart.setAttribute("data-state", "after");
              $("#like").html($("#like").html() * 1 + 1);
              $.ajax("../ajax/likes/add.do?", {
                method : "POST",
                dataType : "json",
                data : {
                  pno : pno
                }});
            } else {
              heart.setAttribute("data-state", "before");
              heart.setAttribute("src", "../img/detail/web_heart_animation1.png");
              $("#like").html($("#like").html() * 1 - 1);
              $.ajax("../ajax/likes/delete.do?", {
                method : "POST",
                dataType : "json",
                data : {
                  pno : pno
                }});
            }
            $.ajax("../ajax/petsitter/like.do?", {
                method : "POST",
                dataType : "json",
                data : {
                  pno : pno,
                  likes : $("#like").html() 
                }});
          }
        }
})