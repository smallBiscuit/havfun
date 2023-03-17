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
			<div id="tabs">
				<ul>
					<li><a href="#tabs_product_basic_info" id="basic_info"><strong><fmt:message key="product_basic_info" bundle="${labelLang}"/></strong></a></li>
					<li><a href="#tabs_product_customize_product" id="customize_product_base"><strong><fmt:message key="customize_product_base" bundle="${labelLang}"/></strong></a></li>

				</ul>
				
			<div id="tabs_product_basic_info">
			<table width="906px" border="0" cellpadding="1" cellspacing="0">

				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_id}" value="${dataImage.productId}" origValue="${origDataImage.productId}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_group_id}" choiceList="${productGroupList}" labelList="${productGroupLabelList}" value="${dataImage.productGroupId}" origValue="${origDataImage.productGroupId}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_name_en}" value="${dataImage.nameEn}" origValue="${origDataImage.nameEn}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_name_hk}" value="${dataImage.nameHk}" origValue="${origDataImage.nameHk}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_name_cn}" value="${dataImage.nameCn}" origValue="${origDataImage.nameCn}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_thumbnail_url}" value="${dataImage.thumbnailUrl}" origValue="${origDataImage.thumbnailUrl}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_designer_client_id}" value="${dataImage.designerClientId}" origValue="${origDataImage.designerClientId}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_model}" value="${dataImage.model}" origValue="${origDataImage.model}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_stock}" value="${dataImage.stock}" origValue="${origDataImage.stock}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_manufacturer_id}" value="${dataImage.manufacturerId}" origValue="${origDataImage.manufacturerId}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_price}" value="${dataImage.price}" origValue="${origDataImage.price}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_available_date}" value="${dataImage.availableDate}" origValue="${origDataImage.availableDate}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_weight}" value="${dataImage.weight}" origValue="${origDataImage.weight}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_length}" value="${dataImage.length}" origValue="${origDataImage.length}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_width}" value="${dataImage.width}" origValue="${origDataImage.width}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_height}" value="${dataImage.height}" origValue="${origDataImage.height}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_sorting_order}" value="${dataImage.sortingOrder}" origValue="${origDataImage.sortingOrder}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_stock_status}" choiceList="${stockStatusList}" value="${dataImage.stockStatus.value}" origValue="${origDataImage.stockStatus.value}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_status}" choiceList="${productStatusList}" value="${dataImage.productStatus.value}" origValue="${origDataImage.productStatus.value}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_create_timestamp}" value="${dataImage.createTimestamp}" origValue="${origDataImage.createTimestamp}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_last_modified_timestamp}" value="${dataImage.lastModifiedTimestamp}" origValue="${origDataImage.lastModifiedTimestamp}"></ari:webComponent></tr>			

			</table>
			</div>
			
			
			<div id="tabs_product_customize_product">
				<table width="906px" border="0" cellpadding="1" cellspacing="0">
					<tr>
						<td width="20%"></td>
						<td width="30%"></td>
						<td width="20%"></td>
						<td width="30%"></td>
					</tr>
					<tr>
						<td>Customize Product</td>
					</tr>
					<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${product_customize_product_base}" value="${dataImage.customizeProductBase}" origValue="${origDataImage.customizeProductBase}"></ari:webComponent></tr>
					
				</table>
			</div>
			
			<table width="906px" border="0" cellpadding="1" cellspacing="0">




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

							<c:if test="${action == 'CreateProductRequest'}">	
								<fmt:message key="common_create" bundle="${labelLang}"/>
							</c:if>
							<c:if test="${action == 'UpdateProductRequest'}">	
								<fmt:message key="common_update" bundle="${labelLang}"/>
							</c:if>
							<c:if test="${action == 'ConfirmProductRequest'}">	
								<fmt:message key="common_confirm" bundle="${labelLang}"/>
							</c:if>
						</div>
						</c:if>
					</td>
				</tr>
				</c:if>
			</table>
		</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" flush="true"/>
</div>

<jsp:include page="common-script.jsp" flush="true"/>

<script>

var errorMessage = '';

$(function() {
	$( "#tabs" ).tabs();
});
  
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

$('#product_image').on('change', function(){
	
	readImageURL( '#product_image' );
	
});


$(document).on('click', '.btn_remove', function(){
	
	$(this).closest('.data_row').remove();
		
	refreshCustomizeProductDetailsListSetting( '#customize_product_color_details_table .data_row' );
	
	$(document).find( '.customize_product_border_details_table' ).each( function(){
		
		var selectorId = $( this ).attr( 'id' );
		
		refreshCustomizeProductDetailsListSetting( '#' + selectorId + ' .data_row' );		
		
	});
	
});

$(document).on('click', '.btn_add_row', function(){
	
	var sourceCodeSelector = $(this).attr('data-add-row-html-source');
	var sourceCode = $('#' + sourceCodeSelector ).html();
	var targetSelector = $(this).attr('data-add-row-target');
	
	$('#' + targetSelector ).append( sourceCode );
	
	refreshCustomizeProductDetailsListSetting( '#customize_product_color_details_table .data_row' );
	
	$(document).find( '.customize_product_border_details_table' ).each( function(){
		
		var selectorId = $( this ).attr( 'id' );
		
		refreshCustomizeProductDetailsListSetting( '#' + selectorId + ' .data_row' );		
		
	});

	
});


function refreshCustomizeProductDetailsListSetting( rowClassSelector ){
	
	var index = 0;
	
	$(document).find( rowClassSelector ).each( function(){
		
		$(this).removeClass('searchResultTableRowOdd');
		$(this).removeClass('searchResultTableRowEven');
		
		if ( index%2 == 0 ){
			
			$(this).addClass('searchResultTableRowOdd');
			
		}else{
			
			$(this).addClass('searchResultTableRowEven');
			
		}
		
		$(this).find('.web_component_input').each( function(){
			
			var currKey = $( this ).data('key');
			
			$( this ).attr('id', currKey + '_' + index);
			
			$( this ).attr('name', currKey + '_' + index);
			
			
		});
		
		index ++;
	});
	
}


$('.add_customize_product_base_view').click(function () {

	var index = 0;
	var foundFlag = true;
	
	while( foundFlag ){
		
		if ( $('#customize_product_base_view_title_' + index ).length ){
			
			index ++;			
			
		}else{
			
			foundFlag = false;
			
		}		

	}
	
	var url = 'EnquireCustomizeProductBaseViewRequest?index=' + index;
	
 	$.ajax({
		url : url,
          	type : "GET",
          	dataType : "json",
          	success : function(dataObj) {
				
          		var htmlCode = dataObj.htmlCode;
          		
          		$('#customize_product_view_list_last').before( htmlCode );

          	}
		}).fail(function(){
			

		});	
	
});

</script>

</body>
</html>