$(document).ready(function() {
  $(".fo").click(function() {
    $(".form-menu-child").hide();
    $(this).find(".form-menu-child").show();
  });
  $(".form-menu-trang-chu").click(function() {
    $(".show-item").hide();
    $("#trang-chu").show();
  });
  $(".form-menu-child").click(function(event) {
    event.stopPropagation();
  });
  $(".menu-child").click(function(event) {
    event.stopPropagation();
    var showItemId = $(this).data("show-item");
    $(".show-item").hide();
    $("#" + showItemId).find(".show-item").show();
  });
});
$(".form-menu-trang-chu").click(function() {
  $(".show-item").hide();
  $("#trang-chu").show();
});
$(".btn-add-product").click(function() {
  $('#addProductModal').modal('show');
});

