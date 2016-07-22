/**
 *mypageimg
 */
function maskImgs() {
   // $('.img-wrapper img').imagesLoaded({}, function() {
   $.each($('.img-wrapper img'), function(index, img) {
      var src = $(img).attr('src');
      var parent = $(img).parent();
      parent.css('background', 'url(' + src + ') no-repeat center center')
            .css('background-size', 'cover');
      $(img).remove();
   });
   // });
}
var preview = {
   init : function() {
      preview.setPreviewImg();
      preview.listenInput();
   },
   setPreviewImg : function(fileInput) {
      var path = $(fileInput).val();
      var uploadText = $(fileInput).siblings('.file-upload-text');
      if (!path) {
         $(uploadText).val('');
      } else {
         path = path.replace(/^C:\\fakepath\\/, "");
         $(uploadText).val(path);
         preview.showPreview(fileInput, path, uploadText);
      }
   },
   showPreview : function(fileInput, path, uploadText) {
      var file = $(fileInput)[0].files;

      if (file && file[0]) {
         var reader = new FileReader();

         reader.onload = function(e) {
            var previewImg = $(fileInput).parents('.file-upload-wrapper')
                  .siblings('.preview');
            var img = $(previewImg).find('img');

            if (img.length == 0) {
               $(previewImg).html(
                     '<img src="' + e.target.result + '" alt=""/>');
            } else {
               img.attr('src', e.target.result);
            }
            uploadText.val(path);
            maskImgs();
         }
         reader.onloadstart = function() {
            $(uploadText).val('uploading..');
         }
         reader.readAsDataURL(file[0]);
      }
   },
   listenInput : function() {
      $('.file-upload-native').on('change', function() {
         preview.setPreviewImg(this);
      });
   }
};
preview.init();
$.ajax({
   url : "../ajax/upphoto/mylist.do",
   dataType : "json",
   success : function(result) {
      var templateData = $("#reviewImg").html();
      var template = Handlebars.compile(templateData);
      var html = template(result);
      $("#gallery").append(html);
   }
})
$('#gallery').photobox('a', {
   thumbs : true,
   loop : false
}, callback);
//using setTimeout to make sure all images were in the DOM, before the history.load() function is looking them up to match the url hash
setTimeout(window._photobox.history.load, 2000);
function callback() {
   console.log('callback for loaded content:', this);
};