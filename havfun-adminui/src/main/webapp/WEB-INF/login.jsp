<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${SelectedLang}" scope="request"/>
<fmt:setBundle basename="Label" var="labelLang"/>
<fmt:setBundle basename="Result" var="resultLang"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HavFun Limited</title>
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
		<table>
			<tr>
				<td><div>User Name:</div></td>
				<td><input id="user_name" name="user_name"/></td>
			</tr>
			<tr>
				<td><div>Password:</div></td>
				<td><input id="user_passcode" name="user_passcode"/></td>
			</tr>
			<tr>
				<td><div></div></td>
				<td>
					<div class="btn_common_small" id="btn_submit">
					<fmt:message key="common_submit" bundle="${labelLang}"/>
					</div>
				</td>
			</tr>
			
		</table>
	</div>
	<div class="clear"></div>
	<jsp:include page="footer.jsp" flush="true"/>
</div>

<script>


$('#btn_submit').on('click', function(){
	
	gotoLogin();
	
});


function gotoLogin(){
	
	var userName = $('#user_name').val();
	var userPasscode = $('#user_passcode').val();

	var url_and_value = 'LoginRequest';
	
	url_and_value += '?username=' + userName;
	
	url_and_value += '&password=' + userPasscode;
	
	$.ajax({
		url : url_and_value,
          	type : "GET",
          	data : {
          			method: "json"
          	},
          	dataType : "json",
          	success : function(dataObj) {
				
				if ( dataObj.result == 0 ){

					window.location.href = dataObj.ref;
					
				}

          	}
		}).fail(function(){
	});
}

</script>

</body>
</html>