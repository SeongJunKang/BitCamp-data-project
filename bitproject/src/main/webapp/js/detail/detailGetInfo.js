$(function(){
	var pno = location.href.split("=")[1]; 
    $.getJSON("../ajax/petsitter/detail.do?no="+pno, 
            function(result) {
              if ( result.status =="success") {
              	if(result.lat) {
             	 $("#walkrange").css("display","");
             	 $(".map_wrap").css("display","");
             	 var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                  mapOption = {
                    center : new daum.maps.LatLng(result.lat, result.lnt, 17), // 지도의 중심좌표
                    level : 6
                  // 지도의 확대 레벨
                  };
                  // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
                  var map = new daum.maps.Map(mapContainer, mapOption);
                  var zoomControl = new daum.maps.ZoomControl();
                  map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);
                  var mapTypeControl = new daum.maps.MapTypeControl();
                  map.addControl(mapTypeControl, daum.maps.ControlPosition.TOPRIGHT);

                  //****************************************************************************
                  var circle = new daum.maps.Circle({
                    center : new daum.maps.LatLng(result.lat, result.lnt, 17), // 원의 중심좌표 입니다 
                    radius : result.rad, // 미터 단위의 원의 반지름입니다 
                    strokeWeight : 5, // 선의 두께입니다 
                    strokeColor : '#75B8FA', // 선의 색깔입니다
                    strokeOpacity : 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                    strokeStyle : 'solid', // 선의 스타일 입니다
                    fillColor : '#CFE7FF', // 채우기 색깔입니다
                    fillOpacity : 0.5
                  // 채우기 불투명도 입니다   
                  });
                  // 지도에 원을 표시합니다 
                  circle.setMap(map);
              	}
                  //********************************************************************************
                  $("#titlesen").html(result.reg);
                  $("#photo").attr('src',result.img);
                  $("#like").html(result.likes);
                  $("#name").html(result.nick);
                  $("#age").html(result.age);
                  $("#price").html(result.amt);
                  $("#introsen").html(result.intro);
                  $("#addr").html(result.reg);
                  $("#hospital").html(result.hospital+"분 거리");
                  $("#pet").html(result.pet +" 마리");
                  $("#petgrade").html(result.petg);
                  
                  $("#service").html(result.ser);
                  $("#inqur").html(result.inqur);
              } else {
  	           	 $("#walkrange").css("display","none");
  	           	 $(".map_wrap").css("display","none");
              }
         });
        $.getJSON("../ajax/member/getbirth.do?mno="+pno, 
           function(result) {
             if ( result.status =="success") {
               var today = new Date();
               var toyear = parseInt(today.getFullYear());
               var membirth = parseInt(new Date(result.bth).getFullYear());
               $("#age").html(toyear - membirth + 1);
             }
          });
})