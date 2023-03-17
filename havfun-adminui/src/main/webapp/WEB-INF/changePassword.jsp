<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${SelectedLang}" scope="request"/>
<fmt:setBundle basename="Label" var="labelLang"/>
<fmt:setBundle basename="Result" var="resultLang"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HavFun</title>
<link href="css/smoothness/jquery-ui-1.10.4.custom.css" rel="stylesheet">
<link type="text/css" href="css/style.css" rel="stylesheet" />
<script src="js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script type="text/javascript" src="js/jquery.fancybox.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css"
	media="screen" />
<script src="js/common-basic.js"></script>
</head>
<body>
<div id="wrapper">
	<jsp:include page="header.jsp" flush="true"/>
	<jsp:include page="menu.jsp" flush="true"/>
	<div id="mainContent">
		<div id="change_password_section">
			<div class="login_table_header">
				<div class="password_table_title"><fmt:message key="login_change_password" bundle="${labelLang}"/></div>
			</div>		
			<table class="list_view_content_table login_table">
				<tr height="20px"><td colspan="2"></td></tr>
				<tr>
					<td width="40%" align="right" style="padding-right:20px;"><fmt:message key="login_old_password" bundle="${labelLang}"/>:</td>
					<td width="60%" align="left" style="padding-left:20px;">
						<input id="old_password" tabindex="1" type="password" autocomplete=off class="login_input" style="width:60%;" name="old_password" type="text" maxlength="20" size="20" autocomplete="on" autofocus>
					</td>
				</tr>
				<tr>
					<td width="40%" align="right" style="padding-right:20px;"><fmt:message key="login_new_password" bundle="${labelLang}"/>:</td>
					<td width="60%" align="left" style="padding-left:20px;">
						<input id="new_password" tabindex="1" type="password" autocomplete=off class="login_input new_password_input" style="width:60%;" name="new_password" type="text" maxlength="20" size="20" autocomplete="on" autofocus>
					</td>
				</tr>				
				<tr>
					<td width="40%" align="right" style="padding-right:20px;"><fmt:message key="login_confirm_password" bundle="${labelLang}"/>:</td>
					<td width="60%" align="left" style="padding-left:20px;">
						<input id="confirm_password" tabindex="1" type="password" autocomplete=off class="login_input new_password_input" style="width:60%;float:left;" name="confirm_password" type="text" maxlength="20" size="20" autocomplete="on" autofocus>
						<div class="blue_tick_icon" ></div>
						<div class="red_wrong_icon" ></div>
					</td>
				</tr>	
				<tr><td></td><td style="height:20px;padding-left:20px;padding-right:20px;">
					<div style="font-size:11px;"><fmt:message key="change_password_hints" bundle="${labelLang}"/></div>
				</td></tr>
				
				<tr><td></td><td><div class="warning_hint" style="color:#ffffff;padding-left:20px;">-</div></td></tr>
				<tr>
					<td>
					</td>
					<td>
						<div class="btn_common" id="btn_ok" tabindex="3" style="margin:0px 50px 20px 0px;float:right;"><fmt:message key="common_ok" bundle="${labelLang}"/></div>							
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="clear"></div>
	<jsp:include page="footer.jsp" flush="true"/>
</div>
</body>
<script>


$(document).ready(function(){

	<c:if test="${not empty loginResult}">
		$(".warning_hint").text( "<fmt:message key="login_result.${loginResult}" bundle="${resultLang}"/>" );		
		$(".warning_hint").animate({color:'red'},'slow');		
		$(".warning_hint").delay(2000).animate({color:'white'},'slow', function(){
			$(this).text('-');
		});					
	</c:if>

});

$(document).keyup(function(e) {
	if($.fancybox.isOpen) {

		if (e.keyCode == 13)
		{
			$('.fancybox-overlay #btn_ok').click();
		}				
		return false;
	}
	
	if (e.keyCode == 13)
	{
		$('#btn_ok').click();
	}
});

$("#btn_ok").on('click', function(){
	
	var errorMsg = isDataFormError();
	if (  errorMsg != null ){
		$(".warning_hint").text( errorMsg );
		$(".warning_hint").animate({color:'red'},'slow');		
		$(".warning_hint").delay(2000).animate({color:'white'},'slow', function(){
			$(this).text('-');
		});							
		event.preventDefault();
		return false;
	}
	
	fancyLoading();
	
	var url = "";	
	var old_password = $("#old_password").val();
	var new_password = $("#new_password").val();	
	var confirm_password = $("#confirm_password").val();
	
	url = "ChangePasswordRequest?oldPassword="+old_password
			+"&newPassword="+new_password
			+"&confirmPassword="+confirm_password;
	
	$.ajax({
		dataType: "json",
		url:url
	}).done(function(data){
		var title;
		var message;
		var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
		
		if ( parseInt(data.result) == 0 ){
			title = "<fmt:message key="change_password_success" bundle="${resultLang}"/>";
			message = "<fmt:message key="change_password_result.0" bundle="${resultLang}"/>";			
			fancyNotice(title, message, okLabel, function(){
				window.location.href = "Home";	
			});

		}else {
			title = "<fmt:message key="change_password_fail" bundle="${resultLang}"/>";			
			message = "<fmt:message key="change_password_result.-999" bundle="${resultLang}"/>";			
			fancyWarning(title, message, okLabel, function(){});
		}						
			
	}).fail(function() {
		var title = "<fmt:message key="change_password_fail" bundle="${resultLang}"/>";			
		var message = "<fmt:message key="change_password_result.-999" bundle="${resultLang}"/>";	
		var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
				
		fancyWarning(title, message, okLabel, function(){});
	 });
});


function isDataFormError(){
//	var intRegex = /[0-9 -()+]+$/;	

	var intRegex = /^(?=.*\d).{8,20}$/;
	var letterRegex = /^(?=.*[A-Za-z]).{8,20}$/;

	if ( $("#old_password").val() == null || $("#old_password").val() == ""  ){
		return "<fmt:message key="change_password_error_old_password_empty" bundle="${labelLang}"/>";
	}else if ( $("#new_password").val() == null || $("#new_password").val() == ""  ){
		return "<fmt:message key="change_password_error_new_password_empty" bundle="${labelLang}"/>";
	}else if ( $("#confirm_password").val() == null || $("#confirm_password").val() == ""  ){
		return "<fmt:message key="change_password_error_confirm_new_password_empty" bundle="${labelLang}"/>";
	}else if ( $("#new_password").val() !=  $("#confirm_password").val()){
		return "<fmt:message key="change_password_error_confirm_new_password_different" bundle="${labelLang}"/>";
	}else if ( $("#old_password").val() ==  $("#new_password").val()){
		return "<fmt:message key="change_password_error_old_new_password_same" bundle="${labelLang}"/>";
	}else if ( $("#new_password").val().length < 8 ){
		return "<fmt:message key="change_password_error_new_password_length" bundle="${labelLang}"/>";		
	}
	else if ( !$("#new_password").val().match(intRegex)){
		return "<fmt:message key="change_password_error_new_password_number" bundle="${labelLang}"/>";
    }else if ( !$("#new_password").val().match(letterRegex)){
		return "<fmt:message key="change_password_error_new_password_letter" bundle="${labelLang}"/>";
    }else if ( !isASCII( $("#new_password").val() ) ){
    	return "<fmt:message key="change_password_error_invalid_characters" bundle="${labelLang}"/>";
    }
		
	return null;
}

function isASCII( str ){
	
	for(var i=0;i<str.length;i++){
        if(str.charCodeAt(i)>127){
            return false;
        }
    }
	return true;
}

$("input:text, input:password").bind('input', function(){
	//remove all space
    $(this).val(function(_, v){
		return v.replace(/\s+/g, '');
    });
		
  });

$('.new_password_input').keyup(function(){
	
	if ( $('#new_password').val() == '' && $('#confirm_password').val() == '' ){
		$('.blue_tick_icon').fadeOut('fast');		
		$('.red_wrong_icon').fadeOut('fast');
	}else if ( $('#new_password').val() == $('#confirm_password').val() ){		
		$('.red_wrong_icon').fadeOut('fast', function(){
			$('.blue_tick_icon').fadeIn('fast');	
		});
	}else{
		$('.blue_tick_icon').fadeOut('fast', function(){
			$('.red_wrong_icon').fadeIn('fast');
		});				
	}
});

</script>
</html>