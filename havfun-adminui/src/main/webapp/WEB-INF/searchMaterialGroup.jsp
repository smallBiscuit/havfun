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
		<div id="nav_path"><fmt:message key="group_material_group" bundle="${labelLang}"/>  > <strong><fmt:message key="${navigator}" bundle="${labelLang}"/></strong></div>
		<div id="keyframe">
			
			<div class="portfoliotabelCell">
				<table width="906" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="70"><strong><fmt:message key="material_group_id" bundle="${labelLang}"/></strong></td>
						<td width="70"><strong><fmt:message key="material_group_name_en" bundle="${labelLang}"/></strong></td>
						<td width="70"><strong><fmt:message key="material_group_parent_id" bundle="${labelLang}"/></strong></td>
						<td width="200"><strong><fmt:message key="material_group_active" bundle="${labelLang}"/></strong></td>
						<td width="200"><strong><fmt:message key="material_group_create_timestamp" bundle="${labelLang}"/></strong></td>
						<td width="200"><strong><fmt:message key="material_group_last_modified_timestamp" bundle="${labelLang}"/></strong></td>
						<td width="90"></td>
					</tr>
					<c:choose>
						<c:when test="${empty materialGroupList}">
							<tr>
								<td colspan="6">No Related Data</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${materialGroupList}" var="materialGroup" varStatus="status">
								<tr id="row_${status.index}">
									<td><div class="material_group_id">${materialGroup.materialGroupId}</div></td>
									<td>${materialGroup.nameEn}</td>
									<td>${materialGroup.parentId}</td>
									<td>${materialGroup.active}</td>								
									<td>${materialGroup.createTimestamp}</td>									
									<td>${materialGroup.lastModifiedTimestamp}</td>
									<td>
										<div class="btn_common_small btn_materials">Materials</div>
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

$('.btn_materials').on('click', function(){
	
	var index = $(this).closest('tr').attr('id').replace('row_', '');
	
	var materialGroupId = $(this).closest('tr').find('.material_group_id').text();
	
	window.location.href = 'SearchMaterial?materialGroupId=' + materialGroupId;	
	
});

$('.material_group_id').on('click', function(){

	var materialGroupId = $(this).text();
	
	window.location.href = 'EnquireMaterialGroup?materialGroupId=' + materialGroupId;
	
});

</script>

</body>
</html>