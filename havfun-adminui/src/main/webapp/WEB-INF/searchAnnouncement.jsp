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

<link href="css/smoothness/jquery-ui-1.10.4.custom.css" rel="stylesheet">
<link type="text/css" href="css/style.css" rel="stylesheet" />

<script src="js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script type="text/javascript" src="js/common-basic.js"></script>

</head>
<body>
	<div id="wrapper">
		<jsp:include page="header.jsp" flush="true" />
		<jsp:include page="menu.jsp" flush="true" />
		<div id="mainContent">
			<div class="clear"></div>
			<div id="nav_path"><fmt:message key="group_announcement" bundle="${labelLang}"/>  > <strong><fmt:message key="${navigator}" bundle="${labelLang}"/></strong></div>
			<div id="keyframe">
				<!--
				<form id="searchAnnouncementForm" action="SearchAnnouncement" method="post">
					<table width="800px" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><fmt:message key="userId" bundle="${labelLang}"/>:</td>
							<td>
								<div class="enquire_input">
									<input id="userId" name="userId" type="text" style="width: 200px"
										maxlength="7">
								</div>
							</td>
							<td><fmt:message key="userLoginId" bundle="${labelLang}"/>:</td>
							<td>
								<div class="enquire_input">
									<input id="userLoginId" name="userLoginId" type="text" style="width: 200px"
										maxlength="20">
								</div>
							</td>
							<td></td>
						</tr>
						<tr>
							<td><fmt:message key="status" bundle="${labelLang}"/>:</td>
							<td>
								<div class="search_input">
									<select style="width: 205px" id="userStatus"
										name="userStatus">
										<c:forEach items="${userStatusOptionList}"
											var="userStatus">
											<option value="${userStatus}"><fmt:message
													key="userStatus.${userStatus}" bundle="${labelLang}" /></option>
										</c:forEach>
									</select>
								</div>
							</td>
							<td><fmt:message key="approvalStatus" bundle="${labelLang}"/>:</td>
							<td>
								<div class="search_input">
									<select style="width: 205px" id="approvalStatus"
										name="approvalStatus">
										<c:forEach items="${approvalStatusOptionList}"
											var="approvalStatus">
											<option value="${approvalStatus}"><fmt:message
													key="approvalStatus.${approvalStatus}"
													bundle="${labelLang}" /></option>
										</c:forEach>
									</select>
								</div>
							</td>
							<td><div class="btn_ok_small" id="btn_ok"></div></td>
						</tr>
					</table>
					<input type="hidden" name="search" value="yes">
				</form>
				-->
				<br>
				<div class="portfoliotabelCell">
					
					<c:if test="${not empty isAdmin }">
					
						<div style="float:left;margin-right:10px;"><fmt:message key="stockCode" bundle="${labelLang}"/>:</div>
						<div style="float:left;margin-right:50px;"><input type="text" id="keyword" name="keyword" value="${stockCode}"/></div>					
											
					</c:if>
					
						<div style="float:left;margin-right:10px;"><fmt:message key="status" bundle="${labelLang}"/>:</div>
						<div style="float:left;">
							<select id="announcement_status_selection">
								<c:forEach items="${statusList}" var="statusOption">
									<c:choose>
										<c:when test="${statusOption == announcementStatus}">
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
					
					
					<table width="906" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="100"><strong><fmt:message key="announcementId" bundle="${labelLang}"/></strong></td>
							<td width="200"><strong><fmt:message key="releaseTimestamp" bundle="${labelLang}"/></strong></td>
							<td width="100"><strong><fmt:message key="stockCode" bundle="${labelLang}"/></strong></td>
							<td width="100"><strong><fmt:message key="announcementTitle" bundle="${labelLang}"/></strong></td>
							<td width="306"><strong><fmt:message key="announcementTitleCn" bundle="${labelLang}"/></strong></td>
							<td width="306"><strong><fmt:message key="announcementType" bundle="${labelLang}"/></strong></td>
							<td width="106"><strong><fmt:message key="languageFlag" bundle="${labelLang}"/></strong></td>							
							<td width="100"><strong><fmt:message key="uniqueName" bundle="${labelLang}"/></strong></td>
							<td width="100"><strong><fmt:message key="announcementStatus" bundle="${labelLang}"/></strong></td>
						</tr>
						<c:choose>
							<c:when test="${empty announcementList}">
								<tr>
									<td colspan="8"></td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${announcementList}" var="announcement">
									<tr>
										<td><a
											href="EnquireAnnouncement?announcementId=${announcement.announcementId}">${announcement.announcementId}</a></td>
										<td><div class="format_date">${announcement.releaseTimestamp}</div></td>
										<td>${announcement.stockCode}</td>
										<td>${announcement.announcementTitle}</td>
										<td>${announcement.announcementTitleCn}</td>										
										<td><fmt:message key="announcementType.${announcement.announcementType.announcementTypeCode}" bundle="${labelLang}"/></td>											
										<td><fmt:message key="languageFlag.${announcement.languageFlag.value}" bundle="${labelLang}"/></td>
										<td>${announcement.uniqueName}</td>
										<td>${announcement.announcementStatus}</td>
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
		$('#btn_ok').click(function() {
			$('#searchAnnouncementForm').submit();
		});	
	

		$(document).ready(function(){
			
			$('#keyword').select();
			
			$('.format_date').each(function(){
				
				var timestamp = parseInt( $(this).text() );
				if ( timestamp != null && timestamp > 0 ){
					$(this).text( timestampToDisplay( timestamp, true) );
				}
			});
			
		});			
		
		$("#announcement_status_selection").on('change', function (e) {		
		  	refreshSearchAnnouncement();	  
		});		
		
		$(document).keyup(function(e) {
			
			if (e.keyCode == 13){
				
				refreshSearchAnnouncement();
				
			}
			
		});	
		
		function refreshSearchAnnouncement(){
			var selectedStatus = $('#announcement_status_selection option').eq($('#announcement_status_selection option:selected').index() ).val();
			
			window.location.href = "SearchAnnouncement?stockCode=" + encodeURIComponent($('#keyword').val()) + '&announcementStatus='+ encodeURIComponent(selectedStatus);
			
		}
		
	</script>
</body>
</html>