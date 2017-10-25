$(document).ready(function($) {
	$(".page_collapsible").click(function () {
	
	    $header = $(this);
	    $span = $header.parent().find("span:first");
	    //getting the next element
	    $content = $header.next();
	    
	    if ($content.is(":visible")) {
			$header.removeClass("collapse-open");
			$span.removeClass("collapse-open-span");
			$span.addClass("collapse-close-span");
		} else {
			$header.addClass("collapse-open");
			$span.removeClass("collapse-close-span");
			$span.addClass("collapse-open-span");
		}
		//open up the content needed - toggle the slide- if visible, slide up, if not slidedown.
		$content.slideToggle(50, function() {
			//execute this after slideToggle is done
			//change text of header based on visibility of content div
			/* $header.text(function() {
				//change text based on condition
				return $content.is(":visible") ? "Collapse" : "Expand";
			}); */
	
		});
	});
});


