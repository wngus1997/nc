/**
 * 가이드 페이지
 */
 
$(document).ready(function () {
 
 	$(document).on("click","#TypeA",function(){
 		
 		$('.Type1Guide').fadeIn('fast');
	    $('.Type2Guide').fadeOut('fast');
	    $('.Type3Guide').fadeOut('fast');
		/*$(".Type1Guide").css("display", "");
        $(".Type2Guide").css("display", "none");*/
	});
	
	$(document).on("click","#TypeB",function(){
	
 		$('.Type1Guide').fadeOut('fast');
	    $('.Type2Guide').fadeIn('fast');
	    $('.Type3Guide').fadeOut('fast');
		/*$(".Type1Guide").css("display", "none");
        $(".Type2Guide").css("display", "");*/
	});
	
	$(document).on("click","#TypeC",function(){
	
 		$('.Type1Guide').fadeOut('fast');
	    $('.Type2Guide').fadeOut('fast');
	    $('.Type3Guide').fadeIn('fast');
		/*$(".Type1Guide").css("display", "none");
        $(".Type2Guide").css("display", "");*/
	});
	
		$(document).on("click","#TypeD",function(){
			status = $(".TypeBoxGuide").css("display");
			
 			if (status == "none"){
 				$('.TypeBoxGuide').fadeIn('fast');
 			}else{
 				$('.TypeBoxGuide').fadeOut('fast');
 			}
	});
 	
 });