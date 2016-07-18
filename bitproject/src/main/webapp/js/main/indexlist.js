      $(function() {
          $.ajax({
             url : "../ajax/petsitter/mainlist.do",
             dataType : "json",
             success : function(result) {
               var templateData = $( "#sitterlist").html();
               var template = Handlebars .compile(templateData);
               var html = template(result);
               $("#petsitter").append(html);
             }
           })
        });