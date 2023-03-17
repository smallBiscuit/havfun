/**
 * 
 */

$(document).ready(function(){
	$('#wrapper').hide();
	$('#wrapper').fadeIn();

});

$(document).keydown(function(e) {
	
	if (e.keyCode == 13){//Enter pressed
		
	    //$('#orderConfirmForm').submit();
	
		if ( $('#fancyConfirm_ok').length > 0 ){
			$('#fancyConfirm_ok').click();
			event.preventDefault();
		}
		else if ( $('#fancyNotice_ok').length > 0 ){
			
			$('#fancyNotice_ok').click();
			event.preventDefault();
		}
		
	}else if (e.keyCode == 27) {//Esc
		if ( $('#fancyConfirm_cancel').length > 0 ){
			$('#fancyConfirm_cancel').click();
			event.preventDefault();
		}
		else if ( $('#fancyNotice_ok').length > 0 ){
			$('#fancyNotice_ok').click();
			event.preventDefault();
		}
	}
	
});


function fancyWarning(title, msg, okLabel, callbackYes) {
	var content = "";

	content += "<div style=\"margin:1px;width:300px;\">";
	content += "<div class=\"overlay_title_sell\" >"+title+"</div>";
	content += "<div class=\"overlay_content\">"+msg+"</div>";	
	
	content += "<div style=\"text-align:right;margin-top:10px;\">";	
	content += "<div id=\"fancyNotice_ok\" class=\"btn_common_sell\" style=\"float:right;margin:5px;\" >"+ okLabel + "</div>";	
	content += "</div></div>";	
	
	
	 jQuery.fancybox({
	        'modal' : true,
	        'content' : content,
	        'beforeShow' : function() {	            
	            jQuery("#fancyNotice_ok").click(function() {
	                
	            	$.fancybox.close();
	                
	                callbackYes();
	            });
	        }
	    });
}

function fancyNotice(title, msg, okLabel, callbackYes) {	
	var content = "";

	content += "<div style=\"margin:1px;width:300px;\">";
	content += "<div class=\"overlay_title\" >"+title+"</div>";
	content += "<div class=\"overlay_content\">"+msg+"</div>";	
	
	content += "<div style=\"text-align:right;margin-top:10px;\">";	
	content += "<div id=\"fancyNotice_ok\" class=\"btn_common\" style=\"float:right;margin:5px;\" >"+ okLabel + "</div>";	
	content += "</div></div>";	
	
	
	 jQuery.fancybox({
	        'modal' : true,
	        'content' : content,
	        'beforeShow' : function() {	            
	            jQuery("#fancyNotice_ok").click(function() {
	                
	            	$.fancybox.close();
	                
	                callbackYes();
	            });
	        }
	    });
}

function fancyConfirm(title, msg, okLabel, cancelLabel, callbackYes, callbackNo) {	
	
	var content = "";

	content += "<div style=\"margin:1px;width:400px;\">";
	content += "<div class=\"overlay_title\" >"+title+"</div>";
	content += "<div class=\"overlay_content\">"+msg+"</div>";	
	
	content += "<div style=\"text-align:right;margin-top:10px;\">";	

	content += "<div id=\"fancyConfirm_ok\" class=\"btn_common\" style=\"float:right;margin:5px;\" >"+ okLabel + "</div>";	
	content += "<div id=\"fancyConfirm_cancel\" class=\"btn_common\" style=\"float:right;margin:5px;\" >"+ cancelLabel + "</div>";
	
	content += "</div></div>";	
	
	
    jQuery.fancybox({
        'modal' : true,
        'content' : content,
        'beforeShow' : function() {
            jQuery("#fancyConfirm_cancel").click(function() {

            	$.fancybox.close();
                
                callbackNo();
                
            });
            
            jQuery("#fancyConfirm_ok").click(function() {
                
            	$.fancybox.close();
                
                callbackYes();
            });
        }
    });
}


function fancyLoading() {
	var content = "";

	content += "<div style=\"margin:1px;\">";
	content += "<img src=\"img/loading_animation.gif\" width=\"50px\"></img>";
	content += "</div>";
	
	
	 jQuery.fancybox({
	        'modal' : true,
	        'content' : content,
	        'width' : 50,
	        'height' : 50,
	        'minWidth' : 50,
	        'minHeight' : 50,
	        'beforeShow': function(){
//	        	  $(".fancybox-skin").css("backgroundColor","transparent");
	        }
	    });
}

function fancyLoadingHide(){
	
	jQuery.fancybox.close();
	
}

function runAjaxService( url, okLabel, successTitle, successMessage, successFunction, failTitle, failMessage, failFunction ){
	
	
	fancyLoading();
	
	$.ajax({
		  dataType: "json",
		  url: url
	  })
	  .done (function(data) {
		  
		  jQuery.fancybox.close();
		  
		  if ( data.result == 0 ){
			 
			  fancyNotice(successTitle, successMessage, okLabel, successFunction);
		  }
		  else {
			  
			  fancyWarning(failTitle, failMessage, okLabel, failFunction);
		  }		  
		  
	  }).fail(function() {
		  fancyWarning(failTitle, failMessage, okLabel, failFunction); 			
   	  });	
}

/**
 * DatePicker Revamp Common by Ray
 */
function initDatePickerWebcomponent(){
	//Form Datepicker

	
	$(".date_picker").each(function(){
		
		initDatePickerWebcomponentWithSelector( $(this) );
		
	});

}

function initTimePickerWebcomponent(){
	
	$(".time_picker").each(function(){
		
		initTimePickerWebcomponentWithSelector( $(this) );
		
	});
	
};

function initDatePickerWebcomponentWithSelector( currSelector ){
	
	var hasSwitch = false;
	
	var datePickerAlterId = currSelector.prev('.date_picker_alter').attr('id');
	
	var datePickerSwitchId = datePickerAlterId + '_switch';
	
	/////////////////////////////////////
	//id:xyz_switch
	//id:xyz xyz_alter
	//xyz
	
	//dynamic table format
	//////////////////////////////////////
	//id:xyz_switch_0
	//id:xyz xyz_alter_0
	//xyz_0
	
	var currValue = $('#' + datePickerAlterId ).val();

	if ( $('#' + datePickerSwitchId ).length ){
		
		console.log('datePickerAlterId: switch exist 1' );
		
		hasSwitch = true;
		
	} 
	else if ( $('#' + datePickerAlterId ).parent().find('.date_picker_switch').length ){
		
		console.log('datePickerAlterId: switch exist 2, previous input found with date_picker_switch ' );
		
		datePickerSwitchId = $('#' + datePickerAlterId ).parent().find('.date_picker_switch').attr('id');
		
		hasSwitch = true;
		
	}
	
	if ( hasSwitch ){
		
		if ( currValue == 0 ){
			
			$('#' + datePickerSwitchId ).prop('checked', false);
		
			updateDatePickerWithCheckbox( $('#' + datePickerSwitchId ), false );			
			
		}else{
			
			$('#' + datePickerSwitchId ).prop('checked', true );
			
			updateDatePickerWithCheckbox( $('#' + datePickerSwitchId ), true );			
			
		}
		
	}
	
	var withYearDate = currSelector.hasClass('date_picker_type_year_date');
	var displayFormatter = currSelector.data('display-formatter');
	var daysOfWeekDisabledArray = [];	//date_picker_skip_weekends
		//date_picker_skip_holidays	
	var minValue = currSelector.data('min-value');
	//var maxValue = currSelector.data('max-value');
	
	if ( currSelector.hasClass('date_picker_skip_weekends') ){
		daysOfWeekDisabledArray = [0,6];
	}	
	
	if ( minValue == null || minValue == 0 ){
		minValue = false;
	}else{
		
		minValue = serverDateToDate( minValue.toString() );
		
	}
	
	currSelector.datetimepicker({
    	format: displayFormatter,
    	daysOfWeekDisabled:daysOfWeekDisabledArray,
    	minDate: minValue
    }).on("dp.change", function(e) {
    	
    	changeDataFlag = true;

    	var newDate = $(this).data("DateTimePicker").date();
    	var newValue = moment( newDate ).format('YYYYMMDD');
    	
    	if ( !withYearDate ){
    		
    		newValue = moment( newDate ).format('MMDD');
    		
    	}
    	
    	$(this).prev('.date_picker_alter').val( newValue );
    	$(this).prev('.date_picker_alter').change();
    	
    });
	
	if( currValue == null || currValue  == "" || currValue == 0){
		 
		if ( !hasSwitch ){
		
			var formattedDate = moment( new Date() ).format( displayFormatter );
			var formattedValue = moment( new Date() ).format( 'YYYYMMDD' );
			
	    	if ( !withYearDate ){
	    		
	    		formattedValue = moment( new Date() ).format('MMDD');
	    		
	    	}
	//		console.log('formattedDate for (date) .date_picker.val: ' + formattedDate );
			
			currSelector.val( formattedDate );
			$('#' + datePickerAlterId ).val( formattedValue );
			
		}
		
	}
	else{
		
		var date = new Date();
		
		if ( withYearDate ){
			
			date = serverDateToDate( currValue );
			
		}else{
			
			date = serverSimpleDateToDate( currValue );
			
		}
		
		var formattedDate = moment(date).format( displayFormatter );
		
//		console.log('formattedDate for (currValue) .date_picker.val: ' + formattedDate );
		
		currSelector.val( formattedDate );
		
	}
	
}

function initTimePickerWebcomponentWithSelector( currSelector ){
	
	var hasSwitch = false;
	
	var datePickerAlterId = currSelector.prev('.time_picker_alter').attr('id');
	
	var datePickerSwitchId = datePickerAlterId + '_switch';
	
	//id:xyz_switch
	//id:xyz xyz_alter
	//xyz
	
	var currValue = $('#' + datePickerAlterId ).val();

	if ( $('#' + datePickerSwitchId ).length ){
		
		hasSwitch = true;
		
	}
	
	if ( hasSwitch ){
		
		if ( currValue == 0 ){
			
			$('#' + datePickerSwitchId ).prop('checked', false);
		
			updateDatePickerWithCheckbox( $('#' + datePickerSwitchId ), false );
			
		}else{
			
			$('#' + datePickerSwitchId ).prop('checked', true );
			
			updateDatePickerWithCheckbox( $('#' + datePickerSwitchId ), true );			
			
		}
		
	}
	
	var withYearDate = currSelector.hasClass('time_picker_type_year_date_time');
	var displayFormatter = currSelector.data('display-formatter');
	
	currSelector.datetimepicker({
    	
		format: displayFormatter
    	
    }).on("dp.change", function(e) {
    	
    	changeDataFlag = true;
    	
    	if ( withYearDate ){
    		
    		var newValue = $(this).data("DateTimePicker").date().unix() *1000;
    		
        	$(this).prev('.time_picker_alter').val( newValue );
        	$(this).prev('.time_picker_alter').change();        	
    		
    	}else{
    		
        	var startTimeDisplay = $(this).val();
        	var startTimeValue = startTimeDisplay.replace(":", "");
        	$(this).prev('.time_picker_alter').val( startTimeValue );
        	$(this).prev('.time_picker_alter').change();
        	
    	}
    	
    });
	
	
	if( currValue == null || currValue  == "" || currValue == 0){
		
		if ( withYearDate ){
			
			var formattedDate = moment( new Date() ).format( displayFormatter );
			
			$('#' + datePickerAlterId ).val( new Date().getTime() );
			
			currSelector.val( formattedDate );
			
		}else {
			currSelector.val('00:00');
		}
	}
	else{
		
		if ( withYearDate ){
			
			var formattedDate = moment( parseFloat(currValue) ).format( displayFormatter );
			
			currSelector.val( formattedDate );
			
		}else{
			currSelector.val( serverTimeToDisplayTime( currValue ) );
		}
	}
	
}



function showWarningMessage( msg ){
	showMessage( ".warning_hint", msg, 'red' );
}

function showMessage( selector, msg ){
	showMessage( selector, msg, 'red');
}
function showMessage( selector, msg, color ){
	$( selector ).text( msg );
	$( selector ).css('color', color );
	$( selector ).delay(2000).animate({color:'white'},'slow', function(){
		$( selector ).text('');
	});
}

function noticeUnauth() {
	
	var title = "Authentication";
	var msg = "Please login again.";	
	
	fancyNotice(title, msg, 'OK', function(){
		window.location.href = 'Login';
	});

};


function timestampToDisplay(UNIX_timestamp){
	return timestampToDisplay( UNIX_timestamp, true);
}	

function timestampToDisplay(UNIX_timestamp, dateOnly){
	var a = new Date( parseInt( UNIX_timestamp));	
	
	var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
    var year = a.getFullYear();
    var month = ('0' + (a.getMonth()+1) ).slice(-2);//months[a.getMonth()];
    var date = ('0' + (a.getDate()) ).slice(-2);
    
    var hour = ('0' + (a.getHours()) ).slice(-2);

    var min = ('0' + (a.getMinutes()) ).slice(-2);

    var sec = a.getSeconds();
//    var time = date + ',' + month + ' ' + year + ' ' + hour + ':' + min + ':' + sec ;
    var time = year + '-' + month + '-' + date;
    
    if ( !dateOnly ){
    	time += ' ' + hour + ':' + min;     
    }
    return time;	
}

function serverDateToDate( serverDate ){
	
	//20150101
	var yearStr = serverDate.substring(0, 4);
	var monthStr = serverDate.substring( 4, 6 );
	var dayStr = serverDate.substring( 6, 8);
	
	var date = new Date( parseInt( yearStr ), parseInt( monthStr ) -1 , parseInt( dayStr), 0, 0, 0, 0);
	
	return date;
}


function convertNumberToTextInHourMinute( value ){
	
	if ( value < 10 ){
		
		return '0' + value;
		
	}
	
	return value;
	
}

function readImageURL( inputSelector ) {

	var filePath = $(inputSelector).val();
	
	if ( filePath.indexOf('jpg') >=0  || filePath.indexOf('jpeg') >=0  ||filePath.indexOf('png') >=0  ||filePath.indexOf('img') >=0  ){
		
		if ( $(inputSelector)[0].files &&  $(inputSelector)[0].files[0]) {
	    	
	        var reader = new FileReader();

	        reader.onload = function (e) {
	        	
	        	$(inputSelector).next('.file_input_preview').attr('src', e.target.result);
	        	$(inputSelector).next('.file_input_preview').show();

	        }

	        reader.readAsDataURL( $(inputSelector)[0].files[0]);
	    }
				
	}else{
		
		$(inputSelector).next('.file_input_preview').hide();
		
	}
    
}
