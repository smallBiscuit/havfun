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
<div id="nav_path"><fmt:message key="group_manage_company" bundle="${labelLang}"/>  > <strong><fmt:message key="${navigator}" bundle="${labelLang}"/></strong></div>
		<div id="keystock">
			<c:if test="${not empty action || not empty cancelPendingAction}">
			<form id="userForm" action="${action}" method="post">
			</c:if>
					<table width="906px" border="0" cellpadding="1" cellspacing="0">
						<c:if test="${not empty link}">
						<tr><td></td><td align="right"><div id="urllink"><a href="${url}">${link}</a></div></td></tr>
						</c:if>
						<ari:webComponent bundle="${label}" webComponent="${companyId}" pageMode="${pageMode}" value="${manageCompany.companyId}" origValue="${manageCompany.companyId}"></ari:webComponent>
						<ari:webComponent bundle="${label}" webComponent="${stockCode}" pageMode="${pageMode}" value="${manageCompany.stockCode}" origValue="${manageCompany.stockCode}"></ari:webComponent>
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
									<c:if test="${action == 'CreateManageCompanyRequest'}">	
										<fmt:message key="common_create" bundle="${labelLang}"/>
									</c:if>
									<c:if test="${action == 'UpdateManageCompanyRequest'}">	
										<fmt:message key="common_update" bundle="${labelLang}"/>									
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

var errorMessage = '';
var enableAction = true;
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
	
	var title = '';
	var message = '';
	var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
	
	//$('#userForm').submit();
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

          		if ( dataObj.result == 0 ){
					if ( '${action}' == 'CreateManageCompanyRequest' ){
						title = '<fmt:message key="create_manage_company_success" bundle="${resultLang}"/>';
						message = '<fmt:message key="create_manage_company_result.0" bundle="${resultLang}"/>';
												
						fancyNotice( title, message, okLabel, function(){
							window.location.href = 'SearchManageCompany';
						});
					}else if ( '${action}' == 'UpdateManageCompanyRequest' ){
						title = '<fmt:message key="update_manage_company_success" bundle="${resultLang}"/>';
						message = '<fmt:message key="update_manage_company_result.0" bundle="${resultLang}"/>';
						
						fancyNotice( title, message, okLabel, function(){
							window.location.href = 'SearchManageCompany';
						});
					}
				}else {
					if ( '${action}' == 'CreateManageCompanyRequest' ){
						title = '<fmt:message key="create_manage_company_success" bundle="${resultLang}"/>';
						message = '<fmt:message key="create_manage_company_result.-1" bundle="${resultLang}"/>';
						
						fancyWarning( title, message, okLabel, function(){} );
					}else if ( '${action}' == 'UpdateManageCompanyRequest' ){
						title = '<fmt:message key="update_manage_company_success" bundle="${resultLang}"/>';
						message = '<fmt:message key="update_manage_company_result.-1" bundle="${resultLang}"/>';
						
						fancyWarning( title, message, okLabel, function(){} );
					}
					enableSubmitButton();					
				}
          	}
		}).fail(function(){
			if ( '${action}' == 'CreateManageCompanyRequest' ){
				title = '<fmt:message key="create_manage_company_success" bundle="${resultLang}"/>';
				message = '<fmt:message key="create_manage_company_result.-999" bundle="${resultLang}"/>';
				
				fancyWarning( title, message, okLabel, function(){} );
			}else if ( '${action}' == 'UpdateManageCompanyRequest' ){
				title = '<fmt:message key="update_manage_company_success" bundle="${resultLang}"/>';
				message = '<fmt:message key="update_manage_company_result.-999" bundle="${resultLang}"/>';
				
				fancyWarning( title, message, okLabel, function(){} );
			}
			enableSubmitButton();
		});	
	
});


function isFormValid(){
	var result = true;
	errorMessage = '';
	
	if ( $('#stockCode').val() == null || $('#stockCode').val() == "" ){
		result = false;
		errorMessage = 'Stock Code should not be empty';
	}
	return result;
}

</c:if>
<c:if test="${not empty cancelPendingAction}">
$('#btn_cancel_pending').click(function () {
	$(this).closest("form").attr('action', '${cancelPendingAction}');
    $('#userForm').submit();
});
</c:if>

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