      $(function() {
          var today = new Date();
          var toyear = parseInt(today.getFullYear());
          var end = toyear - 100;
          var year = $("#birthdayYear");
          var month = $("#birthdayMonth");
          var day = $("#birthdayDay");
          
          for (i = toyear; i >= end; i--)
            $("<option>").html(i).appendTo(year);
          for (i = 1; i <= 12; i++)
            $("<option>").html(i).appendTo(month);
          for (i = 1; i <= 31; i++)
            $("<option>").html(i).appendTo(day);

          $(".gender").click(function() {
            if ($(this).html() == "남성") {
              $(this).html("여성");
            } else {
              $(this).html("남성");
            }
          });
          $("input").focusin(function() {
            $(this).css("background-color", "#FAFFBD")
          });
          $("input").focusout(function() {
            $(this).css("background-color", "#ffffff")
          });
      });
      