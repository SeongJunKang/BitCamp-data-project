/**
 * 
 */
$(document).ready(function() {
  $.getJSON("../ajax/request/petrequestlist.do", function(result) {
      var templateData = $('#temp1').html(); 
      var template = Handlebars.compile(templateData);
      var html = template(result);  
      $("#requestTable tbody").append(html);
  });
})

function onclickDetail(event) {  
  location.href = "requeDetail.html?req=" + event.target.getAttribute("data-no");
  event.preventDefault(); // 원래 a 태그의 행위를 막는다.
}