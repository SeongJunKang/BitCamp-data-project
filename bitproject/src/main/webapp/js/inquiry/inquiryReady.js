$(document).ready(function() {
    $.getJSON("../ajax/request/myrequestlist.do", function(result) {
        var templateData = $('#temp1').html();
        var template = Handlebars.compile(templateData);
        for (var i = 0; i < result.list.length; i++) {
        	if (!result.list[i].nick)
        		result.list[i].nick="회원 탈퇴";
        }
        var html = template(result);
        $("#send").append(html);
        $(".myrequestdetail").on("click", function() {
        	var req = event.target.getAttribute("data-no");
        	  $.getJSON("../ajax/request/detail.do?req="
        		      + req, function(result) {
        		    	  if(result.pname) 
        		    		  $("#petname").html(result.pname+ "<br>");
        		    	  else 
        		    		  $("#petname").html("도그워커 탈퇴<br>");
        		    	  
        		    	  if(result.pname) 
        		    		  $("#pettel").html(result.request.p_tel+ "<br>");
        		    	  else 
        		    		  $("#petname").html("도그워커 탈퇴<br>");
        		    
        		    $("#pettalk").html(result.request.ktalk+ "<br>");
        		    $("#date1").html(result.request.date + "<br>");
        		    $("#conts1").html(result.request.conts);
        		    $("#answer1-1").html("<br>" + result.request.res);
        		    $("#answer1-2").html("<br>" + result.request.neut);
        		    $("#answer1-3").html("<br>" + result.request.anifd);
        		    $("#answer1-4").html("<br>" + result.request.manfd);
        		    $("#answer1-5").html("<br>" + result.request.bark);
        		    $("#answer1-6").html("<br>" + result.request.diz);
        		    $("#answer1-7").html("<br>" + result.request.meal);
        		    $("#answer1-8").html("<br>" + result.request.train);
        		    if (result.request.stat == "대기") {
        		      $("#inex1").dialog({
        		        resizable : false,
        		        height : 600,
        		        width : 500,
        		        modal : true,
        		        buttons : {
        		          "취소" : function() {
        		            $.ajax("../ajax/request/delete.do", {
        		              method : "POST",
        		              dataType : "json",
        		              data : {
        		                req : req
        		              },
        		              success : function(result) {
        		                if (result.status == "success") {
        		                  location.href = "inquiry.html";
        		                } else {
        		                  swal("변경 실패입니다!", " ", "error");
        		                }
        		              },
        		              error : function() {
        		                swal("서버 요청 실패입니다!", " ", "error");
        		              }
        		            });
        		            $(this).dialog("close");
        		          },
        		          "확인" : function() {
        		            $(this).dialog("close");
        		          }
        		        }
        		      }).parents(".ui-dialog").find(".ui-dialog-titlebar").remove();
        		    } else {
        		      $("#inex1").dialog({
        		        resizable : false,
        		        height : 600,
        		        width : 500,
        		        modal : true,
        		        buttons : {
        		          "확인" : function() {
        		            $(this).dialog("close");
        		          }
        		        }
        		      }).parents(".ui-dialog").find(".ui-dialog-titlebar").remove();
        		    }
        		  });
     	  })
      });
	  $.getJSON("../ajax/request/petrequestlist.do", function(result) {
		    var templateData = $('#temp2').html();
		    var template = Handlebars.compile(templateData);
		    for (var i = 0; i < result.list.length; i++) {
		    	if (!result.list[i].name)
		    		result.list[i].name="회원 탈퇴";
		    }
		    var html = template(result);
		    $("#receive").append(html);
		    $(".getrequestdetail").on("click", function() {
		         var req = event.target.getAttribute("data-no");
            $.getJSON("../ajax/request/detail.do?req="
                  + req, function(result) {
                	  if(result.mname)
                		  $("#reqname").html(result.mname+ "<br>");
                	  else 
                		  $("#reqname").html("회원 탈퇴<br>");
                	  if(result.request.m_tel)
                		  $("#reqtel").html(result.request.m_tel+ "<br>");
                	  else 
                		  $("#reqtel").html("회원 탈퇴<br>");
                $("#date2").html(result.request.date + "<br>");
                $("#conts2").html(result.request.conts);
                $("#answer2-1").html("<br>" + result.request.res);
                $("#answer2-2").html("<br>" + result.request.neut);
                $("#answer2-3").html("<br>" + result.request.anifd);
                $("#answer2-4").html("<br>" + result.request.manfd);
                $("#answer2-5").html("<br>" + result.request.bark);
                $("#answer2-6").html("<br>" + result.request.diz);
                $("#answer2-7").html("<br>" + result.request.meal);
                $("#answer2-8").html("<br>" + result.request.train);
                    $("#inex2").dialog({
                      resizable : false,
                      height : 600,
                      width : 500,
                      modal : true,
                      buttons : {
                        "수락" : function() {
                          $.ajax("../ajax/request/update.do", {
                            method : "POST",
                            dataType : "json",
                            data : {
                              req :req,
                              stat : "수락"
                            },
                            success : function(result) {
                              if (result.status == "success") {
                                location.href = "../main/index.html";
                              } else {
                                swal("변경 실패입니다!", " ", "error");
                              }
                            },
                            error : function() {
                              swal("서버 요청 실패입니다!", " ", "error");
                            }
                          });
                          $(this).dialog("close");
                        },
                        "거절" : function() {
                          $.ajax("../ajax/request/update.do", {
                            method : "POST",
                            dataType : "json",
                            data : {
                              req : req,
                              stat : "거절"
                            },
                            success : function(result) {
                              if (result.status == "success") {
                                location.href = "../main/index.html";
                              } else {
                                swal("거절 실패입니다!", " ", "error");
                              }
                            },
                            error : function() {
                              swal("서버 요청 실패입니다!", " ", "error");
                            }
                          });
                          $(this).dialog("close");
                        },
                        "목록" : function() {
                          $(this).dialog("close");
                        }
                      }
                    }).parents(".ui-dialog").find(".ui-dialog-titlebar").remove();
              });
	        })
		  });
	  
			$("#logout").click(function() {
				location.href = "../auth/logout.do";
				event.preventDefault();
			});
			$("#mypage").click(function() {
				location.href = "mypage3.html";
				event.preventDefault();
			});
			   $("#resist").click(function(event) {
				   $.getJSON("../ajax/member/detail.do?", function(result) {
					      if (result.eauth == "인증") {
					    	  location.href = "../resist/resist.html";
					      } else {
					    	  swal("이메일 인증","도그워커에 등록하려면 이메일 인증해야 합니다.", "error");
					      }
					   });
			      event.preventDefault();
			   });
			// 탭 메뉴바 설정
		    $(".tab_content").hide();
		    $(".tab_content:first").show();

		    $("ul.tabs li").click(function () {
		        $("ul.tabs li").removeClass("active").css("color", "#333");
		        //$(this).addClass("active").css({"color": "darkred","font-weight": "bolder"});
		        $(this).addClass("active").css("color", "#fff");
		        $(".tab_content").hide()
		        var activeTab = $(this).attr("rel");
		        $("#" + activeTab).fadeIn()
		    });
		    //------------
		    //멤버의 등급 가져오기
		      $.getJSON("../ajax/member/detail.do?", function(result) {
		          if (result.gra == 2) {
		            $(".grade2").css("display", "");
		            $(".grade1").css("display", "none");
		          } else {
		            $(".grade1").css("display", "");
		            $(".grade2").css("display", "none");
		          }
		        });
		    ///------------
		});