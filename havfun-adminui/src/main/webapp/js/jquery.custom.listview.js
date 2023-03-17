/**
 * @license jQuery paging plugin v1.0.0 15/12/2014
 *
 * Copyright (c) 2011, Ray Cheng (rcheng@aristo.hk)
 **/


(function ( $, window, document, undefined ) {
	
	var self = this;
	
	var pluginName = 'listview',
		defaults = {
			refresh_fn: null,
			num_of_pages: 5,
			test_text: 'default',
			all: false
    };
	var options = {};
	
	function Plugin( element, _options ){
		this.element = $(element);
		options = $.extend( {}, defaults, _options );
		this._defaults = defaults;
		this._name = pluginName;
		
		this.element.on('updateSortColumnList', function( event, index ){
			updateSortColumnList( index );
		});
		
		$(document)
			.on('refresh', function(){
				if ( _options.refresh_fn != null && _options.refresh_fn != "" ){
					
					var url_value_str = getUpdateDataURL();
					_options.refresh_fn.call( this, { url_value: url_value_str} );
				}
			})

			.on('click', '.btn_page_first', function(event) {
				if ( $(this).css('opacity') == 1){
					
					updateCurrPageWithMode('First');
					
					if ( _options.refresh_fn != null && _options.refresh_fn != "" ){
						var url_value_str = getUpdateDataURL();
						_options.refresh_fn.call( this, { url_value: url_value_str} );
					}				
				}
			})

			.on('click', '.btn_page_last', function(event) {
				if ( $(this).css('opacity') == 1){
					
					updateCurrPageWithMode('Last');
					
					if ( _options.refresh_fn != null && _options.refresh_fn != "" ){
						var url_value_str = getUpdateDataURL();
						_options.refresh_fn.call( this, { url_value: url_value_str} );
					}				
				}
			})

			.on('click', '.btn_page_next', function(event) {
				if ( $(this).css('opacity') == 1){
					
					updateCurrPageWithMode('Next');
					
					if ( _options.refresh_fn != null && _options.refresh_fn != "" ){
						var url_value_str = getUpdateDataURL();
						_options.refresh_fn.call( this, { url_value: url_value_str} );
					}		
				}
			})

			.on('click', '.btn_page_previous', function(event) {
				if ( $(this).css('opacity') == 1){
					updateCurrPageWithMode('Previous');

					if ( _options.refresh_fn != null && _options.refresh_fn != "" ){
						var url_value_str = getUpdateDataURL();
						_options.refresh_fn.call( this, { url_value: url_value_str} );
					}
				}
			})

			.on('click', '.btn_page', function(event) {
				var page = parseInt( $(this).text());		

					updateCurrPageWithMode('Page', page);

					if ( _options.refresh_fn != null && _options.refresh_fn != "" ){
						var url_value_str = getUpdateDataURL();
						_options.refresh_fn.call( this, { url_value: url_value_str} );
					}
			})
			
			.on('click', '.btn_page_go', function(){
				
				var checkNo = /[^0-9]/g;
				var matchVar = $(this).next($('.btn_page_input')).val().match( checkNo );
				
				if($(this).next('.btn_page_input').val() != "" && matchVar == null ){
					if( parseInt( $(this).next('.btn_page_input').val() ) == 0 ){
						
						onClickChangePage( "?page=1&filterType=" + $('#filterType').val() );
						
					}else if( $(this).next('.btn_page_input').val() > $('#keyframe').data('maxPage') ){
						
						onClickChangePage( "?page=" + $('#keyframe').data('maxPage') + "&filterType=" + $('#filterType').val() );
						
					}else{
						
						onClickChangePage( "?page=" + $(this).next('.btn_page_input').val() + "&filterType=" + $('#filterType').val() );
						
					}
					
					$('.btn_page_input').css('background', 'url(img/btn_page.png) no-repeat 0 0');
					$('.btn_page_input').val("");
					
				}else{
					$('.btn_page_input').css('background', 'url(img/btn_page_error.png) no-repeat 0 0');
					var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
					$('.btn_page_input').addClass('animated shake').one(animationEnd, function() {
						$('.btn_page_input').removeClass('animated shake');
			        });
				}
			})
			
			.on('keydown', '.btn_page_input', function(e){
				if(e.keyCode == 13){
					//$(this).css('background', 'url(img/btn_page.png) no-repeat 0 0');
					$(this).prev($('.btn_page_go')).click();
				}
			})
			
			.on('click', '.btn_page_input', function(){
				$('.btn_page_input').css('background', 'url(img/btn_page.png) no-repeat 0 0');
				$('.btn_page_input').val("");
			})

			.on('mouseenter', '.btn_page_next, .btn_page_last, .btn_page_previous, .btn_page_first', function() {
				if ( $(this).css('opacity') == 1){
					$(this).css('background-position', '0px -32px');
				}
			})

			.on('mouseleave', '.btn_page_next, .btn_page_last, .btn_page_previous, .btn_page_first', function() {
				$(this).css('background-position', '0px 0px');
			})

			.on('mouseenter', '.btn_page, .btn_page_go, .btn_page_input', function() {
				if ( parseInt( $(this).text() ) != $(element).data('currPage') ){
					$(this).css('background-position', '0px -32px');
				}
			})

			.on('mouseleave', '.btn_page, .btn_page_go, .btn_page_input', function() {
				if ( parseInt( $(this).text() ) != $(element).data('currPage') ){
					$(this).css('background-position', '0px 0px');
				}
			});

		this.init();
		
		function updateCurrPageWithMode( mode, newPage ){
			var origPage = $(element).data('currPage');
			var maxPage = $(element).data('maxPage');
			
			//alert( 'updateCurrPageWithMode: curr '+ origPage);
			//alert( 'updateCurrPageWithMode: max '+ maxPage);
			
			if ( origPage == null )origPage = 1;
			if ( maxPage == null ) maxPage = 1;
						
			if ( mode == 'First')origPage = 1;
			else if ( mode == 'Previous' )origPage --;
			else if ( mode == 'Next' )origPage ++;
			else if ( mode == 'Last' )origPage = maxPage;
			else if ( mode == 'Page'){				
				if ( newPage > 0 && newPage <= maxPage && newPage != origPage){
					origPage = newPage;
				}
			}
			
			if ( origPage > maxPage ){
				origPage = maxPage;
			}else if ( origPage < 1 ){
				origPage = 1;
			}
			
			$(element).data('currPage', origPage);			
		}		
		

		function updateSortColumnList(newColumnId){
			//Multi Sort
			
			var sortColumnList = $(element).data('sortColumnList');
			
			if ( sortColumnList == null ){
				sortColumnList = new Array(3);
				
				sortColumnList[0] = {columnId:0,isAcscend:0};
				sortColumnList[1] = {columnId:0,isAcscend:0};
				sortColumnList[2] = {columnId:0,isAcscend:0};
			}
			
			var t_column = 0;
			var t_acscend = 0;
			var isExit = false;
			for ( var i = 0; i < 3; i ++ ){
				tt_column = t_column;
				tt_acscend = t_acscend;
				
				t_column = sortColumnList[i].columnId;
				t_acscend = sortColumnList[i].isAcscend;			

				if ( i == 0 ){			
					if ( sortColumnList[i].columnId == newColumnId){				
						sortColumnList[i].columnId = newColumnId;
						sortColumnList[i].isAcscend = sortColumnList[i].isAcscend==0?1:0;			
						isExit = true;						
					}else{
						sortColumnList[i].columnId = newColumnId;
						sortColumnList[i].isAcscend = 0;								
					}				
				}else{			
					if ( sortColumnList[i].columnId == newColumnId){
						sortColumnList[0].isAcscend = sortColumnList[i].isAcscend;
						isExit = true;		
					}
					sortColumnList[i].columnId = tt_column;
					sortColumnList[i].isAcscend = tt_acscend;				
				}
				
				if (isExit ){
					i = 10;
				}
			}		
			
			$(element).data("sortColumnList", sortColumnList);
		}
		
		function getUpdateDataURL(){
			
			var specificId = $(element).find("#specificId").val();
			var specificName = $(element).find("#specificName").val();
			var filterType = $(element).find("#filterType").val();
			
			var _currPage = $(element).data('currPage');
			
			if ( _currPage == null )_currPage = 1;		
			
			var url = "?page="+_currPage;
			
			if ( specificId != null && specificId != ""){
				url += "&specificId="+specificId;
			}
			
			if ( specificName != null  && specificName != ""){
				url += "&specificName=" + specificName;
			}
			
			if ( filterType != null && filterType != ""){
				url += "&filterType="+filterType;
			}
			
			
			return url;
		}		
	} 
	
	var methods = {
        init: function(option) {
            return this.each(function() {
                $(this).data("currPage", self.currPage);
                $(this).data("maxPage", maxPage);
            });
        },
        setCurrPage: function(page) {
            return this.each(function() {
                $(this).data("currPage", page);
            });
        },
        getCurrPage: function(page) {
        	return $(this).data("currPage");
        },
        setMaxPage: function(page) {
            return this.each(function() {
                $(this).data("maxPage", page);
            });
        },
        setTotalRecord: function(record) {
            return this.each(function() {
                $(this).data("totalRecord", record);
            });
        },
        refreshPage: function(){
        	return this.each(function() {
                $(this).trigger('refresh');
            });
        },
        changeClientPage: function(){
        	return this.each(function(){
        		$(this).data("currPage", 1);
        		$(this).trigger('refresh');
        	});
        },
        onClickSortColumn: function( index){
        	return this.each(function() {
                $(this).data("currPage", 1);
                $(this).trigger('updateSortColumnList', [index]);
                $(this).trigger('refresh');
            });
        }        
    };
	
	Plugin.prototype.init = function(){
		
	};

	//Ready change page
	//1.Update new current page
	//2.Go server find new date
//	Plugin.prototype.changePageWithMode = function( mode ){
	function changePageWithMode( mode ){

		updateCurrPageWithMode(mode);

		
		if ( options.refresh_fn != null && options.refresh_fn != "" ){
			//alert(' listview this.options.refresh_fn != null' );
			
			var url_value = getUpdateDataURL();
			options.refresh_fn.call( this, {url_value: url_value} );
		}
	}
		
	// A really lightweight plugin wrapper around the constructor,
    // preventing against multiple instantiations
    $.fn["listview"] = function ( options ) {
    	if (methods[options]) {
            return methods[options].apply(this, Array.prototype.slice.call(arguments, 1));
        }else{ 
	        return this.each(function () {
	            if ( !$.data(this, "plugin_" + pluginName )) {
	                $.data( this, "plugin_" + pluginName,
	                new Plugin( this, options ));
	            }
	        });
        }
    };
    
	
	
		
	$.fn.updatePrevNextButton = function( _currPage, _maxPage, _showPageBlock ){
		
		_showPageBlock = typeof _showPageBlock !== 'undefined' ? _showPageBlock : 5;
		
		$(this).find(".btn_page_first").text("1");
		$(this).find(".btn_page_last").text(_maxPage);
		
		//Set Previous Next button
		if ( _currPage != 1 ){
			$(this).find(".btn_page_first").css({ opacity: 1.0 });
			$(this).find(".btn_page_first").css( 'cursor', 'pointer' );			
			$(this).find(".btn_page_previous").css({ opacity: 1.0 });
			$(this).find(".btn_page_previous").css( 'cursor', 'pointer' );
		}else{
			$(this).find(".btn_page_first").css({ opacity: 0.5 });
			$(this).find(".btn_page_first").css( 'cursor', 'default' );						
			$(this).find(".btn_page_previous").css({ opacity: 0.5 });
			$(this).find(".btn_page_previous").css( 'cursor', 'default' );
		}
		
		if ( _currPage != _maxPage ){
			$(this).find(".btn_page_last").css({ opacity: 1.0 });
			$(this).find(".btn_page_last").css( 'cursor', 'pointer' );						
			$(this).find(".btn_page_next").css({ opacity: 1.0 });
			$(this).find(".btn_page_next").css( 'cursor', 'pointer' );
		}else{
			$(this).find(".btn_page_last").css({ opacity: 0.5 });
			$(this).find(".btn_page_last").css( 'cursor', 'default' );									
			$(this).find(".btn_page_next").css({ opacity: 0.5 });
			$(this).find(".btn_page_next").css( 'cursor', 'default' );
		}		
		
		
		//Set Page Button Hide Show
		if ( _maxPage == 1 ){
			$(this).find(".btn_page_first").hide();
			$(this).find(".btn_page_last").hide();			
			$(this).find(".btn_page_previous").hide();
			$(this).find(".btn_page_next").hide();
			$(this).find(".btn_page").hide();	
			$(this).find(".btn_page_go").hide();
			$(this).find(".btn_page_input").hide();	
		}else if( _maxPage <= _showPageBlock){
			$(this).find(".btn_page_first").show();
			$(this).find(".btn_page_last").show();					
			$(this).find(".btn_page_previous").show();
			$(this).find(".btn_page_next").show();		
			$(this).find(".btn_page_go").show();
			$(this).find(".btn_page_input").show();		
			for ( var i=1; i <= _showPageBlock; i ++){
				if ( i <= _maxPage){
					$(this).find('.btn_page_'+i).show();
				}else{
					$(this).find('.btn_page_'+i).hide();				
				}
			}		
		}else {
			$(this).find(".btn_page_first").show();
			$(this).find(".btn_page_last").show();								
			$(this).find(".btn_page_previous").show();
			$(this).find(".btn_page_next").show();
			$(this).find(".btn_page").show();		
			$(this).find(".btn_page_go").show();
			$(this).find(".btn_page_input").show();		
		}
		
		//Set Page Button Text
		if ( _showPageBlock == 1 ){
			$(this).find('.btn_page_1').text( _currPage );
			$(this).find('.btn_page_1').css("border-color", "#0099da");
			$(this).find('.btn_page_1').css('background-position', '0px -32px');
			$(this).find('.btn_page_1').css('color', '#0099da');
			$(this).find('.btn_page_1').css('font-size', '14px');		
			$(this).find('.btn_page_1').css( 'cursor', 'default' );
			
		}
		else if ( _maxPage <= _showPageBlock){
			for ( var i=1; i <= _showPageBlock; i ++){
				$(this).find('.btn_page_'+i).text(i);
				
				if ( (i) == _currPage ){
					$(this).find('.btn_page_'+i).css("border-color", "#0099da");
					$(this).find('.btn_page_'+i).css('background-position', '0px -32px');
					$(this).find('.btn_page_'+i).css('color', '#0099da');
					$(this).find('.btn_page_'+i).css('font-size', '14px');		
					$(this).find('.btn_page_'+i).css( 'cursor', 'default' );
				}else{
					$(this).find('.btn_page_'+i).css("border-color", "#ffffff");
					$(this).find('.btn_page_'+i).css('background-position', '0px 0px');
					$(this).find('.btn_page_'+i).css('color', '#444444');
					$(this).find('.btn_page_'+i).css('font-size', '12px');		
					$(this).find('.btn_page_'+i).css( 'cursor', 'pointer' );
				}
			}
		}else{
			var firstPage = _currPage - parseInt(_showPageBlock/2);
			var lastFirstPage = _maxPage-(_showPageBlock-1);
			if ( firstPage < 1 ) firstPage = 1;
			else if ( firstPage > lastFirstPage )firstPage = lastFirstPage;
			
			for ( var i=1; i <= _showPageBlock; i ++){
				$(this).find('.btn_page_'+i).text(firstPage+(i-1));
				if ( (firstPage+(i-1)) == _currPage ){
					$(this).find('.btn_page_'+i).css("border-color", "#0099da");
					$(this).find('.btn_page_'+i).css('background-position', '0px -32px');
					$(this).find('.btn_page_'+i).css('color', '#0099da');
					$(this).find('.btn_page_'+i).css('font-size', '12px');			
					$(this).find('.btn_page_'+i).css( 'cursor', 'default' );
				}else{
					$(this).find('.btn_page_'+i).css("border-color", "#ffffff");
					$(this).find('.btn_page_'+i).css('background-position', '0px 0px');
					$(this).find('.btn_page_'+i).css('color', '#444444');
					$(this).find('.btn_page_'+i).css('font-size', '11px');			
					$(this).find('.btn_page_'+i).css( 'cursor', 'pointer' );
				}
			}
		}

	};
	
	$.fn.updateSortColumnIcon = function( _list, _clear_size){
		for ( var i = 0; i < _clear_size; i ++){
			imageUrl = "img/Sorting/sorting_none.png";				
			$(this).find("#columnArrow_"+(i+1)).css('background', 'url(' + imageUrl + ')');	
		}

		for ( var i = 0; i < _list.length; i ++){
			var sortColumnSet = _list[i];
			if ( sortColumnSet.columnId != 0 ){ 
//				alert("sortColumnSet: "+sortColumnSet[0] +" : "+ sortColumnSet[1]);
				
				var _id = sortColumnSet.columnId;
				var _isAcscend = sortColumnSet.isAcscend;
				
				if ( _isAcscend == 0 ){
					var _url = "img/Sorting/sorting_down_"+(i+1)+".png";
					$(this).find("#columnArrow_"+_id).css('background', 'url(' + _url + ')');								
				} else{
					var _url = "img/Sorting/sorting_up_"+(i+1)+".png";								
					$(this).find("#columnArrow_"+_id).css('background', 'url(' + _url + ')');				
				}
			}
		}
	};
	
})( jQuery, window, document );