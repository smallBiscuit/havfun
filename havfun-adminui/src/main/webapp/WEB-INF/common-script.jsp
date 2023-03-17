<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${SelectedLang}" scope="request"/>
<fmt:setBundle basename="Label" var="labelLang"/>
<fmt:setBundle basename="Result" var="resultLang"/>
<script>


function genericFormSubmition(url, data, positiveButtonCallback) {
	
	fancyLoading();

	var ajaxData = '';
	
	if (typeof data == 'string') {
		ajaxData = {
			url: url,
			data: data,
			type: 'POST',
			dataType: 'JSON'
		}
	} else {
		ajaxData = {
			url: url,
			data: data,
			type: 'POST',
			dataType: 'JSON',
			mimeType:"multipart/form-data",
			contentType: false,
		    cache: false,
		    processData:false
		}
	}

	$.ajax(ajaxData)
	.done(function(resultJSON) {
		
		fancyLoadingHide();
		
		var resultMessage = resultJSON.resultMessage;
		var resultCode = resultJSON.resultCode;
		var redirectUrl = resultJSON.redirectUrl;
		
		if (resultCode === null || resultCode === '') return;

		if (resultCode === 0 ) {

			var message = '';			
			var title = 'Success';
			var buttonLabel = 'Ok';
			

			if(resultJSON.resultMessage !== null && resultJSON.resultMessage !== undefined){
				//message += '<fmt:message key="error_result.0" bundle="${resultLang}"/>';
				message += resultMessage;
				console.log("resultMessage is being used.");
			}
					
			var positiveButtonCallback = function() {
				$(location).attr('href', redirectUrl );
			}

			fancyNotice(title, message, buttonLabel, positiveButtonCallback);

			
		}else {
			var title = 'Fail';
			
			var buttonLabel = 'Ok';

			fancyWarning(title, message, buttonLabel, function() {});
		}
	})
	.fail(function() {
		var title = 'Fail';
		//var message = getStringByErrorCode(resultMessageKeyPrefix + ".-999");
		
		//BrianChanges - commonErrorMessage
		message = '-999';

		var buttonLabel = 'Ok';

		fancyWarning(title, message, buttonLabel, function() {});
	});
}
</script>