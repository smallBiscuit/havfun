<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/Descriptor.tld" prefix="ari" %>
<fmt:setLocale value="${SelectedLang}" scope="request"/>
<fmt:setBundle basename="Lang" var="lang"/>
<fmt:setBundle basename="Label" var="label"/>
<fmt:setBundle basename="Label" var="labelLang"/>
<fmt:setBundle basename="Result" var="resultLang"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HavFun</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap/bootstrap-datetimepicker.min.css" />
<link type="text/css" rel="stylesheet" href="css/bootstrap/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="css/smoothness/jquery-ui-1.10.4.custom.css">
<link type="text/css" rel="stylesheet" href="css/jquery.fancybox.css" media="screen" />
<link type="text/css" rel="stylesheet" href="css/style.css"/>

<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.4.custom.js"></script>
<script type="text/javascript" src="js/jquery.fancybox.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/common-basic.js"></script>

<script type="text/javascript" src="js/moment.js"></script>
<script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>

</head>
<body>
<div id="wrapper">
	<jsp:include page="header.jsp" flush="true"/>
	<jsp:include page="menu.jsp" flush="true"/>
	<div id="mainContent">
		<div id="nav_path"><fmt:message key="group_announcement" bundle="${labelLang}"/>  > <strong><fmt:message key="${navigator}" bundle="${labelLang}"/></strong></div>
		<div id="keystock">
			<c:if test="${not empty action || not empty cancelPendingAction}">
			<form id="announcementForm" action="${action}" method="post" enctype="multipart/form-data">
			</c:if>
					<table width="906px" border="0" cellpadding="1" cellspacing="0">
						<c:if test="${not empty link}">
						<tr><td></td><td align="right"><div id="urllink"><a href="${url}">${link}</a></div></td></tr>
						</c:if>
						<ari:webComponent bundle="${label}" webComponent="${announcementId}" pageMode="${pageMode}" value="${announcement.announcementId}" origValue="${origAnnouncement.announcementId}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${stockCode}" pageMode="${pageMode}" value="${announcement.stockCode}" origValue="${origAnnouncement.stockCode}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${uniqueName}" pageMode="${pageMode}" value="${announcement.uniqueName}" origValue="${origAnnouncement.uniqueName}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${releaseTimestamp}" pageMode="${pageMode}" value="${announcement.releaseTimestamp}" origValue="${origAnnouncement.releaseTimestamp}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${announcementTitle}" pageMode="${pageMode}" value="${announcement.announcementTitle}" origValue="${origAnnouncement.announcementTitle}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${announcementTitleCn}" pageMode="${pageMode}" value="${announcement.announcementTitleCn}" origValue="${origAnnouncement.announcementTitleCn}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${announcementDescription}" pageMode="${pageMode}" value="${announcement.announcementDescription}" origValue="${origAnnouncement.announcementDescription}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${announcementDescriptionCn}" pageMode="${pageMode}" value="${announcement.announcementDescriptionCn}" origValue="${origAnnouncement.announcementDescriptionCn}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${announcementType}" pageMode="${pageMode}" choiceList="${announcementTypeList}" labelList="${announcementTypeLabelList}" value="${announcement.announcementType.announcementTypeCode}" origValue="${origAnnouncement.announcementType.announcementTypeCode}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${languageFlag}" pageMode="${pageMode}" choiceList="${languageFlagList}" labelList="${languageFlagLabelList}" value="${announcement.languageFlag.value}" origValue="${origAnnouncement.languageFlag.value}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${fileSize}" pageMode="${pageMode}" value="${announcement.fileSize}" origValue="${origAnnouncement.fileSize}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${fileType}" pageMode="${pageMode}" value="${announcement.fileType}" origValue="${origAnnouncement.fileType}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${urlPath}" pageMode="${pageMode}" value="${announcement.urlPath}" origValue="${origAnnouncement.urlPath}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${announcementStatus}" pageMode="${pageMode}" choiceList="${announcementStatusList}" value="${announcement.announcementStatus}" origValue="${origAnnouncement.announcementStatus}"></ari:webComponent>
						
						<tr>
							<td width="30%">File:</td>
							<td width="70%">
								<c:choose>
									<c:when test="${action == 'CreateAnnouncementRequest'}">
										<input type="file" id="file" name="file">
									</c:when>
									<c:otherwise>										
										<div style="float:left;border:solid 1px #009ada; width:150px;cursor:pointer;">
											<img id="document_cover" class="btn_doc" src="${baseURL}${announcement.urlPath}../ar/${announcement.uniqueName}.jpg" alt="Image not found" onError="this.src='img/pdf_cover_default.jpg';" style="width:100%;"></img>
											<input id="url_path" type="hidden" value="${baseURL}${announcement.urlPath}${announcement.uniqueName}">
											<input id="announcement_id" type="hidden" value="${announcement.announcementId}">
										</div>
										
										<c:if test="${action == 'UpdateAnnouncementRequest'}">									
											<div style="float:left;margin-left:10px;">Change Cover:<input type="file" id="file_cover" name="file_cover"></div>
										</c:if>
										<c:if test="${not empty hasUpdatedCover}">	
											<div style="float:left;margin: 20px 20px;"> > </div>								
											<div style="float:left;border:solid 1px #009ada; width:150px;cursor:pointer;">
												<img id="document_cover" class="btn_doc" src="${baseURL}${announcement.urlPath}../ar/${announcement.uniqueName}_update.jpg" alt="Image not found" onError="this.src='img/pdf_cover_default.jpg';" style="width:100%;"></img>
											</div>
										</c:if>										
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						
						<c:if test="${not empty action|| not empty removeAction || not empty cancelPendingAction}">
						<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
						<tr>
							<td colspan="2" align="right">
								<div id="hint_text" style="float:right;margin:5px;color:#ffffff;font-weight: bold;font-size:12px;">-</div>
							</td>							
						</tr>
						<tr>
							<td>
								<c:if test="${not empty cancelPendingAction}">
								<div align="left" class="btn_cancel_small" id="btn_cancel_pending"></div>
								</c:if>
							</td>
							<td align="right">
								<c:if test="${not empty action}">
								<div class="btn_common_small btn_submit" id="btn_ok">
								
									<c:if test="${action == 'CreateAnnouncementRequest'}">	
										<fmt:message key="common_create" bundle="${labelLang}"/>
									</c:if>
									<c:if test="${action == 'UpdateAnnouncementRequest'}">	
										<fmt:message key="common_update" bundle="${labelLang}"/>									
									</c:if>								
									<c:if test="${action == 'ConfirmAnnouncementRequest'}">	
										<fmt:message key="common_confirm" bundle="${labelLang}"/>									
									</c:if>																									
								
								</div>
								</c:if>
							</td>
						</tr>
						</c:if>
					</table>
			<c:if test="${not empty action || not empty cancelPendingAction}">
			</form>
			</c:if>
		</div>
	</div>
	<jsp:include page="footer.jsp" flush="true"/>
</div>

<script>

<c:if test="${not empty createAnnouncementResult}">
$(document).ready(function() {
	
	var title = "";
	var message = "";
	var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
	
	if (parseInt("${createAnnouncementResult}") == 0 ){ 
		title = "<fmt:message key="create_announcement_success" bundle="${resultLang}"/>";
		message = "<fmt:message key="create_announcement_result.0" bundle="${resultLang}"/>";
		fancyNotice( title, message, okLabel );
	}
	else{
		title = "<fmt:message key="create_announcement_fail" bundle="${resultLang}"/>";
		message = "<fmt:message key="create_announcement_result.-1" bundle="${resultLang}"/>";
		fancyWarning( title, message, okLabel );
	}	
	
});
</c:if>

var errorMessage = '';
var enableAction = true;

$(document).ready(function(){
	/*
	$( '.dateSelect' ).datepicker({ dateFormat: 'yy-mm-dd',
		showAnim: "drop",
		altField: "#dateSelectData",
	    altFormat: "@"
	});
	
	var dateSelectData = $('#dateSelectData').val();

	if ( dateSelectData == null || dateSelectData == 0 ){

		$('.dateSelect').datepicker('setDate', new Date() );	
	}else{

		$('.dateSelect').datepicker('setDate', new Date( parseInt( dateSelectData )) );
	}
	*/	
	$('#stockCode').keydown(function(e) {
		
		if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
	            // Allow: Ctrl+A
	           (e.keyCode == 65 && e.ctrlKey === true) || 
	            // Allow: home, end, left, right
	           (e.keyCode >= 35 && e.keyCode <= 39)) {
	                // let it happen, don't do anything
	                return;
	       }
		
	    // Ensure that it is a number and stop the keypress
	    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105) ) {
	        e.preventDefault();
	    }
	});
	
});


<c:if test="${not empty action}">
$('#btn_ok').click(function () {
	
	if ( !enableAction ) return;
	
	disableSubmitButton();
	
	if ( !isFormValid() ){
		showErrorMessage( errorMessage);
		enableSubmitButton();
		return;
	}
	
	fancyLoading();
	
	if ( '${action}' == 'CreateAnnouncementRequest'){
		$('#announcementForm').submit();
	}
	else if ( '${action}' == 'UpdateAnnouncementRequest'){
		$('#announcementForm').submit();
	}
	else{
		var url = '${action}';
		var firstTag = true;
		$('input, select').each(function() {
			if ( firstTag ){
				url += '?'+this.name + '=' + encodeURIComponent($(this).val());
				firstTag = false;
			}else{
				url += '&'+this.name + '=' + encodeURIComponent($(this).val()); 
			}		
	    });
	    
	 	$.ajax({
			url : url,
	          	type : "GET",
	          	data : {
	          			method: "json"
	          	},
	          	dataType : "json",
	          	success : function(dataObj) {

					var title;
					var message;
					var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
					
					if ( dataObj.result == 0 ){
											
						if ( '${action}' == 'UpdateAnnouncementRequest' ){
							title = "<fmt:message key="update_announcement_success" bundle="${resultLang}"/>";
							message = "<fmt:message key="update_announcement_result.0" bundle="${resultLang}"/>";
							
							fancyNotice(title, message, okLabel, function(){
								window.location.href = 'EnquireAnnouncement?announcementId=${announcement.announcementId}';
							});
							
						}else if ( '${action}' == 'ConfirmAnnouncementRequest' ){
							title = "<fmt:message key="confirm_announcement_success" bundle="${resultLang}"/>";
							message = "<fmt:message key="confirm_announcement_result.0" bundle="${resultLang}"/>";
							
							fancyNotice(title, message, okLabel, function(){
								window.location.href = 'EnquireAnnouncement?announcementId=${announcement.announcementId}';
							});
							
						}
						
						
					}else if ( dataObj.result == -2 ){
						if ( '${action}' == 'UpdateAnnouncementRequest' ){
							title = "<fmt:message key="update_announcement_fail" bundle="${resultLang}"/>";
							message = "<fmt:message key="update_announcement_result.-1" bundle="${resultLang}"/>";							
							
							fancyWarning(title, message, okLabel);
							
						}else if ( '${action}' == 'ConfirmAnnouncementRequest' ){
							title = "<fmt:message key="confirm_announcement_fail" bundle="${resultLang}"/>";
							message = "<fmt:message key="confirm_announcement_result.-1" bundle="${resultLang}"/>";							
							
							fancyWarning(title, message, okLabel);
						}
						enableSubmitButton();
					}
	          	}
			}).fail(function(){
				
				var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
				
				if ( '${action}' == 'UpdateAnnouncementRequest' ){
					title = "<fmt:message key="update_announcement_fail" bundle="${resultLang}"/>";
					message = "<fmt:message key="update_announcement_result.-999" bundle="${resultLang}"/>";							
					
					fancyWarning(title, message, okLabel);
				}else if ( '${action}' == 'ConfirmAnnouncementRequest' ){
					title = "<fmt:message key="confirm_announcement_fail" bundle="${resultLang}"/>";
					message = "<fmt:message key="confirm_announcement_result.-999" bundle="${resultLang}"/>";							
					
					fancyWarning(title, message, okLabel);
				}
				enableSubmitButton();
			});	
	}
});


function isFormValid(){
	var result = true;
	errorMessage = '';	

	if  ( $('#stockCode').val() == null || $('#stockCode').val() == "" ){
		result = false;
		errorMessage = 'Stock Code should not be empty';
	}else if ( $('#announcementTitle').val() == null || $('#announcementTitle').val() == "" ){
		result = false;
		errorMessage = 'Title should not be empty';
	}else if ('${action}' == 'CreateAnnouncementRequest' &&  ($('#file').val() == null || $('#file').val() == "")){
		result = false;
		errorMessage = 'File should not be empty';
	}
	return result;
}

</c:if>

$('.btn_doc').on( 'click', function(){
	var urlPath = $(this).parent().find('#url_path').val();
	window.open(urlPath);
});

function enableSubmitButton(){
	$('.btn_submit').animate({'opacity':'1.0'},100);
	enableAction = true;
}

function disableSubmitButton(){
	$('.btn_submit').animate({'opacity':'0.5'},100);
	enableAction = false;
}

function showErrorMessage( message, color ){
	if ( color == null )color = 'red';
	$('#hint_text').text(message);
	$("#hint_text").animate({color:color},'slow');		
	$("#hint_text").delay(2000).animate({color:'white'},'slow');
}

$(document).ready(function(){
	
	var defaultDate = new Date();	

	<c:if test="${not empty announcement.releaseTimestamp }">
		
		defaultDate = new Date( parseInt("${announcement.releaseTimestamp}") );	
	
	</c:if>

	$('.dateTimeSelect').val('');
	
	$('#dateTimeSelectData').val( defaultDate.getTime() );
	
    $('.dateTimeSelect').datetimepicker({
    	format: 'YYYY-MM-DD HH:mm',
    	defaultDate: defaultDate
    }).on("dp.change", function(e) {
    	
    	var selectedDate = $('.dateTimeSelect').val();
    	var timestampValue = (new Date( selectedDate )).getTime();
    	
    	$('#dateTimeSelectData').val( timestampValue );
    });


});

</script>

</body>
</html>