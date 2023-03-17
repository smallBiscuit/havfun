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

<link rel="stylesheet" type="text/css" href="css/smoothness/jquery-ui-1.10.4.custom.css"/>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css" media="screen" />
	
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.4.custom.js"></script>
<script type="text/javascript" src="js/jquery.fancybox.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/common-basic.js"></script>

</head>
<body>
	<div id="wrapper">
		<jsp:include page="header.jsp" flush="true" />
		<jsp:include page="menu.jsp" flush="true" />
		<div id="mainContent">
			<div class="clear"></div>
			<div id="nav_path"><fmt:message key="group_company" bundle="${labelLang}"/>  > <strong><fmt:message key="${navigator}" bundle="${labelLang}"/></strong></div>
			<div id="keyframe">
				<div class="portfoliotabelCell">
					<div style="float:left;margin-right:10px;"><fmt:message key="stockCode" bundle="${labelLang}"/>:</div>
					<div style="float:left;margin-right:50px;"><input type="text" id="keyword" name="keyword" value="${keyword}"/></div>

					<div style="float:left;margin-right:10px;"><fmt:message key="status" bundle="${labelLang}"/>:</div>
						<div style="float:left;">
							<select id="company_status_selection">
								<c:forEach items="${statusList}" var="statusOption">
									<c:choose>
										<c:when test="${statusOption == companyStatus}">
												<option value="${statusOption}" selected>
													<fmt:message key="announcementStatus.${statusOption}" bundle="${labelLang}"/>
												</option>
										</c:when>
										<c:otherwise>
											<option value="${statusOption}" >
												<fmt:message key="announcementStatus.${statusOption}" bundle="${labelLang}"/>
											</option>									
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>			
											
					<table class="searchResultTable">
						<tr>							
							<td width="100"><strong><fmt:message key="companyId" bundle="${labelLang}"/></strong></td>
							<td width="100"><strong><fmt:message key="stockCode" bundle="${labelLang}"/></strong></td>
							<td width="150"><strong><fmt:message key="shortNameEn" bundle="${labelLang}"/></strong></td>
							<td width="150"><strong><fmt:message key="shortNameHk" bundle="${labelLang}"/></strong></td>
							<td width="150"><strong><fmt:message key="shortNameCn" bundle="${labelLang}"/></strong></td>
							<td width="50"><strong><fmt:message key="common_status" bundle="${labelLang}"/></strong></td>
							<td width="100"></td>
							<td width="50"></td>
						</tr>
						<c:choose>
							<c:when test="${empty companyList}">
								<tr>
									<td colspan="8"></td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${companyList}" var="company" varStatus="status">
									<c:set var="isManageCompany" value="${0}"/>
									<c:forEach items="${manageCompanyList}" var="manageCompany">
										<c:choose>
											<c:when test="${manageCompany.companyId == company.companyId }">
												<c:set var="isManageCompany" value="${1}"/>
											</c:when>													
										</c:choose>
									</c:forEach>								
									
									<c:choose>
										<c:when test="${isManageCompany==1}">
											<tr class="searchResultTableRowHighlight" id="rowNum_${status.index}">
										</c:when>
										<c:when test="${status.index % 2 == 0}">
											<tr class="searchResultTableRowEven" id="rowNum_${status.index}">
										</c:when>
										<c:otherwise>
											<tr class="searchResultTableRowOdd" id="rowNum_${status.index}">
										</c:otherwise>				
									</c:choose>

										<td><div class="companyId">${company.companyId}</div></td>
										<td><div class="stockCode">${company.stockCode}</div></td>
										<td><div >${company.shortNameEn}</div></td>
										<td><div >${company.shortNameHk}</div></td>
										<td><div >${company.shortNameCn}</div></td>
										<td><div >${company.companyStatus}</div></td>
										<td>
											<c:if test="${not empty CreateAnnouncementRequest}">
											<div class="btn_add_doc btn_common_small">
												<fmt:message key="common_add_doc" bundle="${labelLang}"/>
											</div>
											</c:if>											
										</td>
										<td>											
											
											<c:choose>
												<c:when test="${isManageCompany==1}">			
													<c:if test="${not empty RemoveManageCompanyRequest}">										
														<div class="btn_common_sell_small btn_un_manage">
															<fmt:message key="common_un_manage" bundle="${labelLang}"/>
														</div>
													</c:if>
												</c:when>
												<c:otherwise>
													<c:if test="${not empty CreateManageCompanyRequest}">		
														<div class="btn_common_small btn_set_manage">
															<fmt:message key="common_set_manage" bundle="${labelLang}"/>
														</div>
													</c:if>
												</c:otherwise>
											</c:choose>
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
	
	$(document).ready(function(){
		
		$('#keyword').select();
		
	});
	
	$('.searchResultTableRowHighlight, .searchResultTableRowEven, .searchResultTableRowOdd').on('click', function(event){
		
		if ( $(event.target).hasClass('btn_add_doc' ) ) {
			
			onClickAddDoc( event.target );
			
		}else if ( $(event.target).hasClass('btn_set_manage' ) ) {
			
			onClickSetManage( event.target );
		
		}else if ( $(event.target).hasClass('btn_un_manage' ) ) {
		
			onClickUnSetManage( event.target );
		
		}else{
			var companyId = $(this).find('.companyId').text();
			var stockCode = $(this).find('.stockCode').text();
			
			window.location.href = 'EnquireCompany?companyId=' + encodeURIComponent(companyId);			
		}
		
	});
	
	$("#company_status_selection").on('change', function (e) {		
		refreshSearchCompany();	  
	});			
	
	$(document).keyup(function(e) {
		
		if (e.keyCode == 13){
			
			refreshSearchCompany();
			
		}
		
	});
	
	function refreshSearchCompany(){

		var selectedStatus = $('#company_status_selection option').eq($('#company_status_selection option:selected').index() ).val();
				
		window.location.href = "SearchCompany?keyword=" + encodeURIComponent($('#keyword').val())  + '&companyStatus='+ encodeURIComponent(selectedStatus);
		
		
	}
	
	function onClickAddDoc( sender ){

		var companyId = $(sender).parent().parent().find('.companyId').text();
		var stockCode = $(sender).parent().parent().find('.stockCode').text();		
		
		window.location.href = "CreateAnnouncement?stockCode="+ encodeURIComponent(stockCode);
		
		
	}
		
	function onClickSetManage( sender ){
		var companyId = $(sender).parent().parent().find('.companyId').text();
		var stockCode = $(sender).parent().parent().find('.stockCode').text();

		var title = "<fmt:message key="manage_company_set_manage_company_title" bundle="${labelLang}"/>";
		var msg = "<fmt:message key="manage_company_set_manage_company_content" bundle="${labelLang}"/>";
		
		var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
		var cancelLabel = "<fmt:message key="common_cancel" bundle="${labelLang}"/>";
		
		var callbackYes = function(){
			gotoSetManageCompany(companyId, stockCode);
		};
		var callbackNo = function(){};
		
		fancyConfirm(title, msg, okLabel, cancelLabel, callbackYes, callbackNo);
	}
	
	function onCLickUnSetManage( sender){

		var companyId = $(sender).parent().parent().find('.companyId').text();
		var stockCode = $(sender).parent().parent().find('.stockCode').text();

		var title = "<fmt:message key="manage_company_remove_manage_company_title" bundle="${labelLang}"/>";
		var msg = "<fmt:message key="manage_company_remove_manage_company_content" bundle="${labelLang}"/>";
		
		var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
		var cancelLabel = "<fmt:message key="common_cancel" bundle="${labelLang}"/>";
		
		var callbackYes = function(){
			gotoRemoveManageCompany(companyId, stockCode);
		};
		var callbackNo = function(){};
		
		fancyConfirm(title, msg, okLabel, cancelLabel, callbackYes, callbackNo);	
	};
		
	function gotoRemoveManageCompany(companyId, stockCode ){
					
		var url = "RemoveManageCompanyRequest?companyId=" +companyId + "&stockCode="+ stockCode;
		var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
		var successTitle = "<fmt:message key="remove_manage_company_success" bundle="${resultLang}"/>";
		var successMessage = "<fmt:message key="remove_manage_company_result.0" bundle="${resultLang}"/>";
		var successFunction = function(){
			refreshSearchCompany();
		};
		var failTitle = "<fmt:message key="remove_manage_company_fail" bundle="${resultLang}"/>";
		var failMessage = "<fmt:message key="remove_manage_company_result.-1" bundle="${resultLang}"/>";
		var failFunction = function(){};
		
		runAjaxService( url, okLabel, successTitle, successMessage, successFunction, failTitle, failMessage, failFunction );		
	}
	
	function gotoSetManageCompany(companyId, stockCode){
	
		var url = "CreateManageCompanyRequest?companyId=" +companyId + "&stockCode="+ stockCode;
		var okLabel = "<fmt:message key="common_ok" bundle="${labelLang}"/>";
		var successTitle = "<fmt:message key="create_manage_company_success" bundle="${resultLang}"/>";
		var successMessage = "<fmt:message key="create_manage_company_result.0" bundle="${resultLang}"/>";
		var successFunction = function(){
			refreshSearchCompany();
		};
		var failTitle = "<fmt:message key="create_manage_company_fail" bundle="${resultLang}"/>";
		var failMessage = "<fmt:message key="create_manage_company_result.-1" bundle="${resultLang}"/>";
		var failFunction = function(){};
		
		runAjaxService( url, okLabel, successTitle, successMessage, successFunction, failTitle, failMessage, failFunction );
		
	}
	
	</script>
</body>
</html>