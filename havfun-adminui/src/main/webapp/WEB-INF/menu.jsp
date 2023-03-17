<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/Descriptor.tld" prefix="ari" %>
<fmt:setLocale value="${SelectedLang}" scope="request"/>
<fmt:setBundle basename="Label" var="labelLang" />
<fmt:setBundle basename="Menu" var="menuLang"/>
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.resmenu.min.js"></script>
<script>
    $(window).ready(function () {
        $('#menu').ReSmenu();
    });
    
    $(document).ready(function(){
    	$(window).ready(function () {
    	    $('.toresponsive').ReSmenu({
    	    menuClass:    'responsive_menu',   // Responsive menu class
    	    selectId:     'resmenu',          // select ID
    	    textBefore:   false,               // Text to add before the mobile menu
    	    selectOption: false,               // First select option
    	    activeClass:  'current-menu-item', // Active menu li class
    	    maxWidth:     480                  // Size to which the menu is responsive
    		});
    	});
    });
    
    $(function() {

    	$( "#searchBox" ).autocomplete({
	            open: function(){
	                $('.ui-autocomplete').css('width', '320px');
	            },
				source: function( request, response ) {
					$.ajax({
						  dataType: "json",
						  url: "SearchInstrumentCode?term=" +request.term
					  })
					  .done (function(data) {
						  console.log(data);
						  var display_list = new Array();
						  for ( var i = 0; i < data.length; i ++ ){
							  var item = data[i];							  
							  var lang = "${SelectedLang}";
							  var name = "";
							  
							  if ( lang == 'en')name = item.securityShortName;
							  else if ( lang == 'zh_HK') name = item.securityNameGCCS;
							  else if ( lang == 'zh_CN') name = item.securityNameGB;

							  
							  var displayObj = {
							  "label":item.instrumentCode,
							  "name":name,
							  "value":item.instrumentCode};

							  
							  display_list[i] = displayObj;
						  }
						  
						  response(display_list);
						  //response(data);
						});					
		        },
		        search: function() {
		          // custom minLength
					var intRegex = /[0-9 -()+]+$/;
				  if ( this.value.match(intRegex)){
//		          if ( this.value.length < 1 ) {
		            return false;
		          }
		        },create: function () {
		        	
	                  $(this).data('ui-autocomplete')._renderItem = function (ul, item) {
	                      return $('<li>')
	                          .append('<a><div style=\"float:left;width:100px;\">' + item.label + '</div><div style=\"float:left;width:200px;\">' + item.name + '</div></a>')
	                          .appendTo(ul);
	                  }
		        },select: function( event, ui ) {
		        	var code = (ui.item.value).replace(".XHKG", "");
					window.location.href = "Security?code="+code;
			    }
     		}); 
    	
		// Hover states on the static widgets
   		$( "#dialog-link, #icons li" ).hover(
   			function() {
   				$( this ).addClass( "ui-state-hover" );
   			},
   			function() {
   				$( this ).removeClass( "ui-state-hover" );
   			}
   		);
    });
</script>
<div id="menubar">
	<c:if test="${not empty ActionMap['MenuSearch']}">
		<form id="searchform" action="${searchAction}" method="post">
			<div id="search">
				<div style="float:left;"><fmt:message key="common_search" bundle="${labelLang}"/></div>
				<div class="search_wrapper"  style="float:left;">
					<input id="searchBox" tabindex="1" name="code" type="text" class="search_input" placeholder="Stock code/ Name" size="19" maxlength="20" style="float:left;margin-top:10px;">
					<a class="search_icon" style="float:left;margin-top:10px;"></a>
				</div>
			</div>
		</form>
	</c:if>
	<div class="menu_container">
		<ul class="toresponsive" id="menu">
		<c:forEach items="${Menu}" var="menu">
			<li <ari:selectedMenu menu="${menu.key}" selectedMenu="${SelectedMenu}" />><a <ari:selectedMenu menu="${menu.key}" selectedMenu="${SelectedMenu}" /> href="${menu.url}"><fmt:message key="${menu.key}" bundle="${menuLang}"/></a>
				<ul style="	z-index: 100;">
				<c:forEach items="${menu.subMenuList}" var="subMenu">
					<li <ari:selectedMenu menu="${subMenu.key}" selectedMenu="${SelectedSubMenu}" />><a <ari:selectedMenu menu="${subMenu.key}" selectedMenu="${SelectedSubMenu}" /> href="${subMenu.url}"><fmt:message key="${subMenu.key}" bundle="${menuLang}"/></a></li>
				</c:forEach>
				</ul>
			</li>
		</c:forEach>
		</ul>
	</div>
</div>
<script>

$('.search_icon').on('click', function(){
	window.location.href = "Search?keyword="+$('#searchBox').text();
});


$('#searchBox').bind("enterKey", function(e){
	$('#searchform').submit();
});
$('#searchBox').keydown(function(e) {
	if (e.keyCode == 13)
	{
		$(this).trigger("enterKey");
	}
});
</script>