<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setLocale value="${SelectedLang}" scope="request" />
<fmt:setBundle basename="Label" var="labelLang"/>
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
	<jsp:include page="header.jsp" flush="true" />
	<jsp:include page="menu.jsp" flush="true" />
	<div id="mainContent">
		<div class="clear"></div>
		<div id="nav_path"><fmt:message key="group_user" bundle="${labelLang}"/>  > <strong><fmt:message key="${navigator}" bundle="${labelLang}"/></strong></div>
		<div id="keyframe">
			
			<div class="portfoliotabelCell">
				<table width="906" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="100"><strong><fmt:message key="order_id" bundle="${labelLang}"/></strong></td>
						<td width="100"><strong><fmt:message key="order_invoice_no" bundle="${labelLang}"/></strong></td>
						<td width="100"><strong><fmt:message key="common_client_id" bundle="${labelLang}"/></strong></td>
						<td width="100"><strong><fmt:message key="common_name" bundle="${labelLang}"/></strong></td>
						<td width="100"><strong><fmt:message key="order_total" bundle="${labelLang}"/></strong></td>
						<td width="100"><strong><fmt:message key="order_status" bundle="${labelLang}"/></strong></td>
						
					</tr>
					<c:choose>
						<c:when test="${empty orderList}">
							<tr>
								<td colspan="6">No Related Data</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${orderList}" var="order">
								<tr>
									<td><a
										href="EnquireOrder?orderId=${order.orderId}">${order.orderId}</a></td>
										
										
									<td>${order.orderId}</td>
									<td>${order.invoiceNo}</td>
									<td>${order.clientId}</td>
									<td>${order.firstName} ${order.lastName}</td>
									<td>${order.currencyCode}${order.total}</td>
									<td>${order.status}</td>

									<td></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<jsp:include page="footer.jsp" flush="true" />
</div>

</body>
</html>