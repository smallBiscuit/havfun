<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${SelectedLang}" scope="request"/>
<fmt:setBundle basename="Messages" var="msg"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HavFun</title>
<link href="css/smoothness/jquery-ui-1.10.4.custom.css" rel="stylesheet">
<link type="text/css" href="css/style.css" rel="stylesheet" />
<script src="js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
</head>
<body>
<div id="wrapper">
	<jsp:include page="header.jsp" flush="true"/>
	<jsp:include page="menu.jsp" flush="true"/>
	<div id="mainContent">
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	</div>
	<div class="clear"></div>

	<jsp:include page="footer.jsp" flush="true"/>
</div>


</body>
</html>