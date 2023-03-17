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

<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.4.custom.js"></script>
<script type="text/javascript" src="js/jquery.fancybox.js"></script>
<script type="text/javascript" src="js/common-basic.js"></script>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
<link type="text/css" rel="stylesheet" href="css/smoothness/jquery-ui-1.10.4.custom.css" >
<link type="text/css" rel="stylesheet" href="css/jquery.fancybox.css" media="screen" />

</head>
<body>

<div id="wrapper">
	<jsp:include page="header.jsp" flush="true"/>
	<jsp:include page="menu.jsp" flush="true"/>
	
	<div id="mainContent">
		<div id="nav_path"><fmt:message key="group_user" bundle="${labelLang}"/>  > <strong><fmt:message key="${navigator}" bundle="${labelLang}"/></strong></div>
		<div id="keystock">
			<form enctype="multipart/form-data">
				<table width="906px" border="0" cellpadding="1" cellspacing="0">
	
					<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${user_id}" value="${dataImage.userId}" origValue="${origDataImage.userId}"></ari:webComponent></tr>
					<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${user_group}" choiceList="${userGroupList}" value="${dataImage.userGroup.value}" origValue="${origDataImage.userGroup.value}"></ari:webComponent></tr>
					<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${user_name}" value="${dataImage.userName}" origValue="${origDataImage.userName}"></ari:webComponent></tr>
					<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${user_passcode}" value="${dataImage.passcode}" origValue="${origDataImage.passcode}"></ari:webComponent></tr>
					<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${user_first_name}" value="${dataImage.firstName}" origValue="${origDataImage.firstName}"></ari:webComponent></tr>
					<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${user_last_name}" value="${dataImage.lastName}" origValue="${origDataImage.lastName}"></ari:webComponent></tr>
					<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${user_email}" value="${dataImage.email}" origValue="${origDataImage.email}"></ari:webComponent></tr>
					<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${user_status}" choiceList="${userStatusList}" value="${dataImage.status.value}" origValue="${origDataImage.status.value}"></ari:webComponent></tr>
					<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${user_create_timestamp}" value="${dataImage.createTimestamp}" origValue="${origDataImage.createTimestamp}"></ari:webComponent></tr>					
					
	
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
	
								<c:if test="${action == 'CreateUserRequest'}">	
									<fmt:message key="common_create" bundle="${labelLang}"/>
								</c:if>
								<c:if test="${action == 'UpdateUserRequest'}">	
									<fmt:message key="common_update" bundle="${labelLang}"/>
								</c:if>
								<c:if test="${action == 'ConfirmUserRequest'}">	
									<fmt:message key="common_confirm" bundle="${labelLang}"/>
								</c:if>
							</div>
							</c:if>
						</td>
					</tr>
					</c:if>
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp" flush="true"/>
</div>

<jsp:include page="common-script.jsp" flush="true"/>

<script>

var errorMessage = '';

$('#btn_ok').click(function () {

	if ( !isFormValid() ){
		showErrorMessage( errorMessage);

		return;
	}
	
	if ($('form').attr("enctype") == 'multipart/form-data') {
		data = new FormData($('form')[0]);
	}
	
	genericFormSubmition('${action}', data, '${button.result}', null);
	
});


function isFormValid(){
	
	var result = true;
	errorMessage = '';
	
	/*
	if ( $('#user_name').val() == null || $('#userName').val() == "" ){
		result = false;
		errorMessage = 'User Name should not be empty';
	}else if ( $('#email').val() == null || $('#email').val() == "" ){
		result = false;
		errorMessage = 'Email should not be empty';
	}else if ( $('#email').val().indexOf( '@' ) < 0){
		result = false;
		errorMessage = 'Format of email is invalid';
	}
	*/
	return result;
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