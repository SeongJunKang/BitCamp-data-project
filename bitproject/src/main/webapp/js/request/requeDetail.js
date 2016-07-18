var no = location.href.split("=")[1];

  $.getJSON("../ajax/request/detail.do?req=" + no, function(result) {
    var span = $
      $("#fNo").val(result.req);
      $("#date").text(result.date);
      $("#conts").text(result.conts);
      $("#answer1").text(result.res);
      $("#answer2").text(result.neut);
      $("#answer3").text(result.anifd);
      $("#answer4").text(result.manfd);
      $("#answer5").text(result.bark);
      $("#answer6").text(result.diz);
      $("#answer7").text(result.meal);
      $("#answer8").text(result.train);
      
  });
  



$("#acceptBtn").click(function(event) {
  $.ajax("../ajax/request/update.do", {
    method: "POST",
    dataType: "json",
    data: {
      req: $("#fNo").val(), 
      stat: "수락"
    },
    success: function(result) {
      if (result.status == "success") {
        location.href = "poprequest.html";
      } else {
        window.alert("변경 실패입니다!");
      }
    },
    error: function() {
      window.alert("서버 요청 실패입니다!");
    }
  });
});


$("#deleteBtn").click(function(event) {
  $.getJSON("../ajax/request/delete.do?no=" + no, function(result) {
      if (result.status == "success") {
        location.href = "board.html";
      } else {
        window.alert("삭제 실패입니다!");
      }
  });
});

$("#listBtn").click(function(event) {
          location.href = "poprequest.html";

  });


$("#addBtn").click(function(event) {
  $.post("../ajax/request/add.do", {
      title: $("#fTitle").val(),
      content: $("#fContent").val()
    }, function(result) {
      if (result.status == "success") {
        location.href = "board.html";
      } else {
        window.alert("등록 실패입니다!");
      }
    }, "json"
  );
});