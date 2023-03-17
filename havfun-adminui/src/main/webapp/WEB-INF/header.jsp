<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ari" uri="/WEB-INF/Descriptor.tld" %>
<fmt:setLocale value="${SelectedLang}" scope="request"/>
<fmt:setBundle basename="Message" var="msgLang"/>
<fmt:setBundle basename="Label" var="labelLang"/>

<script type="text/javascript" src="js/autoNumeric-min.js"></script>

<div id="header">
	<div id="logo"></div>
	<div class="header_item">
		<div id="language">
			<c:choose>
				<c:when test="${SelectedLang == 'zh_HK'}">
					<span style="color:#0099da;">繁體</span> 
				</c:when>
				<c:otherwise>
					<a href="${URL_ZH_HK}">繁體</a> 
				</c:otherwise>
			</c:choose>
			<img src="img/lang_sep.gif" width="19" height="8">
			<c:choose>
				<c:when test="${SelectedLang == 'zh_CN'}">
					<span style="color:#0099da;">簡體</span> 
				</c:when>
				<c:otherwise>
					<a href="${URL_ZH_CN}">簡體</a> 
				</c:otherwise>
			</c:choose> 
			<img src="img/lang_sep.gif" width="19" height="8">
			<c:choose>
				<c:when test="${SelectedLang == 'en'}">
					<span style="color:#0099da;">English</span> 
				</c:when>
				<c:otherwise>
					<a href="${URL_EN}">English</a> 
				</c:otherwise>
			</c:choose> 
		</div>
		<div id="datetime"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" timeZone="Asia/Hong_Kong" value="${Now}" /></div>
		<div class="clear"></div>
		<c:choose>
			<c:when test="${Login == 'true'}">
				<div id="log"><img src="img/lang_sep.gif" width="19" height="8"> <a href="Logout"><fmt:message key="login_logout" bundle="${labelLang}"/></a></div>
				<div id="user"><img src="img/lang_sep.gif" width="19" height="8"><fmt:message key="login_hi" bundle="${labelLang}"/> ${UserName}</div>
				
			</c:when>
			<c:otherwise>
				<div id="log"><a href="Login"><fmt:message key="login" bundle="${labelLang}"/></a></div>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div class="clear"></div>

<script>

jQuery(function($) {
    $('.numberInput').autoNumeric('init');
});

</script>