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
		<div id="nav_path"><fmt:message key="group_material" bundle="${labelLang}"/>  > <strong><fmt:message key="${navigator}" bundle="${labelLang}"/></strong></div>
		<div id="keyframe">
			
			<div>
				<table width="906" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="25%">Material Group:</td>
						<td width="25%">
							<select id="material_group_id">
								<c:forEach items="${materialGroupValueList}" var="materialGroupValue" varStatus="status">
									<option value="${materialGroupValue}">${materialGroupLabelList[status.index]}</option>
								</c:forEach>
							</select>
						</td>
						<td width="25%"></td>
						<td width="25%"></td>
					</tr>
					
				</table>
			</div>
			<div class="search_material">
				<table width="906" border="0" cellpadding="0" cellspacing="0">
					<tr id="first_row">
						<td width="25%"></td>
						<td width="25%"></td>
						<td width="25%"></td>
						<td width="25%"></td>
					</tr>
					<tr id="last_row">
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<jsp:include page="footer.jsp" flush="true" />
</div>
</body>

<script>

$(document).ready(function(){
	
	onChangeDataList();
	
});

$('#material_group_id').on('change', function(){
	
	onChangeDataList();
	
})

function onChangeDataList(){
	
	fancyLoading();

	cleanDataList();
	
	var materialGroupId = $('#material_group_id').val();
	
	var url = 'SearchMaterialRequest?materialGroupId=' + materialGroupId;
	
	$.ajax({
		url: url,
		type: 'POST',
		dataType: 'JSON'
	})
	.done(function(resultJSON) {
		
		fancyLoadingHide();
		
		var resultMessage = resultJSON.resultMessage;
		var resultCode = resultJSON.resultCode;
		
		if (resultCode === 0 ) {

			updateDataList( resultJSON.dataMapList );
			
		}
		
	})
	.fail(function() {
		var title = 'Fail';

		message = '-999';

		var buttonLabel = 'Ok';

		fancyWarning(title, message, buttonLabel, function() {});
	});

	
}

function cleanDataList(){

	$('.data_row').remove();
	
}

function updateDataList( dataMapList ){
	
	for ( var i = 0; i < dataMapList.length; i ++ ){
		
		if ( i%4 == 0 ){
			insertDataRow( dataMapList, i );
		}
	}
	
}

function insertDataRow( dataMapList, index ){
	
	var htmlCode = '';
	htmlCode += '<tr class="data_row">';
	
	for ( var i = 0; i < 4; i ++ ){
	
		var dataMap = dataMapList[ index + i ];
		var materialId = dataMap.td_material_id;
		var fullImageUrl = dataMap.td_full_image_url;		
		
		htmlCode += '<td>';// + materialId;
		htmlCode += '<image src="' + fullImageUrl + '" style="width:100px;"></image></td>';		
		
		
	}
	
	htmlCode += '</tr>';	
	$('#first_row').after( htmlCode );
	
}

</script>

</html>