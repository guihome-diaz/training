// =============================================================================
//                                JQuery  summary
//==============================================================================


// ======== Wait for HTML DOM to be loaded ========
jQuery(document).ready(function(){
    <code>
}); 


// OR 

$(document).ready(function(){
    <code>
}); 



// ======== Selector ========

// Get full element
jQuery("h1");   ==    $("h1");				// Get by HTML tag(s)
                      $("p span");
                      $("#myId");			// Get by element ID
                      $(".myClass");		// Get by element class



// To count the number of elements
$("li").length;



// ======== Searching the DOM ========
// Use 'traversing' when you can: it's faster on runtime!

// Children selection
$("#myId li");			// Get all 'li' within the #myId (including N children)
$("#myId > li");		// Get direct child 'li' of #myId
$("#myId li:first");	// Get first child 'li' of #myId
$("#myId li:last");		// Get last child 'li' of #myId
$("#myId li:odd");		// Get odd indexs of 'li' (1,3,5,7,...)
$("#myId li:even");		// Get even indexs of 'li' (0,2,4,6,8,...)

// Multiple selection: use ',' operator
$(".france, #myId");	// Select both #myId and .france



// ======== Traversing the DOM ========
$("#myId").find("li");						// Get all 'li'
$("#myId").find("li").first();	
$("#myId").find("li").first().next();		// Get the 2nd element
$("#myId").find("li").last();
$("#myId").children("li");					// Get direct child


$("li").first().parent();				// Get parent's of 1st 'li'

$(".vacation").filter(".onSale");		// Only return elements .vacation.onSale



// Get element content 
$("h1").text();
$(".myField").val();

// Set element content 
$("h1").text("my text");
$(".myField").val("my value");



// ======== Manipulating the DOM ========

// Search and THEN update with value: before() | after() | prepend() | append()
// Get value and THEN search: insertBefore() | insertAfter()
//							  prependTo() | appendTo()


// DOCUMENT
$(".vacation").before(myValue);
myValue.insertBefore($(".vacation"));

//	li class="vacation"
		$(".vacation").prepend(myValue);		// Add something as 1st child
		myValue.prependTo($(".vacation"));
// 		h2
//			"Hawaiian vacations"
//		button
//			"Get prixe"
		$(".vacation").append(myValue);			// Add something as last child
		myValue.appendTo($(".vacation"));

$(".vacation").after(myValue);
myValue.insertAfter($(".vacation"));



// ======== Listen for click ========

$(".myButton").on('click', "button", function() {			// Child listener
$(".myButton").on('click', function() {						// Global listener
	// Code to execute

	// To access the current object:   
	$(this)

	// To get the top div by class or id:
	$(this).closest('.myClass')
	// !! If you use "parent()" then you become dependent on the DOM 
	//    + it might not always work...	

});


// ---- Listen for click on an AJAX content
// When you listen for a click on something that will be loaded later
// you cannot make a hard reference to it on the left part! 
// As the content does NOT exist when page is loaded the 1st time, you must
// use a trick.

// Assumption:
// <a href="#" class=".view-boarding-pass">...</a> is loaded through AJAX call.

// BAD [this will not work]
$('.confirmation .view-boarding-pass').on('click', function(){...});

// GOOD
$('.confirmation').on('click', '.view-boarding-pass', function(){...});




// ======== Listen for keyboard event ========

$(".vacation").on('keyup', ".quantity", function() { ... });



// ======== jQuery and HTML bind ========

<li class="myClass" data-price="$399.99"> ... </li>

// !! jQuery can bind all ' data-* ' elements on a page !!
//    .data(<dataName>,<value>);
	  var amount = $("li").data('price');
	  $("li").data('price', "$999");



// ======== jQuery hide | display content ========

.slideDown();			// To HIDE content
.slideUp();				// To SHOW content
.slideToggle();			// To switch between the 2 states


.fadeIn();
.fadeOut();
.fadeToggle();

// You can also use the .show() and .hide() to switch between CSS without effects
// "display:block" to "display:none"
.show();
.hide();

// You can also add a speed argument in all of these methods
// default speed=400ms | 'fast'=200ms | 'slow'=600ms



// ======== jQuery and function args ========

// 1.Functions should be declared above the document.ready
// 2.Function as argument do NOT need parentheses, otherwise it will be an 
//   immediate execution.

function showTicket() {
	$(this).closest(".confirmation").find(".ticket").slideToggle();
}
$(document).ready(function() {
	$(".confirmation").on("click", 'button', showTicket); 
});



// ======== Manage event propagation | do NOT redirect to the top of the page ========

$(document).ready(function() {
	$(".confirmation").on("click", 'button', function(event) {
		// Do NOT redirect to the top of the page if the link is <a href='#'>...</a>
		event.preventDefault();
		
		// Do NOT call the other events (= end process)
		event.stopPropagation();		
		...
	});	
});

// Example of use
$(document).ready(function() {
	$(".see-photos").on("click", function(event) {
		event.stopPropagation();
		event.preventDefault();
		$(this).closest(".tour").find(".photos").slideToggle();
	});
	
	$(".tour").on("click", function() {
		alert("This should not be called");
	});
});



// ======== CSS class ========

// Check if the selection has a specific class
.hasClass(<class>)   			// return boolean

// ---- GOOD way to do it
$(".myClass").addClass(<class>);
$(".myClass").removeClass(<class>);
$(".myClass").toggleClass(<class>);
	
	
// ------ !! BAD: CSS in JavaScript !! ------
// jQuery can set some CSS attributes and values
.css(<attr>, <value>);
.css(<object>);

// [VERY BAD] set attributes through method chain
$(document).ready(function() {
	$(".see-photos").on("click", function(event) {		
		$(this).css('background-color', '#252b30');
		$(this).css('border-color', '1px solid #967');
	});
});

// [BETTER but BAD still] set attributes through object
$(document).ready(function() {
	$(".see-photos").on("click", function(event) {		
		$(this).css({'background-color': '#252b30',
		'border-color': '1px solid #967'});
	});
});



// ======== CSS animations ========

// ----- GOOD way -----
// Set CSS attribute for transitions:
.vacation {
	/* Old browsers and specifics */
	-moz-transition: top 0.2s;
	-o-transition: top 0.2s;
	-webkit-transition: top 0.2s;
	/* All modern browsers */
	transition: top 0.2s;
}

// In JS use add | remove | toggle class


// ----- BAD way to do -----
$(".myClass").animate(<css object>, speed_in_ms);	
	
	// <css object> is similar to the .css() method
	// default speed=400ms | 'fast'=200ms | 'slow'=600ms


	
// ======== AJAX ========

// ------- Complete call ---------
$('.confirmation').on('click','button', function() {
	$.ajax('myURL', {
		// Request type: post, get, ...
		type: "post",
		// Expected return format: html, xml, json...
		dataType: "html",
		// JSON keys|values to send along the request
		data: { "confNum": 1234, "airCompany": $(".ticket").data("airCompany") },
		// Before sending request
		beforeSend: function() {
			// usually you should put the loading symbol over here!
			$('.confirmation').addClass('is-loading');
		},
		// Success case
		success: function(response) {
			// Here the response content is a HTML snippet
			$('.ticket').html(response).slideDown();
		},
		// Error handling
		error: function(request, errorType, errorMessage) {
			alert('Error: ' + errorType + ' with message: ' + errorMessage);
		},
		// Set timeout (in ms) before error
		timeout: 3000,
		// Finaly do something after success | error
		complete: function() {
			// usually you should remove the loading symbol over here!
			$('.confirmation').removeClass('is-loading');
		}
	});
}); 

/* Notes:
    * To run ajax: 
		$.ajax('myURL', { 
			data: {<JSON>},
			beforeSend: function() {...},
			success: function(response){...}, 
			error: function(request, errorType, errorMessage){...} ,
			timeout: <timeInMs>,
			complete: function() {...}
			}
		);
		
    * myURL can be:
		- complete 'http://mydomain.com/mySite/confirmation.html' 
		- relative (if you are on the same domain + root URL) 'confirmation.html'
		
	* You can retrieve data dynamically if the HTML item has a jQuery <div data-XXX=""> attribute
		ex: <div class="ticket" data-airCompany="Air China">...</div>
*/



// ------- Simpler call (only success handling)---------

// Instead of $.ajax(...) you can use:   $.get('url', success);

$('.confirmation').on('click', 'button', function() {
	$.get('myURL', function(response) {
		// Here the response content is a HTML snippet
		$('.ticket').html(response).slideDown();
	});
}); 





