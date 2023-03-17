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
			<table width="906px" border="0" cellpadding="1" cellspacing="0">

				<tr>
					<td width="20%"></td>
					<td width="30%"></td>
					<td width="20%"></td>
					<td width="30%"></td>
				</tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_id}" value="${dataImage.orderId}" origValue="${origDataImage.orderId}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_invoice_no}" value="${dataImage.invoiceNo}" origValue="${origDataImage.invoiceNo}"></ari:webComponent></tr>
				<tr>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_store_id}" value="${dataImage.storeId}" origValue="${origDataImage.storeId}"></ari:webComponent>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_store_name}" value="${dataImage.storeName}" origValue="${origDataImage.storeName}"></ari:webComponent>
				</tr>
				
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_store_url}" value="${dataImage.storeUrl}" origValue="${origDataImage.storeUrl}"></ari:webComponent></tr>
				
				<tr>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_client_id}" labelKey="client_id" value="${dataImage.clientId}" origValue="${origDataImage.clientId}"></ari:webComponent>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_client_group}" labelKey="client_group" value="${dataImage.clientGroup}" origValue="${origDataImage.clientGroup}"></ari:webComponent>
				</tr>
				
				<tr>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_first_name}" labelKey="client_first_name" value="${dataImage.firstName}" origValue="${origDataImage.firstName}"></ari:webComponent>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_last_name}" labelKey="client_last_name" value="${dataImage.lastName}" origValue="${origDataImage.lastName}"></ari:webComponent>
				</tr>
				
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_email}" labelKey="client_email" value="${dataImage.email}" origValue="${origDataImage.email}"></ari:webComponent></tr>
				
				<tr>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_telephone}" labelKey="client_telephone" value="${dataImage.telephone}" origValue="${origDataImage.telephone}"></ari:webComponent>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_fax}" labelKey="client_fax" value="${dataImage.fax}" origValue="${origDataImage.fax}"></ari:webComponent>
				</tr>
				
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_product_list}" value="${dataImage.orderProductList}" origValue="${origDataImage.orderProductList}"></ari:webComponent></tr>
				
				<tr><td colspan="2" class="form_label"><fmt:message key="order_billing_address" bundle="${labelLang}"/>:</td></tr>
				<tr>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_billing_first_name}" labelKey="client_first_name" value="${dataImage.billingFirstName}" origValue="${origDataImage.billingFirstName}"></ari:webComponent>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_billing_last_name}" labelKey="client_last_name" value="${dataImage.billingLastName}" origValue="${origDataImage.billingLastName}"></ari:webComponent>
				</tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_billing_address1}" labelKey="address_address_1" value="${dataImage.billingAddress1}" origValue="${origDataImage.billingAddress1}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_billing_address2}" labelKey="address_address_2" value="${dataImage.billingAddress2}" origValue="${origDataImage.billingAddress2}"></ari:webComponent></tr>
				
				
				<tr>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_billing_city}" labelKey="address_city" value="${dataImage.billingCity}" origValue="${origDataImage.billingCity}"></ari:webComponent>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_billing_postcode}" labelKey="address_postcode" value="${dataImage.billingPostcode}" origValue="${origDataImage.billingPostcode}"></ari:webComponent>
				</tr>
				<tr>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_billing_country_id}" labelKey="address_country" value="${dataImage.billingCountryId}" origValue="${origDataImage.billingCountryId}"></ari:webComponent>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_billing_telephone}" labelKey="client_telephone" value="${dataImage.billingTelephone}" origValue="${origDataImage.billingTelephone}"></ari:webComponent>
				</tr>
				
				<tr><td colspan="2" class="form_label"><fmt:message key="order_shipping_address" bundle="${labelLang}"/>:</td></tr>
				<tr>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_shipping_first_name}" labelKey="client_first_name" value="${dataImage.shippingFirstName}" origValue="${origDataImage.shippingFirstName}"></ari:webComponent>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_shipping_last_name}" labelKey="client_last_name" value="${dataImage.shippingLastName}" origValue="${origDataImage.shippingLastName}"></ari:webComponent>
				</tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_shipping_address1}" labelKey="address_address_1" value="${dataImage.shippingAddress1}" origValue="${origDataImage.shippingAddress1}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_shipping_address2}" labelKey="address_address_2" value="${dataImage.shippingAddress2}" origValue="${origDataImage.shippingAddress2}"></ari:webComponent></tr>

				<tr>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_shipping_city}" labelKey="address_city" value="${dataImage.shippingCity}" origValue="${origDataImage.shippingCity}"></ari:webComponent>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_shipping_postcode}" labelKey="address_postcode" value="${dataImage.shippingPostcode}" origValue="${origDataImage.shippingPostcode}"></ari:webComponent>
				</tr>
				<tr>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_shipping_country_id}" labelKey="address_country" value="${dataImage.shippingCountryId}" origValue="${origDataImage.shippingCountryId}"></ari:webComponent>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_shipping_telephone}" labelKey="client_telephone" value="${dataImage.shippingTelephone}" origValue="${origDataImage.shippingTelephone}"></ari:webComponent>
				</tr>
				
				<tr>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_shipping_method_id}" labelKey="order_shipping_method" value="${dataImage.shippingMethodId}" origValue="${origDataImage.shippingMethodId}"></ari:webComponent>								
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_payment_method_id}" labelKey="order_payment_method" value="${dataImage.paymentMethodId}" origValue="${origDataImage.paymentMethodId}"></ari:webComponent>
				</tr>				
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_remark}" value="${dataImage.remark}" origValue="${origDataImage.remark}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_total}" value="${dataImage.total}" origValue="${origDataImage.total}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_status}" choiceList="${orderStatusList}" value="${dataImage.status.value}" origValue="${origDataImage.status.value}"></ari:webComponent></tr>
				<tr>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_currency_id}" value="${dataImage.currencyId}" origValue="${origDataImage.currencyId}"></ari:webComponent>
					<ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_currency_code}" value="${dataImage.currencyCode}" origValue="${origDataImage.currencyCode}"></ari:webComponent>
				</tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_currency_value}" value="${dataImage.currencyValue}" origValue="${origDataImage.currencyValue}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_create_timestamp}" value="${dataImage.createTimestamp}" origValue="${origDataImage.createTimestamp}"></ari:webComponent></tr>
				<tr><ari:webComponent bundle="${label}" pageMode="${pageMode}" webComponent="${order_last_modified_timestamp}" value="${dataImage.lastModifiedTimestamp}" origValue="${origDataImage.lastModifiedTimestamp}"></ari:webComponent></tr>
				
				
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

							<c:if test="${action == 'CreateOrderRequest'}">	
								<fmt:message key="common_create" bundle="${labelLang}"/>
							</c:if>
							<c:if test="${action == 'UpdateOrderRequest'}">	
								<fmt:message key="common_update" bundle="${labelLang}"/>
							</c:if>
							<c:if test="${action == 'ConfirmOrderRequest'}">	
								<fmt:message key="common_confirm" bundle="${labelLang}"/>
							</c:if>
						</div>
						</c:if>
					</td>
				</tr>
				</c:if>
			</table>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp" flush="true"/>
</div>

<jsp:include page="common-script.jsp" flush="true"/>

<script>

var errorMessage = '';

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

$('#order_image').on('change', function(){
	
	readImageURL( '#order_image' );
	
});

$(document).on('click', '.btn_remove', function(){
	
	$(this).closest('.product_data_row').remove();
	
	refreshDetailsListSetting();
	
});

$('.btn_add_row').on('click', function(){
	
	var sourceCodeSelector = $(this).attr('data-add-row-html-source');
	var sourceCode = $('#' + sourceCodeSelector ).html();
	var targetSelector = $(this).attr('data-add-row-target');
	
	$('#' + targetSelector ).append( sourceCode );
	
	refreshDetailsListSetting();
	
});

function refreshDetailsListSetting(){
	
	refreshDetailsListSettingWithSelector( '#corporate_action_event_table .product_data_row' );

}

function refreshDetailsListSettingWithSelector( tableSelector ){
	
	var index = 0;
	
	$(document).find( tableSelector ).each( function(){
		
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
			
			if ( $( this).hasClass('numberInput') ){
				
				$( this ).autoNumeric('init');
				
			}
			
		});
		
		$(this).find('.btn_remove').each( function(){
			
			var currKey = $( this ).data('key');
			
			$( this ).attr('id', currKey + '_' + index);
			
		});

		index ++;
	});
	
}

</script>

</body>
</html>