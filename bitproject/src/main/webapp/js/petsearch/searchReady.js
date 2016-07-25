
  $(document).ready(function() {
	  var TagText = $(".section-subheading");
      $("#latest").click(function(event) {
              event.preventDefault();
              $("#moreNo").val(2);
              $("#petsitter").empty();
              TagText.text($("#latest").text());
              $.getJSON("../ajax/petsitter/list.do?order=latest&pageNo=1",
                      function(result) {
                        var templateData = $(
                            "#sitterlist").html();
                        var template = Handlebars
                            .compile(templateData);
                        var html = template(result);
                        $("#petsitter").append(html);
                      });
            });
  
    $("#popu").click(function() {
              event.preventDefault();
              $("#moreNo").val(2);
              $("#petsitter").empty();
              TagText.text($("#popu").text());
              $.getJSON("../ajax/petsitter/list.do?order=likes&pageNo=1",
                      function(result) {
                        var templateData = $(
                            "#sitterlist").html();
                        var template = Handlebars
                            .compile(templateData);
                        var html = template(result);
                        $("#petsitter").append(html);
                      });
            });
  
    $("#byname").click(function() {
              $("#moreNo").val(2);
              $("#petsitter").empty();
              event.preventDefault();
              TagText.text($("#byname").text());
              $.getJSON("../ajax/petsitter/list.do?order=nick&pageNo=1",
                      function(result) {
                        var templateData = $(
                            "#sitterlist").html();
                        var template = Handlebars
                            .compile(templateData);
                        var html = template(result);
                        $("#petsitter").append(html);
                      });
            });
    $("#byprice").click(function() {
              $("#moreNo").val(2);
              $("#petsitter").empty();
              event.preventDefault();
              TagText.text($("#byprice").text());
              $.getJSON("../ajax/petsitter/list.do?order=amt&pageNo=1",
                      function(result) {
                        var templateData = $(
                            "#sitterlist").html();
                        var template = Handlebars
                            .compile(templateData);
                        var html = template(result);
                        $("#petsitter").append(html);
                      });
            });
  
    $(".selected_location").click(function(event) {
      $(".pagination").empty();
      $("#select_location").text($(this).text());
      $.ajax({
        url : "../ajax/petsitter/search.do?pageNo=1",
        dataType : "json",
        data : {
          index : $("#select_location").text()
        },
        success : function(result) {
          var templateData = $("#sitterlist").html();
          var template = Handlebars.compile(templateData);
          var html = template(result);
          $("#petsitter").html(html);
          var pagingTag = $(".pagination");
        }
      })
      event.preventDefault();
    });
  
    $("#search_btn").click(function() {
      $(".pagination").empty();
      $.ajax({
        url : "../ajax/petsitter/search.do?pageNo=1",
        dataType : "json",
        data : {
          index : $("#search_input").val()
        },
        success : function(result) {
          var templateData = $("#sitterlist").html();
          var template = Handlebars.compile(templateData);
          var html = template(result);
          $("#petsitter").html(html);
          var pagingTag = $(".pagination");
        }
      })
    })
  
    $('#search_input').keyup(function(e) {
      if (e.keyCode == 13) {
        $("#search_btn").click();
      }
    });
    
    $("#more-btn").click(function() {
      switch ($(".section-subheading").text()) {
        case "최신순":
               $.getJSON("../ajax/petsitter/list.do?order=pno&pageNo="+$("#moreNo").val(),
                        function(result) {
                          var templateData = $(
                              "#sitterlist").html();
                          var template = Handlebars
                              .compile(templateData);
                          var html = template(result);
                          $("#petsitter").append(html);
                          if (result.list.length > 0) {
                            $("#moreNo").val($("#moreNo").val() * 1 + 1);
                          } else {
                                 swal("도그워커 검색","모든 도그워커를 검색했습니다.", "warning");
                               }
                        });
            break;
        case "인기순":
            $.getJSON("../ajax/petsitter/list.do?order=likes&pageNo="+$("#moreNo").val(),
                    function(result) {
                      var templateData = $(
                          "#sitterlist").html();
                      var template = Handlebars
                          .compile(templateData);
                      var html = template(result);
                      $("#petsitter").append(html);
                      if (result.list.length > 0) {
                          $("#moreNo").val($("#moreNo").val() * 1 + 1);
                      } else {
                            swal("도그워커 검색","모든 도그워커를 검색했습니다.", "warning");
                          }
                    });
            break;
        case "이름순":
               $.getJSON("../ajax/petsitter/list.do?order=nick&pageNo="+$("#moreNo").val(),
                        function(result) {
                          var templateData = $(
                              "#sitterlist").html();
                          var template = Handlebars
                              .compile(templateData);
                          var html = template(result);
                          $("#petsitter").append(html);
                           if (result.list.length > 0) {
                             $("#moreNo").val($("#moreNo").val() * 1 + 1);
                           } else {
                                 swal("도그워커 검색","모든 도그워커를 검색했습니다.", "warning");
                               }
                        });
            break;
        case "가격순":
               $.getJSON("../ajax/petsitter/list.do?order=amt&pageNo="+$("#moreNo").val(),
                        function(result) {
                          var templateData = $(
                              "#sitterlist").html();
                          var template = Handlebars
                              .compile(templateData);
                          var html = template(result);
                          $("#petsitter").append(html);
                           if (result.list.length > 0) {
                             $("#moreNo").val($("#moreNo").val() * 1 + 1);
                             } else {
                               swal("도그워커 검색","모든 도그워커를 검색했습니다.", "warning");
                             }
                        });
            break;
        default:
            break;
      }
    })
  })
  
    

  function ready() {
	  var TagText = $(".section-subheading");
      $("#moreNo").val(2);
      $("#petsitter").empty();
      TagText.text($("#latest").text());
      $.getJSON("../ajax/petsitter/list.do?order=pno&pageNo=1",
              function(result) {
                var templateData = $(
                    "#sitterlist").html();
                var template = Handlebars
                    .compile(templateData);
                var html = template(result);
                $("#petsitter").append(html);
              });
  }
  ready();