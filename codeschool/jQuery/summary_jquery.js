// =============================================================================
//                                JQuery  summary
//==============================================================================


// ======== Wait for HTML DOM to be loaded ========
jQuery(document).ready(function(){
    <code>
}); 



// ======== Selector ========

// Get full element
jQuery("h1");   ==    $("h1");				// Get by HTML tag(s)
                      $("p span");
                      $("#myId");			// Get by element ID
                      $(".myClass");		// Get by element class

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

// Set element content 
$("h1").text("my text");


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



// ======== CSS changes ========
$(".myClass").addClass(<class>);
$(".myClass").removeClass(<class>);



// ======== Watch for click ========

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


// ======== jQuery and HTML bind ========

<li class="myClass" data-price="$399.99"> ... </li>

// !! jQuery can bind all ' data-* ' elements on a page !!
//    .data(<dataName>,<value>);
	  var amount = $("li").data('price');
	  $("li").data('price', "$999");



