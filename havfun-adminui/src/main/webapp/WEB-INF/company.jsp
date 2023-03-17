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
<link href="css/smoothness/jquery-ui-1.10.4.custom.css" rel="stylesheet">
<link type="text/css" href="css/style.css" rel="stylesheet" />
<script src="js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script type="text/javascript" src="js/jquery.fancybox.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css"
	media="screen" />
<script src="js/jquery.cookie.js"></script>
<script src="js/common-basic.js"></script>
</head>
<body>
<div id="wrapper">
	<jsp:include page="header.jsp" flush="true"/>
	<jsp:include page="menu.jsp" flush="true"/>
	<div id="mainContent">
		<div id="nav_path"><fmt:message key="group_company" bundle="${labelLang}"/>  > <strong><fmt:message key="${navigator}" bundle="${labelLang}"/></strong></div>
		<div id="keystock">
			<c:if test="${not empty action || not empty cancelPendingAction}">
			<form id="companyForm" action="${action}" method="post">
			</c:if>
					<table width="906px" border="0" cellpadding="1" cellspacing="0">
						<c:if test="${not empty link}">
						<tr><td></td><td align="right"><div id="urllink"><a href="${url}">${link}</a></div></td></tr>
						</c:if>
						<ari:webComponent bundle="${label}" webComponent="${companyId}" pageMode="${pageMode}" value="${companyMessage.companyId}" origValue="${originalCompanyMessage.companyId}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${stockCode}" pageMode="${pageMode}" value="${companyMessage.stockCode}" origValue="${originalCompanyMessage.stockCode}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${longNameEn}" pageMode="${pageMode}" value="${companyMessage.longNameEn}" origValue="${originalCompanyMessage.longNameEn}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${longNameHk}" pageMode="${pageMode}" value="${companyMessage.longNameHk}" origValue="${originalCompanyMessage.longNameHk}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${longNameCn}" pageMode="${pageMode}" value="${companyMessage.longNameCn}" origValue="${originalCompanyMessage.longNameCn}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${shortNameEn}" pageMode="${pageMode}" value="${companyMessage.shortNameEn}" origValue="${originalCompanyMessage.shortNameEn}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${shortNameHk}" pageMode="${pageMode}" value="${companyMessage.shortNameHk}" origValue="${originalCompanyMessage.shortNameHk}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${shortNameCn}" pageMode="${pageMode}" value="${companyMessage.shortNameCn}" origValue="${originalCompanyMessage.shortNameCn}"></ari:webComponent>
						
						<ari:webComponent bundle="${label}" webComponent="${businessClassification}" pageMode="${pageMode}" choiceList="${businessClassificationIdList}" labelList="${businessClassificationLabelList}" value="${companyMessage.businessClassification.businessClassificationId}" origValue="${originalCompanyMessage.businessClassification.businessClassificationId}"></ari:webComponent>
						
						<ari:webComponent bundle="${label}" webComponent="${telephoneNo}" pageMode="${pageMode}" value="${companyMessage.telephoneNo}" origValue="${originalCompanyMessage.telephoneNo}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${fax}" pageMode="${pageMode}" value="${companyMessage.fax}" origValue="${originalCompanyMessage.fax}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${email}" pageMode="${pageMode}" value="${companyMessage.email}" origValue="${originalCompanyMessage.email}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${website}" pageMode="${pageMode}" value="${companyMessage.website}" origValue="${originalCompanyMessage.website}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${activitiesEn}" pageMode="${pageMode}" value="${companyMessage.activitiesEn}" origValue="${originalCompanyMessage.activitiesEn}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${activitiesHk}" pageMode="${pageMode}" value="${companyMessage.activitiesHk}" origValue="${originalCompanyMessage.activitiesHk}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${activitiesCn}" pageMode="${pageMode}" value="${companyMessage.activitiesCn}" origValue="${originalCompanyMessage.activitiesCn}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${addressEn}" pageMode="${pageMode}" value="${companyMessage.addressEn}" origValue="${originalCompanyMessage.addressEn}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${addressHk}" pageMode="${pageMode}" value="${companyMessage.addressHk}" origValue="${originalCompanyMessage.addressHk}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${addressCn}" pageMode="${pageMode}" value="${companyMessage.addressCn}" origValue="${originalCompanyMessage.addressCn}"></ari:webComponent>
						
						<ari:webComponent bundle="${label}" webComponent="${incorporate}" pageMode="${pageMode}" choiceList="${incorporateIdList}" labelList="${incorporateLabelList}" value="${companyMessage.incorporate.incorporateId}" origValue="${originalCompanyMessage.incorporate.incorporateId}"></ari:webComponent>						
						
						<ari:webComponent bundle="${label}" webComponent="${parValueCurrency}" pageMode="${pageMode}" value="${companyMessage.parValueCurrency}" origValue="${originalCompanyMessage.parValueCurrency}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${parValue}" pageMode="${pageMode}" value="${companyMessage.parValue}" origValue="${originalCompanyMessage.parValue}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${lotSize}" pageMode="${pageMode}" value="${companyMessage.lotSize}" origValue="${originalCompanyMessage.lotSize}"></ari:webComponent>
						
						<ari:webComponent bundle="${label}" webComponent="${tradingCurrency}" pageMode="${pageMode}" value="${companyMessage.tradingCurrency}" origValue="${originalCompanyMessage.tradingCurrency}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${registrarEn}" pageMode="${pageMode}" value="${companyMessage.registrarEn}" origValue="${originalCompanyMessage.registrarEn}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${registrarHk}" pageMode="${pageMode}" value="${companyMessage.registrarHk}" origValue="${originalCompanyMessage.registrarHk}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${registrarCn}" pageMode="${pageMode}" value="${companyMessage.registrarCn}" origValue="${originalCompanyMessage.registrarCn}"></ari:webComponent>						
						
						<ari:webComponent bundle="${label}" webComponent="${authorisedShares}" pageMode="${pageMode}" value="${companyMessage.authorisedShares}" origValue="${originalCompanyMessage.authorisedShares}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${issuedShares}" pageMode="${pageMode}" value="${companyMessage.issuedShares}" origValue="${originalCompanyMessage.issuedShares}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${market}" pageMode="${pageMode}" value="${companyMessage.market}" origValue="${originalCompanyMessage.market}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${listingDate}" pageMode="${pageMode}" value="${companyMessage.listingDate}" origValue="${originalCompanyMessage.listingDate}"></ari:webComponent>
						
						<ari:webComponent bundle="${label}" webComponent="${pendingStatus}" pageMode="${pageMode}" value="${companyPendingStatus}" origValue="${companyPendingStatus}"></ari:webComponent>
						
						
						<c:if test="${not empty action|| not empty removeAction || not empty cancelPendingAction}">
						<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
						<tr>
							<td colspan="2" align="right">
								<div id="hint_text" style="float:right;margin:5px;color:#ffffff;font-weight: bold;font-size:12px;">-</div>
							</td>							
						</tr>
						<tr>
							<td>
							</td>

							<c:if test="${not empty action}">
								<c:if test="${action == 'UpdateCompanyRequest'}">
									<td align="right">
										<div class="btn_common_sell_small btn_submit" id="btn_inactivate" style="float:right;">
											<fmt:message key="common_inactivate" bundle="${labelLang}"/>
										</div>
									</td>
								</c:if>
							</c:if>
							
							<td align="right">							
								<c:if test="${not empty action}">
								<div class="btn_common_small btn_submit" id="btn_ok" style="float:right;">

									<c:if test="${action == 'CreateCompanyRequest'}">	
										<fmt:message key="common_create" bundle="${labelLang}"/>
									</c:if>
									<c:if test="${action == 'UpdateCompanyRequest'}">	
										<fmt:message key="common_update" bundle="${labelLang}"/>									
									</c:if>								
									<c:if test="${action == 'ConfirmCompanyRequest'}">	
										<fmt:message key="common_confirm" bundle="${labelLang}"/>									
									</c:if>								
								</div>								
								</c:if>
								
								<c:if test="${not empty rejectCompanyRequest}">
									<div class="btn_common_sell_small btn_reject" style="margin-right:10px;float:right;">
										<fmt:message key="common_reject" bundle="${labelLang}"/>
									</div>									
								</c:if>															
								<c:if test="${not empty cancelPendingAction}">
									<div class="btn_common_sell_small btn_cancel" style="margin-right:10px;float:right;">
										<fmt:message key="common_cancel" bundle="${labelLang}"/>
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


$(document).ready(function(){
	
	$( '.dateSelect' ).datepicker({ dateFormat: 'yy-mm-dd',
//		minDate: 0, 
//		maxDate: "+1M",
		showAnim: "drop",
		altField: "#dateSelectData",
		altFormat: "yymmdd",
	    changeMonth: true,
		changeYear: true
	});
	
	var dateSelectData = $('#dateSelectData').val();

	if ( dateSelectData == null || dateSelectData == 0 ){

		$('.dateSelect').datepicker('setDate', new Date() );	
	}else{

		$('.dateSelect').datepicker('setDate', serverDateToDate(dateSelectData) );
	}
});

var errorMessage = '';
var enableAction = true;

$('#btn_ok').click(function () {

	if ( !enableAction ) return;
	
	disableSubmitButton();
	
	if ( !isFormValid() ){
		showErrorMessage( errorMessage);
		enableSubmitButton();
		return;
	}
	
	fancyLoading();
	
	var title = '';
	var message = '';
	var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
	
	//$('#userForm').submit();
	var url = '${action}';

	$('input, select, textarea').each(function() {
		if ( url.indexOf('?') < 0 ){
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
				
				if ( dataObj.result == 0 ){
					if ( '${action}' == 'CreateCompanyRequest' ){
						title = '<fmt:message key="create_company_success" bundle="${resultLang}"/>';
						message = '<fmt:message key="create_company_result.0" bundle="${resultLang}"/>';
						
						fancyNotice( title, message, okLabel, function(){
							var companyId = dataObj.companyId;
							window.location.href = 'EnquireCompany?companyId='+companyId;
						});
					}else if ( '${action}' == 'UpdateCompanyRequest' ){
						title = '<fmt:message key="update_company_success" bundle="${resultLang}"/>';
						message = '<fmt:message key="update_company_result.0" bundle="${resultLang}"/>';
					
						fancyNotice( title, message, okLabel, function(){
							window.location.href = 'EnquireCompany?companyId=${companyMessage.companyId}';
						});
					}else if ( '${action}' == 'ConfirmCompanyRequest' ){
						title = '<fmt:message key="confirm_company_success" bundle="${resultLang}"/>';
						message = '<fmt:message key="confirm_company_result.0" bundle="${resultLang}"/>';
					
						fancyNotice( title, message, okLabel, function(){
							window.location.href = 'EnquireCompany?companyId=${companyMessage.companyId}';
						});
					}
				
				}else if ( dataObj.result == 5){
					if ( '${action}' == 'CreateCompanyRequest' ){
						title = '<fmt:message key="create_company_success" bundle="${resultLang}"/>';
						message = '<fmt:message key="create_company_result.5" bundle="${resultLang}"/>';
						
						fancyNotice( title, message, okLabel, function(){
							var companyId = dataObj.companyId;
							window.location.href = 'EnquireCompany?companyId='+companyId;
						});
					}
				}else {
					if ( '${action}' == 'CreateCompanyRequest' ){
						title = '<fmt:message key="create_company_fail" bundle="${resultLang}"/>';
						message = '<fmt:message key="create_company_result.-1" bundle="${resultLang}"/>';
						
						fancyWarning( title, message, okLabel, function(){} );
					}else if ( '${action}' == 'UpdateCompanyRequest' ){
						title = '<fmt:message key="update_company_fail" bundle="${resultLang}"/>';
						message = '<fmt:message key="update_company_result.-1" bundle="${resultLang}"/>';
						
						fancyWarning( title, message, okLabel, function(){} );
					}else if ( '${action}' == 'ConfirmCompanyRequest' ){
						title = '<fmt:message key="confirm_company_fail" bundle="${resultLang}"/>';
						message = '<fmt:message key="confirm_company_result.-1" bundle="${resultLang}"/>';
						
						fancyWarning( title, message, okLabel, function(){} );
					}
					enableSubmitButton();					
				}

          	}
		}).fail(function(){
			if( '${action}' == 'CreateCompanyRequest'){
				title = '<fmt:message key="create_company_fail" bundle="${resultLang}"/>';
				message = '<fmt:message key="create_company_result.-999" bundle="${resultLang}"/>';
				
				fancyWarning( title, message, okLabel, function(){} );
			}else if ( '${action}' == 'UpdateCompanyRequest' ){
				title = '<fmt:message key="update_company_fail" bundle="${resultLang}"/>';
				message = '<fmt:message key="update_company_result.-999" bundle="${resultLang}"/>';
				
				fancyWarning( title, message, okLabel, function(){} );
			}else if ( '${action}' == 'ConfirmCompanyRequest' ){
				title = '<fmt:message key="confirm_company_fail" bundle="${resultLang}"/>';
				message = '<fmt:message key="confirm_company_result.-999" bundle="${resultLang}"/>';
				
				fancyWarning( title, message, okLabel, function(){} );
			}
			enableSubmitButton();	
		});	
	
});

$('#btn_inactivate').click(function () {

	if ( !enableAction ) return;
	
	//disableSubmitButton();
	
	if ( !isFormValid() ){
		showErrorMessage( errorMessage);
		enableSubmitButton();
		return;
	}
	
	fancyLoading();
	
	var title = '';
	var message = '';
	var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
	
	//$('#userForm').submit();
	var url = 'InactivateCompanyRequest';

	/*
	$('input, select, textarea').each(function() {
		if ( url.indexOf('?') < 0 ){
			url += '?'+this.name + '=' + encodeURIComponent($(this).val());
			firstTag = false;
		}else{
			url += '&'+this.name + '=' + encodeURIComponent($(this).val()); 
		}		
    });
	*/

	var fieldName = 'companyId';
	var value = encodeURIComponent($('#'+fieldName).val());
	url += '?'+fieldName+'='+value;
	
 	$.ajax({
		url : url,
          	type : "GET",
          	data : {
          			method: "json"
          	},
          	dataType : "json",
          	success : function(dataObj) {
				
				if ( dataObj.result == 0 ){
					title = '<fmt:message key="inactivate_company_success" bundle="${resultLang}"/>';
					message = '<fmt:message key="inactivate_company_result.0" bundle="${resultLang}"/>';
					
					fancyNotice( title, message, okLabel, function(){
						var companyId = dataObj.companyId;
						window.location.href = 'EnquireCompany?companyId='+companyId;
					});
				
				}else {
					title = '<fmt:message key="inactivate_company_fail" bundle="${resultLang}"/>';
					message = '<fmt:message key="inactivate_company_result.-1" bundle="${resultLang}"/>';
						
					fancyWarning( title, message, okLabel, function(){} );				
				}

          	}
		}).fail(function(){
			title = '<fmt:message key="inactivate_company_fail" bundle="${resultLang}"/>';
			message = '<fmt:message key="inactivate_company_result.-999" bundle="${resultLang}"/>';
				
			fancyWarning( title, message, okLabel, function(){} );
		});	
	
});

$('.btn_cancel').on('click', function(e){
	
	var url = 'CancelCompanyRequest';
	
	$('input, select, textarea').each(function() {
		if ( url.indexOf('?') < 0 ){
			url += '?'+this.name + '=' + encodeURIComponent($(this).val());
			firstTag = false;
		}else{
			url += '&'+this.name + '=' + encodeURIComponent($(this).val()); 
		}		
    });	
	
	var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
	var successTitle = '<fmt:message key="cancel_company_success" bundle="${resultLang}"/>';
	var successMessage = '<fmt:message key="cancel_company_result.0" bundle="${resultLang}"/>';
	var failTitle = '<fmt:message key="cancel_company_fail" bundle="${resultLang}"/>';
	var failMessage = '<fmt:message key="cancel_company_result.-1" bundle="${resultLang}"/>';
	

	runAjaxService( url, okLabel, successTitle, successMessage, function(){ window.location.href = 'EnquireCompany?companyId=${companyMessage.companyId}';},
			failTitle, failMessage, function(){});
	
});

$('.btn_reject').on('click', function(e){
	
	var url = 'RejectCompanyRequest';
	
	$('input, select, textarea').each(function() {
		if ( url.indexOf('?') < 0 ){
			url += '?'+this.name + '=' + encodeURIComponent($(this).val());
			firstTag = false;
		}else{
			url += '&'+this.name + '=' + encodeURIComponent($(this).val()); 
		}
    });	
	

	var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
	var successTitle = '<fmt:message key="reject_company_success" bundle="${resultLang}"/>';
	var successMessage = '<fmt:message key="reject_company_result.0" bundle="${resultLang}"/>';
	var failTitle = '<fmt:message key="reject_company_fail" bundle="${resultLang}"/>';
	var failMessage = '<fmt:message key="reject_company_result.-1" bundle="${resultLang}"/>';
	

	runAjaxService( url, okLabel, successTitle, successMessage, function(){ window.location.href = 'EnquireCompany?companyId=${companyMessage.companyId}';},
			failTitle, failMessage, function(){});
	
});


function isFormValid(){
	var result = true;
	errorMessage = '';
	
	var websiteValue = $('#website').val();
	
	if ( websiteValue.indexOf('http://') < 0 ){
		
		result = false;
		errorMessage = 'Website must contain http:// ';
		
	}
	
	return result;
}


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
</script>

</body>
</html>