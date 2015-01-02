function showPhotos() {
	$(this).find("span").slideToggle();
}

$(document).ready(function(){
  var price = $('<p>From $399.99</p>');
  $("#test").after(price);

  $("#tour").on("click", "button", function() {
    $(".photos").slideToggle();
  });
  $(".photos").on("mouseenter", "li", function() {
    $(this).find("span").slideToggle();
  });
  $(".photos").on("mouseleave", "li", showPhotos);


  // Problem with that: the event always redirect to the top of the page!
  $(".vacations").on('keyup', ".quantity", function() { 
  	var price = +$(this).closest(".vacations").data('price');
  	var quantity = +$(this).val();
  	$("#total").text(price * quantity);
  });
  
  

});
