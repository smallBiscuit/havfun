<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setLocale value="${SelectedLang}" scope="request" />
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
		<jsp:include page="header.jsp" flush="true" />
		<jsp:include page="menu.jsp" flush="true" />
		<div id="mainContent">
			<div class="clear"></div>
			<div id="nav_path"><fmt:message key="group_manage_company" bundle="${labelLang}"/>  > <strong><fmt:message key="${navigator}" bundle="${labelLang}"/></strong></div>
			<div id="keyframe">
				<div class="portfoliotabelCell">
					<table width="906" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="200"><strong><fmt:message key="companyId" bundle="${labelLang}"/></strong></td>
							<td width="200"><strong><fmt:message key="stockCode" bundle="${labelLang}"/></strong></td>
							<td width="200"></td>
						</tr>
						<c:choose>
							<c:when test="${empty manageCompanyList}">
								<tr>
									<td colspan="6"></td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${manageCompanyList}" var="manageCompany">
									<tr>
										<td><div class="companyId">${manageCompany.companyId}</div></td>
										<td><div class="stockCode">${manageCompany.stockCode}</div></td>
										<td>
											<div class="btn_remove btn_common_sell_small">
												<fmt:message key="common_remove" bundle="${labelLang}"/>
											</div>
										</td>
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
	<script>

		
		$('.btn_remove').click(function(){

			var companyId = $(this).parent().parent().find('.companyId').text();
			var stockCode = $(this).parent().parent().find('.stockCode').text();

			var title = "<fmt:message key="manage_company_remove_manage_company_title" bundle="${labelLang}"/>";
			var msg = "<fmt:message key="manage_company_remove_manage_company_content" bundle="${labelLang}"/>";
			
			var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
			var cancelLabel = "<fmt:message key="common_cancel" bundle="${labelLang}"/>";
			
			var callbackYes = function(){
				gotoRemoveManageCompany(companyId, stockCode);
			};
			var callbackNo = function(){};
			
			fancyConfirm(title, msg, okLabel, cancelLabel, callbackYes, callbackNo);	
		});
		
		function gotoRemoveManageCompany(companyId, stockCode ){
						
			fancyLoading();
			
			var title = "";
			var message = "";
			var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
			
			var url = 'RemoveManageCompanyRequest?companyId='+companyId +'&stockCode='+stockCode;
			$.ajax({
				url : url,
		          	type : "GET",
		          	data : {
		          			method: "json"
		          	},
		          	dataType : "json",
		          	success : function(dataObj) {

						if ( dataObj.result == 0 ){			
							title = '<fmt:message key="remove_manage_company_success" bundle="${resultLang}"/>';
							message = '<fmt:message key="remove_manage_company_result.0" bundle="${resultLang}"/>';
								
							fancyNotice( title, message, okLabel, function(){
								window.location.href = 'SearchManageCompany';
							});
						}else if ( dataObj.result == -2 ){
							title = '<fmt:message key="remove_manage_company_fail" bundle="${resultLang}"/>';
							message = '<fmt:message key="remove_manage_company_result.-1" bundle="${resultLang}"/>';
							
							fancyWarning( title, message, okLabel, function(){} );
						}
		          	}
				}).fail(function(){
					title = '<fmt:message key="remove_manage_company_fail" bundle="${resultLang}"/>';
					message = '<fmt:message key="remove_manage_company_result.-999" bundle="${resultLang}"/>';
					
					fancyWarning( title, message, okLabel, function(){} );
				});	
		}
	</script>
</body>
</html>