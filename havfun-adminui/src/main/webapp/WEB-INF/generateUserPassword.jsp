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
<link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css" media="screen" />
<script src="js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script src="js/common-basic.js"></script>
<script type="text/javascript" src="js/jquery.fancybox.js"></script>


</head>
<body>
<div id="wrapper">
	<jsp:include page="header.jsp" flush="true"/>
	<jsp:include page="menu.jsp" flush="true"/>
	<div id="mainContent">
	

		<div id=generate_client_password>
	
			<div id="generate-client_password_content">
		
			</div>
		</div>	

	</div>
	<div class="clear"></div>
	<jsp:include page="footer.jsp" flush="true"/>
</div>

<script>

	$(document).ready(function(){
		<c:choose>
		<c:when test="${result == 0}">
			
			var title = "<fmt:message key="generate_password_success" bundle="${resultLang}"/>";
			var msg = "<fmt:message key="generate_password_result.${result}" bundle="${resultLang}"/>";
			var okLabel = "<fmt:message key="common_back_home" bundle="${labelLang}"/>";
			var url = "Login";
			fancyNotice(title, msg, okLabel, function(){ window.location.href = url;} );
		</c:when>
		<c:otherwise>
			var title = "<fmt:message key="generate_password_fail" bundle="${resultLang}"/>";
			var msg = "<fmt:message key="generate_password_result.-1" bundle="${resultLang}"/> (${result})";
			var okLabel = "<fmt:message key="common_back_home" bundle="${labelLang}"/>";
			var url = "Login";
			fancyWarning(title, msg, okLabel, function(){ window.location.href = url;} );
		</c:otherwise>
		</c:choose>
	});

</script>
</body>
</html>